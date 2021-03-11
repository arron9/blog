package com.yunchen.admin.interceptor;

import com.yunchen.common.aop.ControllerAop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerInterceptor {

    @Around("execution(* com.yunchen.admin..*.*(..))")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint) {
        return ControllerAop.proceed(proceedingJoinPoint);
    }
}
