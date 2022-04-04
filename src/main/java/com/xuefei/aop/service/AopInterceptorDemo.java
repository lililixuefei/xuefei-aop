package com.xuefei.aop.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: AOP 拦截器示例
 * @author: xuefei
 * @date: 2022/04/04 17:51
 */
public class AopInterceptorDemo {

    public static void main(String[] args) {
        // 前置模式
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Object proxy = Proxy.newProxyInstance(contextClassLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Class<?> declaringClass = method.getDeclaringClass();
                if (EchoService.class.isAssignableFrom(declaringClass)) {
                    // 前置拦截器
                    BeforeInterceptor beforeInterceptor = new BeforeInterceptor() {
                        @Override
                        public Object before(Object proxy, Method method, Object[] args) {
                            return System.currentTimeMillis();
                        }
                    };
                    Long startTime = 0L;
                    Long endTime = 0L;
                    Object result = null;
                    try {
                        startTime = (Long) beforeInterceptor.before(proxy, method, args);
                        DefaultEchoService echoService = new DefaultEchoService();
                        result = echoService.echo((String) args[0]);
                        // 后置拦截器
                        AfterReturnInterceptor afterReturnInterceptor = new AfterReturnInterceptor() {
                            @Override
                            public Object after(Object proxy, Method method, Object[] args, Object returnResult) {
                                return System.currentTimeMillis();
                            }
                        };
                        // 执行 after
                        endTime = (Long) afterReturnInterceptor.after(proxy, method, args, result);
                        return result;
                    } catch (Exception e) {
                        // 异常拦截器（处理方法执行后）
                        ExceptionInterceptor interceptor = new ExceptionInterceptor() {
                            @Override
                            public void intercept(Object proxy, Method method, Object[] args, Throwable throwable) {

                            }
                        };
                    } finally {
                        // finally 后置拦截器
                        FinallyInterceptor finallyInterceptor = new TimeFinallyInterceptor(startTime, endTime);
                        Long costTime = (Long) finallyInterceptor.finalize(proxy, method, args, result);
                        System.out.println("echo 方法执行实现 " + costTime + "ms.");
                    }
                }
                return null;
            }
        });
        EchoService echoService = (EchoService) proxy;
        echoService.echo("Hello,AOP");
    }
}
