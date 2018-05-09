package com.jvirriel.demo.backend.configuration;

import com.pt.core.restapi.interceptor.AbstractInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class DefaultInterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    public AbstractInterceptor getInterceptor() {
        return new AbstractInterceptor(){};
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor()).excludePathPatterns(
                getExcludePathPatterns()
        );
    }

    protected String[] getExcludePathPatterns() {
        return new String[]{"/**/swagger-ui.html",
                "/**/v2/api-docs",
                "/**/swagger-resources/**"};
    }
}