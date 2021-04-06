package com.chuhelan.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-30 09:06
 **/

@EnableTransactionManagement
@Configuration //表明这是一个Spring的配置，相当于一个xml文件
@ComponentScan("com.chuhelan.dao") //配置扫描包
@PropertySource(value =
        {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
//配置多个属性文件时，value={"XX","XXX"}
public class SpringJDBCConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    /**
     * 利用HikariCP数据库连接池获取数据资源
     *
     * @return
     */
    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource myDataSource = new HikariDataSource();
        myDataSource.setDriverClassName(driverClassName);
        myDataSource.setJdbcUrl(jdbcUrl);
        myDataSource.setUsername(jdbcUsername);
        myDataSource.setPassword(jdbcPassword);
        myDataSource.setMaxLifetime(30000);
        myDataSource.setMaximumPoolSize(10);
        myDataSource.setMinimumIdle(1);
        myDataSource.setAutoCommit(true);
        myDataSource.setIdleTimeout(20000);
        myDataSource.setConnectionTimeout(60000);
        return myDataSource;
    }

    /**
     * 直接使用SpringJDBC实现
     *
     * @return
     */
/*@Bean
public DriverManagerDataSource dataSource(){
DriverManagerDataSource myDataSource = new
DriverManagerDataSource();
myDataSource.setDriverClassName(driverClassName);
myDataSource.setUrl(jdbcUrl);
myDataSource.setUsername(jdbcUsername);
myDataSource.setPassword(jdbcPassword);
return myDataSource;
}*/
    @Bean(value = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    /**
     * 为数据源添加事务管理器
     *
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager dt = new
                DataSourceTransactionManager();
        dt.setDataSource(dataSource());
        return dt;
    }

}
