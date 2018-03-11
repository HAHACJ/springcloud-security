package com.security.demo.securitydemo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 过滤器
 */
@Component
public class WebFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter!");
        filterChain.doFilter(servletRequest, servletResponse);
        long start = new Date().getTime();
        System.out.println("耗时：" + (new Date().getTime() - start));

    }

    @Override
    public void destroy() {
        System.out.println("destroy!");
    }
}
