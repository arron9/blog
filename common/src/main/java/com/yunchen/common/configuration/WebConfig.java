package com.yunchen.common.configuration;

import com.yunchen.common.annotaion.handle.AuthLoginInterceptor;
import com.yunchen.common.annotaion.handle.AuthedAccountArgumentReslover;
import com.yunchen.common.interceptor.SignInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private SignInterceptor signInterceptor;

    @Resource
    private AuthLoginInterceptor authLoginInterceptor;

    @Resource
    private AuthedAccountArgumentReslover authedAccountArgumentReslover;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInterceptor).addPathPatterns("/api/**");
        registry.addInterceptor(authLoginInterceptor).addPathPatterns("/admin/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(authedAccountArgumentReslover);
    }
}
