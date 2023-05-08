# 靶场记录

By. Whoopsunix

不定时更新在研究漏洞时搭的环境

复现的时候刷到这个项目 [SBCVE](https://github.com/TheKingOfDuck/SBCVE) 就....强烈的共鸣

## 已有环境

+ Fastjson
    + [24-80 POC check](fastjsonDemo)
+ Spring Security
    + [CVE-2022-22978 Spring Security认证绕过](springSecurityDemo/CVE-2022-22978)
    + [CVE-2022-31692 Spring Security forward/include 认证绕过](springSecurityDemo/CVE-2022-31692])
+ MongoDB
    + [CVE-2022-22980 Spring Data MongoDB SpEL表达式注入](springDataDemo/CVE-2022-22980)
+ Shiro
    + [CVE-2022-32532 Apache Shiro RegExPatternMatcher](shiroDemo/CVE_2022_32532)
+ Spring Cloud
    + [CVE-2022-22947 Spring Cloud Gateway Actuator API SpEL表达式注入](SpringCloudDemo/CVE_2022_22947)
+ XStream
    + [CVE-2020-26259 XStream 任意文件删除反序列化漏洞](XStreamDemo/Demo)
    + [CVE-2020-26258 XStream < 1.4.15 SSRF漏洞](XStreamDemo/Demo)
    + [CVE-2021-29505 XStream < 1.4.17 反序列化远程代码执行漏洞](XStreamDemo/CVE-2021-29505)
+ others
    + h2
      + [CVE-2021-23463 H2 Database 任意文件读取漏洞](h2Demo/CVE-2021-23463)







