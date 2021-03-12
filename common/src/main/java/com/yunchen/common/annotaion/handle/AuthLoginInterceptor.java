package com.yunchen.common.annotaion.handle;


import com.yunchen.common.annotaion.AuthLogin;
import com.yunchen.common.exception.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            AuthLogin annotaion = ((HandlerMethod) handler).getMethodAnnotation(AuthLogin.class);
            if (annotaion == null) {
                return true;
            } else {
                throw new BadRequestException("请先登录");
            }
        }

        return true;
    }
}
