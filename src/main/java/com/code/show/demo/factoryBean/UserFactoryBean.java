package com.code.show.demo.factoryBean;

import com.code.show.demo.entity.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 创建Bean的一种方式
 * @author chengzhiqi
 * @date 2021/8/30 11:03 下午
 **/
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }



    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        //最终生成了两个bean对象 &demo:DemoFactoryBean , demo:Demo
        beanDefinition.setBeanClass(UserFactoryBean.class);

        applicationContext.registerBeanDefinition("user", beanDefinition);

        applicationContext.refresh();

//        UserFactoryBean bean = applicationContext.getBean("&user", UserFactoryBean.class);
//        System.out.println(bean);

        User demo = applicationContext.getBean("user", User.class);
        System.out.println(demo);
    }
}


