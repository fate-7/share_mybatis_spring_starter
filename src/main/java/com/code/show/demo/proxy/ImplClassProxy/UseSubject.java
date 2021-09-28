package com.code.show.demo.proxy.ImplClassProxy;

import java.lang.reflect.Proxy;

/**
 * @author chengzhiqi
 * @date 2021/4/11 2:08 下午
 **/
public class UseSubject {

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        final Subject o = (Subject)Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), new SubjectProxy(subject));


        System.out.println(o.sayHello());
    }
}
