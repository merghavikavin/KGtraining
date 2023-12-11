package com.example.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("State: Before request reaches controller");
        System.out.println("Request received for URL: " + request.getRequestURL().toString());
        final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
 
 

        logger.trace("State: trace");
        logger.debug("State: debug");
        logger.info("State: info");
        logger.warn("State: warn");
        logger.error("State: error");
        // logger.("State: info");
        // logger.info("State: info");
 
        return true;
    }
   
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        System.out.println("Post Handler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("After Completion");
    }
}
