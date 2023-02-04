package org.example;


import org.apache.shiro.util.AntPathMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.http.server.PathContainer;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @author Whoopsunix
 */
public class TestPar {
    @Test
    public void test() {
        boolean flag;
        String pattern = "/api/v1/**/";
        String path = "/api/v1/11";
        flag = new AntPathMatcher().match(pattern, path);
        System.out.println(flag);

        flag = new PathPatternParser().parse(pattern).matches(PathContainer.parsePath(path));
        System.out.println(flag);

    }
}

