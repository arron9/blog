package com.yunchen.common.interceptor;


import com.alibaba.fastjson.JSON;
import com.yunchen.common.Consts.RetCodeEnum;
import com.yunchen.common.model.Response;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SignInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("username", "jiangsx");
        if (request.getMethod().equals("GET")) {
            response.setHeader("Content-type", "application/json");
            response.setCharacterEncoding("UTF-8");

            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String sRet = JSON.toJSONString(new Response<>(RetCodeEnum.FAIL));
            out.write(sRet);
            out.flush();

            return false;
        }

        return  true;
    }
}
