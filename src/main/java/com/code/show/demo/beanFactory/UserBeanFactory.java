package com.code.show.demo.beanFactory;

import com.code.show.demo.entity.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author chengzhiqi
 * @date 2021/8/30 11:16 下午
 **/
public class UserBeanFactory {


    public static void main(String[] args) {

        //BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        beanFactory.registerBeanDefinition("user",beanDefinition);

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }
}
