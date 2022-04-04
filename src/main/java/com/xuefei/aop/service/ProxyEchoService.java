package com.xuefei.aop.service;

/**
 * @description:
 * @author: xuefei
 * @date: 2022/04/04 17:26
 */
public class ProxyEchoService implements EchoService{

    private EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String message) {
        long startTime = System.currentTimeMillis();
        String result = echoService.echo(message);
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("echo 方法执行的实现 "+ costTime + "ms.");
        return result;
    }
}
