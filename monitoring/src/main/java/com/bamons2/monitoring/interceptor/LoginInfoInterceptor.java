package com.bamons2.monitoring.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by david100gom on 2017. 8. 13.
 *
 * Github : https://github.com/david100gom
 */
public class LoginInfoInterceptor extends HandlerInterceptorAdapter {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean is = true;

        logger.error(" Class : {}", "LoginInfoInterceptor");
        return is;
    }
}
