package com.code.show.demo.anno;

import com.code.show.demo.register.MyImportBeanDefinitionRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyImportBeanDefinitionRegister.class)
public @interface MyScan {

    String value();
}
