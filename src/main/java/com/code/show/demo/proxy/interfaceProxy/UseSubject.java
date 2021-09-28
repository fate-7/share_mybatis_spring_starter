package com.code.show.demo.proxy.interfaceProxy;

import java.lang.reflect.Proxy;

/**
 * @author chengzhiqi
 * @date 2021/4/11 2:15 下午
 **/
public class UseSubject {

    public static void main(String[] args) {

        Subject subject = (Subject)Proxy.newProxyInstance(
                UseSubject.class.getClassLoader(),
                new Class[]{Subject.class},
                new SubjectProxy());

        System.out.println(subject.sayHello());
    }
}
