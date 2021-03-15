package com.yunchen.common.annotaion.handle;


import com.yunchen.common.annotaion.AuthLogin;
import com.yunchen.common.exception.BadRequestException;
import com.yunchen.common.mapper.AdminUsersMapper;
import com.yunchen.common.model.AdminUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class AuthLoginInterceptor implements HandlerInterceptor {

    @Autowired
    AdminUsersMapper adminUsersMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            AuthLogin annotaion = ((HandlerMethod) handler).getMethodAnnotation(AuthLogin.class);
            if (annotaion == null) {
                return true;
            } else {
                String accessToken = request.getHeader("access_token");
                if (accessToken == null) {
                    throw new BadRequestException("请先登录");
                }

                Example example = new Example(AdminUsers.class);
                example.createCriteria().andEqualTo("token", accessToken);
                List<AdminUsers> adminUsers =  adminUsersMapper.selectByExample(example);
                if (adminUsers.isEmpty()) {
                    throw new BadRequestException("请先登录1");
                }

            }
        }

        return true;
    }
}
