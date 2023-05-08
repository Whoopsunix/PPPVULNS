# 靶场记录

By. Whoopsunix

不定时更新在研究漏洞时搭的环境

复现的时候刷到这个项目 [SBCVE](https://github.com/TheKingOfDuck/SBCVE) 就....强烈的共鸣

## 通用漏洞环境



## 组件环境

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
    + [CVE-2021-29505 XStream < 1.4.17 ](XStreamDemo/Demo)
    + [CVE-2021-21351 XStream < 1.4.16 ](XStreamDemo/Demo)
    + [CVE-2021-21350 XStream < 1.4.16 ](XStreamDemo/Demo)
    + [CVE-2021-21349 XStream < 1.4.16 ](XStreamDemo/Demo)
    + [CVE-2021-21348 XStream < 1.4.16 ](XStreamDemo/Demo)
    + [CVE-2021-21347 XStream < 1.4.16 ](XStreamDemo/Demo)
    + [CVE-2021-21346 XStream < 1.4.16 ](XStreamDemo/Demo)
    + [CVE-2021-21345 XStream < 1.4.16 ](XStreamDemo/Demo)
    + [CVE-2021-21344 XStream < 1.4.16 ](XStreamDemo/Demo)
    + [CVE-2021-21343 XStream < 1.4.16 ](XStreamDemo/Demo)
    + [CVE-2021-21342 XStream < 1.4.16 SSRF漏洞](XStreamDemo/Demo)
    + [CVE-2021-21341 XStream < 1.4.16 DOS漏洞](XStreamDemo/Demo)
    + [CVE-2020-26259 XStream < 1.4.15 ](XStreamDemo/Demo)
    + [CVE-2020-26258 XStream < 1.4.15 ](XStreamDemo/Demo)
    + [CVE-2020-26217 XStream < 1.4.14 ](XStreamDemo/Demo)
    + [CVE-2017-7957 XStream < 1.4.10](XStreamDemo/Demo)
    + [CVE-2016-3674 XStream < 1.4.9](XStreamDemo/Demo)
    + [CVE-2013-7285 XStream < 1.4.6](XStreamDemo/Demo)
+ structs2
  + [s2-001](structs2Demo/s2-001)
  + [s2-008](structs2Demo/s2-008)
+ others
    + h2
      + [CVE-2021-23463 H2 Database 任意文件读取漏洞](h2Demo/CVE-2021-23463)
    + log4j
      + [CVE-2021-44228 Apache Log4j 任意代码执行漏洞](log4jDemo/CVE-2021-44228)







