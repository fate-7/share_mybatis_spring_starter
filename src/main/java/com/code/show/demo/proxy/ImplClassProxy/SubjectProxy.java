package com.code.show.demo.proxy.ImplClassProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chengzhiqi
 * @date 2021/4/11 2:06 下午
 **/
public class SubjectProxy implements InvocationHandler {


    private Object target;

    public SubjectProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("动态代理前置处理...");
        return method.invoke(target, args);
    }

}
