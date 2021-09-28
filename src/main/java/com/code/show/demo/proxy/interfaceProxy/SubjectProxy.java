package com.code.show.demo.proxy.interfaceProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chengzhiqi
 * @date 2021/4/11 2:14 下午
 **/
public class SubjectProxy implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("投鞭断流式 动态代理");
        return "success";
    }
}
