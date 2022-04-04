package com.xuefei.aop.service;

import java.lang.reflect.Method;

/**
 * @description: 最终执行后置拦截器
 * @author: xuefei
 * @date: 2022/04/04 17:55
 */
public interface FinallyInterceptor {

    /**
     * 最终执行后置执行
     *
     * @param proxy
     * @param method
     * @param args
     * @param returnResult
     * @return
     */
    Object finalize(Object proxy, Method method, Object[] args, Object returnResult);
}
