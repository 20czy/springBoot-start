package com.example.demo.config;

import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class webconfig {

    @Configuration
    public class webConfig implements WebMvcConfigurer{

        @Override
        public void addInterceptors(InterceptorRegistry registry){
            registry.addInterceptor(new LoginInterceptor());
        }
    }
}
