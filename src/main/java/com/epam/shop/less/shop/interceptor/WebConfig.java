package com.epam.shop.less.shop.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    GuestInterceptor guestInterceptor;

    @Autowired
    UserInterceptor userInterceptor;

    @Autowired
    AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(guestInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login", "/registration");
        registry.addInterceptor(userInterceptor).addPathPatterns("/main/**");
        registry.addInterceptor(adminInterceptor).addPathPatterns("/main/**", "/admin/**");
    }
}