package com.elar.elarbase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("main.ftl");
        registry.addViewController("/registration").setViewName("registration.ftl");
        registry.addViewController("/greeting").setViewName("greeting.ftl");
    }
}
