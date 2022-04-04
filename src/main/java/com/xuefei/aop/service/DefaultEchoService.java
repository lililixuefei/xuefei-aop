package com.xuefei.aop.service;

/**
 * @description:
 * @author: xuefei
 * @date: 2022/04/04 17:24
 */
public class DefaultEchoService implements EchoService {

    @Override
    public String echo(String message) {
        return "[ECHO] " + message;
    }
}
