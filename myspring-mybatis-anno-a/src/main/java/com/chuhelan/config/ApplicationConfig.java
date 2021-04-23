package com.chuhelan.config;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-23 12:38
 **/

@Configuration //指定是一个核心配置类
@MapperScan("com.chuhelan.dao")//扫描dao层，生成动态代理
@ComponentScan("com.chuhelan")//扫描该路径下所有类上的注解
@EnableTransactionManagement//开启事务
@EnableAspectJAutoProxy
//开启AspectJ自动代理

public class ApplicationConfig {
    //配置数据源

    @Bean
    public DataSource dataSource(JdbcConfig dbcp) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(dbcp.getDriver());
        hikariDataSource.setJdbcUrl(dbcp.getUrl());
        hikariDataSource.setUsername(dbcp.getName());
        hikariDataSource.setPassword(dbcp.getPassword());
        hikariDataSource.setMinimumIdle(1);
        hikariDataSource.setMaxLifetime(30000);
        hikariDataSource.setMaximumPoolSize(10);
        hikariDataSource.setAutoCommit(true);
        hikariDataSource.setIdleTimeout(20000);
        hikariDataSource.setConnectionTimeout(60000);
        return hikariDataSource;
    }

    //配置MyBatis

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource ds) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        //配置数据源
        return bean;
    }

    //配置事务管理

    @Bean
    public DataSourceTransactionManager
    dataSourceTransactionManager(DataSource ds) {
        DataSourceTransactionManager dm = new DataSourceTransactionManager();
        dm.setDataSource(ds);
        return dm;
    }
}

