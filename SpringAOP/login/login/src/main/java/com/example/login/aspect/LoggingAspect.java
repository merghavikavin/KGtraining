package com.example.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.login.service.EmployeeService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method execution: " + joinPoint.getSignature().toShortString());
    }

    @After("execution(* com.example.login.service.EmployeeService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After method execution: " + joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* com.example.login.service.EmployeeService.getEmployeeById(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After method execution: " + joinPoint.getSignature().toShortString());
        if (result == null) {
            System.err.println("Employee with the provided ID does not exist");
            throw new IllegalArgumentException("Employee with the provided ID does not exist");
        }
    }

    @AfterThrowing(pointcut = "execution(* com.example.login.service.EmployeeService.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.out.println("After throwing exception in method: " + joinPoint.getSignature().toShortString());
        System.out.println("Exception: " + exception.getMessage());
    }
}
