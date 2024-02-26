# PPPVULNS

By. Whoopsunix

不定时记录研究时搭的漏洞环境，附源码、 REST 文件，有必要的会提供复现分析文章（项目内或 [WIKI](https://whoopsunix.com)）

# 组件漏洞

- [Fastjson 1.2.24-1.2.80](components/Fastjson)
- [Jackson](components/jacksonDemo)
- Apache Dubbo 全系列(分析见WIKI)
    - [CVE-2019-17564 Apache Dubbo Provider http 协议反序列化漏洞](components/Apache%20Dubbo/CVE-2019-17564)
    - [CVE-2020-1948 Apache Dubbo Provider dubbo 协议反序列化漏洞](components/Apache%20Dubbo/DubboDemo)
    - [CVE-2020-11995 Apache Dubbo 代码问题漏洞](components/Apache%20Dubbo/DubboDemo)
    - [CVE-2021-25641 Apache Dubbo 可信数据反序列化（弱验证器）](components/Apache%20Dubbo/DubboDemo)
    - [CVE-2021-30179 Apache Dubbo Generic filter 远程代码执行漏洞](components/Apache%20Dubbo/DubboDemo)
    - CVE-2021-30180 Apache Dubbo Tag routing Yaml pre-auth 反序列化漏洞
        - [TagRuleParser](components/Apache%20Dubbo/DubboTagrouterDemo)
        - [ConditionRuleParser](components/Apache%20Dubbo/DubboConfigconditionrouterDemo)
        - [ConfigParser](components/Apache%20Dubbo/DubboConfigParserDemo)
    - [CVE-2021-30181 Apache Dubbo cluster scriptEngine pre-auth 代码执行漏洞](components/Apache%20Dubbo/DubboScriptRouterDemo)
    - [CVE-2021-32824 Telnet Handler 反序列化漏洞](components/Apache%20Dubbo/DubboDemo)
    - [CVE-2021-36162 Apache Dubbo Mesh Yaml pre-auth 反序列化漏洞](components/Apache%20Dubbo/DubboMeshRuleDemo)
    - [CVE-2021-36163 Apache Dubbo Hessian2 协议反序列化漏洞](components/Apache%20Dubbo/DubboServletHessian)
    - [CVE-2021-37579 Apache Dubbo 反序列化安全检查绕过](components/Apache%20Dubbo/DubboDemo)
    - [CVE-2021-43297 Apache Dubbo Hessian-Lite 反序列化漏洞](components/Apache%20Dubbo/DubboDemo)
    - [CVE-2022-39198 Apache Dubbo Hessian-Lite 反序列化漏洞](components/Apache%20Dubbo/DubboDemo)
    - [CVE-2023-23638 Apache Dubbo 反序列化漏洞](components/Apache%20Dubbo/DubboDemo)
- Apache Shiro
    - [CVE-2022-32532 Apache Shiro RegExPatternMatcher 权限绕过漏洞](components/Apache%20Shiro/CVE-2022-32532)
- Apache Tapestry
    - [CVE-2021-27850 Apache Tapestry 文件读取与反序列化漏洞](components/Apache%20Tapestry/CVE-2021-27850)
- Apache Commons JXPath
    - [CVE-2022-41852 Apache Commons JXPath 远程代码执行漏洞](components/Apache%20Commons%20JXPath/CVE-2022-41852)
- Apache Kafka
    - [CVE-2023-25194 Apache Kafka Connect 远程代码执行漏洞](components/Apache%20KafKa/CVE-2023-25194)
- Apache Log4j2
    - [CVE-2021-44228 Apache Log4j2 任意代码执行漏洞](components/Apache%20Log4j2/CVE-2021-44228)
- Spring Security
    - [CVE-2022-31692 Spring Security forward/include 认证绕过](components/Spring%20Security/CVE-2022-31692)
    - [CVE-2022-22978 Spring Security认证绕过](components/Spring%20Security/CVE-2022-22978)
- Spring Data MongoDB
    - [CVE-2022-22980 Spring Data MongoDB SpEL表达式注入](components/Spring%20Data%20MongoDB/CVE-2022-22980)
- Spring Cloud
    - [CVE-2022-22947 Spring Cloud Gateway Actuator API SpEL表达式注入](components/Spring%20Cloud/CVE-2022-22947)
- [SpringBootVulExploit by LandGrey](https://github.com/LandGrey/SpringBootVulExploit)
- spring-messaging
    - [CVE-2018-1270 & CVE-2018-1275 Spring spring-messaging 远程命令执行漏洞](components/spring-messaging/CVE-2018-1270)
- [ff4j](components/ff4j)
- [XStream 系列](components/XStreamDemo)
- structs2
    - [s2-001](components/structs2/s2-001)
    - [s2-008](components/structs2/s2-008)
- h2database
    - [CVE-2021-23463 H2 Database 任意文件读取漏洞](components/h2database/CVE-2021-23463)

# 组件 sink 点记录

- Apache MINA
    - [CVE-2022-45047 Apache MINA 代码问题](sinks/MINASSHDDemo)

# Stats

![Alt](https://repobeats.axiom.co/api/embed/b08ab16cbdbcc2cfff679651c882b6c1b7d96928.svg "Repobeats analytics image")