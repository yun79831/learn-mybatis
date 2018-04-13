package com.learn.mybatis.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 集成式使用Mybatis
 * Created by ghost on 2018-04-13.
 */
public class IntegrationMyBatisConfiguration {

    //获取SqlSession
    public static SqlSession getSqlSession() throws FileNotFoundException {
        InputStream mybatisConfig = new FileInputStream("E:\\workspace\\learn-mybatis\\src\\main\\resources\\mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfig);
        return sqlSessionFactory.openSession();
    }
}
