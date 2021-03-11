package com.yunchen.common.aop;

import com.alibaba.fastjson.JSON;
import com.yunchen.common.Consts.RetCodeEnum;
import com.yunchen.common.model.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ControllerAop {

    private static final Logger log = LoggerFactory.getLogger(ControllerAop.class);

    public static Object proceed(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        // 获取被拦截的方法
        Method method = signature.getMethod();
        // 获取被拦截的方法名
        String methodName = method.getName();

        Object result;
        String opSeq = RandomStringUtils.randomAlphanumeric(10);
        StopWatch watch = new StopWatch();

        try {
            watch.start();

            // 打印请求日志
            printRequestLog(pjp.getArgs(), methodName, opSeq);

            // 业务逻辑
            result = pjp.proceed();

            // 全局异常处理
        } catch (IllegalArgumentException e) {
            log.error("请求参数错误:{}", opSeq,  e);
            result = new Response<>(RetCodeEnum.FAIL, e.getMessage());
        } catch (NullPointerException e) {
            log.error("空指针异常:{}", opSeq, e);
            result = new Response<>(RetCodeEnum.FAIL, e.getMessage());
        } catch (RuntimeException e) {
            log.error("业务异常:{}",opSeq, e);
            result = new Response<>(RetCodeEnum.FAIL, e.getMessage());
        } catch (Throwable e) {
            log.error("未知异常:{}",opSeq, e);
            result = new Response<>(RetCodeEnum.FAIL, e.getMessage());
        }

        watch.stop();

        // 打印响应日志
        printResponseLog(result, methodName, watch.getTotalTimeMillis(), opSeq);

        return result;
    }

    private static void printRequestLog(Object[] args, String methodName, String opSeq) {
        log.info("request.method[" + methodName + "],opSeq[" + opSeq + "],param" + JSON.toJSONString(args));
    }

    private static void printResponseLog(Object result, String methodName, long cost, String opSep) {
        log.info("response.method[" + methodName + "],opSeq[" + opSep + "],cost["+ cost +  "],result[" + JSON.toJSONString(result) + "]");
    }

}
