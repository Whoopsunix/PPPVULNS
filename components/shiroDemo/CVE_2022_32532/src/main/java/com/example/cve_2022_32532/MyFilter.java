package com.example.cve_2022_32532;

import org.apache.shiro.util.RegExPatternMatcher;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter extends AccessControlFilter {

    public MyFilter(){
        super();
        this.pathMatcher = new RegExPatternMatcher();
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        String token = ((HttpServletRequest)request).getHeader("Token");
        return token != null && token.equals("ppp");
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        System.out.println("deny "+((HttpServletRequest)request).getRequestURI());
        try {
            response.getWriter().println("access denied");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}