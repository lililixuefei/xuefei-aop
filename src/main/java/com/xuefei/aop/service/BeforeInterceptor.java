package com.xuefei.aop.service;

import java.lang.reflect.Method;

/**
 * @description: 前置拦截器
 * @author: xuefei
 * @date: 2022/04/04 17:55
 */
public interface BeforeInterceptor {

    /**
     * 前置执行
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    Object before(Object proxy, Method method, Object[] args);

}
