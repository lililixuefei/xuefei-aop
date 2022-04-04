package com.xuefei.aop.service;

import java.lang.reflect.Method;

/**
 * @description: 后置拦截器
 * @author: xuefei
 * @date: 2022/04/04 17:55
 */
public interface AfterReturnInterceptor {

    /**
     * 后置执行
     *
     * @param proxy
     * @param method
     * @param args
     * @param returnResult
     * @return
     */
    Object after(Object proxy, Method method, Object[] args, Object returnResult);
}
