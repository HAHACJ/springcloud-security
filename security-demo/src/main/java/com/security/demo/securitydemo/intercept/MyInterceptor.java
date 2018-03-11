package com.security.demo.securitydemo.intercept;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 除了试用component还需其他配置
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println("pre");
        System.out.println("request: " + httpServletRequest);
        System.out.println("HttpServletResponse: " + httpServletResponse);

        System.out.println("Object: " + o);
        httpServletRequest.setAttribute("start", new Date().getTime());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("post");
        System.out.println("request: " + httpServletRequest);
        System.out.println("HttpServletResponse: " + httpServletResponse);

        long start = (long) httpServletRequest.getAttribute("start");
        System.out.println("耗时：" + (new Date().getTime() - start));

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("after");
        System.out.println("request: " + httpServletRequest);
        System.out.println("HttpServletResponse: " + httpServletResponse);

        System.out.println("obj: " + o);
        System.out.println("ex: " + e);

    }
}
