package com.code.show.demo.proxy.ImplClassProxy;

/**
 * @author chengzhiqi
 * @date 2021/4/11 2:05 下午
 **/
public class SubjectImpl implements Subject{
    @Override
    public String sayHello() {
        return "hello world";
    }
}
