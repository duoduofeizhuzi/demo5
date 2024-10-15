package com.example.demo.config;

import com.example.demo.filter.SuperheroFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<SuperheroFilter> loggingFilter() {
        FilterRegistrationBean<SuperheroFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SuperheroFilter());
        registrationBean.addUrlPatterns("/api/superheroes/*");
        return registrationBean;
    }
}

