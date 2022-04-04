package com.xuefei.aop.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: xuefei
 * @date: 2022/04/04 17:31
 */
public class JdkDynamicProxyDemo {
    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Object proxy = Proxy.newProxyInstance(contextClassLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Class<?> declaringClass = method.getDeclaringClass();
                if (EchoService.class.isAssignableFrom(declaringClass)) {
                    ProxyEchoService proxyEchoService = new ProxyEchoService(new DefaultEchoService());
                    return proxyEchoService.echo((String) args[0]);
                }
                return null;
            }
        });
        EchoService echoService = (EchoService) proxy;
        echoService.echo("Hello,AOP");
    }
}
