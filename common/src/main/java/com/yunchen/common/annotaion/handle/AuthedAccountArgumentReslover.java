package com.yunchen.common.annotaion.handle;

import com.yunchen.common.annotaion.AuthedAccount;
import com.yunchen.common.model.Authors;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthedAccountArgumentReslover implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return  methodParameter.getParameterType().isAssignableFrom(Authors.class) && methodParameter.hasParameterAnnotation(AuthedAccount.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Authors authors = new Authors();
        String username = nativeWebRequest.getNativeRequest(HttpServletRequest.class).getAttribute("username").toString();
        authors.setName(username);
        authors.setId(556);
        return authors;
    }
}
