package com.xuefei.aop.service;

/**
 * @description:
 * @author: xuefei
 * @date: 2022/04/04 17:30
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        EchoService echoService = new ProxyEchoService(new DefaultEchoService());
        echoService.echo("Hello,AOP");
    }
}
