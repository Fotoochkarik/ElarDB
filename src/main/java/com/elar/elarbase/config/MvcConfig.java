package com.elar.elarbase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/add").setViewName("add-form");
//        registry.addViewController("/login").setViewName("login.ftl");
//        registry.addViewController("/main").setViewName("main");
//        registry.addViewController("/registration").setViewName("registration");
//        registry.addViewController("/greeting").setViewName("greeting");
//        registry.addViewController("/report").setViewName("reportList");
//        registry.addViewController("device").setViewName("device");
    }
}
