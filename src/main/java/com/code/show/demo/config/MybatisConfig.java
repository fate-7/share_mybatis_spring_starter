package com.code.show.demo.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;


/**
 * @author chengzhiqi
 * @date 2021/9/14 12:02 上午
 **/
@Configuration
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //初始化mybatis，创建SqlSessionFactory类实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        return sqlSessionFactory;
    }

}
