# 靶场记录

By. Whoopsunix

不定时更新在研究漏洞时搭的环境

# 组件漏洞

+ Fastjson
    + [24-80 POC check](components/fastjsonDemo)
+ [jackson](components/jacksonDemo)
+ Apache
    + Shiro
        + [CVE-2022-32532 Apache Shiro RegExPatternMatcher](components/Apache/shiroDemo/CVE_2022_32532)
    + JXPath
        + [CVE-2022-41852 Apache Commons JXPath 远程代码执行漏洞](components/Apache/jxpathDemo)
    + KafKa
        + [Apache Kafka Connect CVE-2023-25194 远程代码执行漏洞](components/Apache/KafKaDemo)
    + log4j
        + [CVE-2021-44228 Apache Log4j 任意代码执行漏洞](components/Apache/log4j/CVE-2021-44228)
+ Spring
    + Spring Security
        + [CVE-2022-22978 Spring Security认证绕过](components/SpringDemo/springSecurityDemo/CVE-2022-22978)
        + [CVE-2022-31692 Spring Security forward/include 认证绕过](components/SpringDemo/springSecurityDemo/CVE-2022-31692])
    + MongoDB
        + [CVE-2022-22980 Spring Data MongoDB SpEL表达式注入](components/SpringDemo/springDataDemo/CVE-2022-22980)
    + Spring Cloud
        + [CVE-2022-22947 Spring Cloud Gateway Actuator API SpEL表达式注入](components/SpringDemo/SpringCloudDemo/CVE_2022_22947)
    + springboot
        + [SpringBootVulExploit by LandGrey](https://github.com/LandGrey/SpringBootVulExploit)
    + [CVE-2018-1270 Spring spring-messaging 远程命令执行漏洞](components/SpringDemo/SpringMessagingDemo)
+ [XStream 系列](components/XStreamDemo)
+ structs2
    + [s2-001](components/structs2Demo/s2-001)
    + [s2-008](components/structs2Demo/s2-008)
+ others
    + h2
        + [CVE-2021-23463 H2 Database 任意文件读取漏洞](components/others/h2database/CVE-2021-23463)

