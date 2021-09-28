package com.code.show.demo.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chengzhiqi
 * @date 2021/9/14 6:40 下午
 **/
public class TestDbConnect {

    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //初始化mybatis，创建SqlSessionFactory类实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建Session实例
        SqlSession session = sqlSessionFactory.openSession();

        session.selectOne("select 1");
        //提交事务
        session.commit();
        //关闭Session
        session.close();
    }
}
