package com.code.show.demo;

import com.code.show.demo.anno.MyScan;
import com.code.show.demo.service.DemoService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@Import(MyImportBeanDefinitionRegister.class)
//@MapperScan("com.code.show.demo.mapper")
@MyScan("com.code.show.demo.mapper")
public class ShowCodeApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ShowCodeApplication.class, args);
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ShowCodeApplication.class);
		applicationContext.refresh();

		DemoService demoService = applicationContext.getBean("demoService", DemoService.class);
		System.out.println(demoService.print());;


	}

}
