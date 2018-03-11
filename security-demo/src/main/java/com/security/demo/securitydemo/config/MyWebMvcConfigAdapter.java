package com.security.demo.securitydemo.config;

import com.security.demo.securitydemo.intercept.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 将自定义拦截器加到拦截器中
 */
@Configuration
public class MyWebMvcConfigAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor);
    }
}
