package com.code.show.demo.register;

import com.code.show.demo.anno.MyScan;
import com.code.show.demo.scanner.MyClassPathScanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


import java.util.Map;

/**
 * @author chengzhiqi
 * @date 2021/9/8 10:06 下午
 **/
@Slf4j
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

        final Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(MyScan.class.getName());
        String path = (String)annotationAttributes.get("value");

//        String path = "com.code.show.demo.mapper";

        final MyClassPathScanner myClassPathScanner = new MyClassPathScanner(registry);

        myClassPathScanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);

        final int scan = myClassPathScanner.scan(path);
        log.info("scanner get mapper count: {}" , scan);


//        //注册bean
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        //最终生成了两个bean对象 &demo:DemoFactoryBean , demo:Demo
//        beanDefinition.setBeanClass(UserFactoryBean.class);
//        registry.registerBeanDefinition("user", beanDefinition);
    }
}
