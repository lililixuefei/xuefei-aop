package com.xuefei.aop.service;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: xuefei
 * @date: 2022/04/04 18:16
 */
public class TimeFinallyInterceptor implements FinallyInterceptor {

    private final Long startTime;
    private final Long endTime;

    public TimeFinallyInterceptor(Long startTime, Long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public Object finalize(Object proxy, Method method, Object[] args, Object returnResult) {
        // 方法的执行时间（ms）
        Long costTime = endTime - startTime;
        return costTime;
    }
}
