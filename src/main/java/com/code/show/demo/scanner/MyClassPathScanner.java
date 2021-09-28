package com.code.show.demo.scanner;

import com.code.show.demo.factoryBean.MapperFactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @author chengzhiqi
 * @date 2021/9/8 10:29 下午
 **/
public class MyClassPathScanner extends ClassPathBeanDefinitionScanner {

    public MyClassPathScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        final Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);

        beanDefinitionHolders.forEach(holder -> {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition)holder.getBeanDefinition();

            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClassName(MapperFactoryBean.class.getName());

            beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        });
        return beanDefinitionHolders;
    }
}
