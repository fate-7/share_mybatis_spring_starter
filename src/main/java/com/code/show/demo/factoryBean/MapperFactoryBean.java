package com.code.show.demo.factoryBean;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chengzhiqi
 * @date 2021/9/8 10:35 下午
 **/
@Slf4j
public class MapperFactoryBean implements FactoryBean {

    private Class clazz;

    public MapperFactoryBean(Class clazz) {
        this.clazz = clazz;
    }


    public SqlSession session;

//    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(clazz);
        this.session = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() throws Exception {

        log.info("开始获取mapper动态代理...");
        // 代理对象
//        Object mapper = Proxy.newProxyInstance(MapperFactoryBean.class.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });

        Object mapper = session.getMapper(clazz);
        return mapper;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}
