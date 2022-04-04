package com.xuefei.aop.service;

import java.lang.reflect.Method;

/**
 * @description: 异常拦截器
 * @author: xuefei
 * @date: 2022/04/04 17:55
 */
public interface ExceptionInterceptor {

    /**
     * 后置执行
     * @param proxy
     * @param method
     * @param args
     * @param throwable
     */
    void intercept(Object proxy, Method method, Object[] args, Throwable throwable);
}
