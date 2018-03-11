package com.security.demo.securitydemo.config;

import com.security.demo.securitydemo.filter.WebFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义部分过滤(试用springboot引用第三方的过滤器)
 */
//@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean webFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        WebFilter webFilter = new WebFilter();
        filterRegistrationBean.setFilter(webFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/haha");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }
}
