package com.bamons2.monitoring.config;

import com.bamons2.monitoring.interceptor.LoginInfoInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by david100gom on 2017. 8. 13.
 *
 * Github : https://github.com/david100gom
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInfoInterceptor())
                .addPathPatterns("/");
    }

}