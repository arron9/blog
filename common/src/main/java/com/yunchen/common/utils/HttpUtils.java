package com.yunchen.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HttpUtils {
    @Autowired
    private HttpServletRequest request;

    public String getIp() {
        String ip = request.getHeader("X-Forwarded-For");

        if (ip != null && !ip.isEmpty()) {
            return ip.replace(" ", "").split(",")[0];
        }

        return request.getRemoteAddr();
    }
}
