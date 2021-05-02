# Spring数据库开发

## 用户表相关操作

### 添加依赖文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.chuhelan</groupId>
    <artifactId>chatper04</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.4</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.3.4</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>5.3.4</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.23</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.5</version>
        </dependency>
        <dependency>
            <groupId>com.zaxxer</groupId>
            <artifactId>HikariCP</artifactId>
            <version>4.0.3</version>
        </dependency>
        <dependency>
            <groupId>com.zaxxer</groupId>
            <artifactId>HikariCP</artifactId>
            <version>4.0.3</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.7.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.14.0</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.7.1</version>
            <scope>compile</scope>
        </dependency>
        <!-- 日志门面依赖 -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.0-alpha1</version>
        </dependency>
        <!--log4j12依赖-->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.14.0</version>
        </dependency>
        <!--slf4j-log4j12依赖-->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>2.0.0-alpha1</version>
        </dependency>
    </dependencies>
</project>
```

### 准备t_user数据表

![image-20210502121946088](https://gitee.com/im-not-winnie/pic-bed/raw/master/img/20210502121946.png)

### 数据库文件和日志文件

```properties
#######################  DB Connection Config  #######################


###----------------- DB Type -----------------
databaseType=mysql


###----------------- MySQL5+ -----------------
jdbc.driverClassName=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://tools.chuhelan.com:3306/spring?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8
jdbc.username=spring
jdbc.password=231316
```

```properties
###日志全局属性配置###
log4j.rootLogger=INFO,stdout,D,E
#控制台日志文件配置
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.Threshold=INFO
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=[%-5p]%d{yyyy-MM-ddHH:mm:ss}%l%m%n
#日志的输出文件配置
log4j.appender.D=org.apache.log4j.DailyRollingFileAppender
log4j.appender.D.File=logs/myLog.log
log4j.appender.D.Append=true
log4j.appender.D.Threshold=INFO
log4j.appender.D.layout=org.apache.log4j.PatternLayout
log4j.appender.D.layout.ConversionPattern=%-d{yyyy-MM-ddHH:mm:ss}[%t:%r]-[%p]%m%n
#日志的错误信息输出配置
log4j.appender.E=org.apache.log4j.DailyRollingFileAppender
log4j.appender.E.File=logs/myError.log
log4j.appender.E.Append=true
log4j.appender.E.Threshold=ERROR
log4j.appender.E.layout=org.apache.log4j.PatternLayout
log4j.appender.E.layout.ConversionPattern=%-d{yyyy-MM-ddHH:mm:ss}[%t:%r]-[%p]%m%n
```

### 配置文件applicationContext

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd
       http://www.springframework.org/schema/tx
       http://www.springframework.org/schema/tx/spring-tx.xsd">


    <!--加载数据库属性配置文件-->
    <context:property-placeholder location="classpath:jdbc.properties"/>
    <!--扫描含有注解的包-->
    <context:component-scan base-package="com.chuhelan.dao"/>
    <!--配置数据源==druid数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
          init-method="init" destroy-method="close">
        <!--驱动名称-->
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <!--JDBC连接串-->
        <property name="url" value="${jdbc.url}"/>
        <!--数据库用户名称-->
        <property name="username" value="${jdbc.username}"/>
        <!--数据库密码-->
        <property name="password" value="${jdbc.password}"/>
        <!-- 初始化大小 -->
        <property name="initialSize" value="15"/>
        <!-- 连接池最大使用连接数量 -->
        <property name="maxActive" value="20"/>
        <!-- 连接池最小空闲 -->
        <property name="minIdle" value="0"/>
        <!-- 配置获取连接等待超时的时间 -->
        <property name="maxWait" value="60000"/>
        <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
        <property name="timeBetweenEvictionRunsMillis" value="60000"/>
        <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
        <property name="minEvictableIdleTimeMillis" value="300000"/>
        <!-- 连接空闲时测试是否有效 -->
        <property name="testWhileIdle" value="false"/>
        <!-- 获取连接时测试是否有效 -->
        <property name="testOnBorrow" value="false"/>
        <!-- 归还连接时是否测试有效 -->
        <property name="testOnReturn" value="false"/>
        <!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
        <property name="poolPreparedStatements" value="true"/>
        <property name="maxPoolPreparedStatementPerConnectionSize"
                  value="20"/>
    </bean>
    <!--配置JDBCTemplate实例-->
    <bean id="jdbcTemplate"
          class="org.springframework.jdbc.core.JdbcTemplate"
          p:dataSource-ref="dataSource"/>

    <!--    &lt;!&ndash;This is A Cut Line&ndash;&gt;-->
    <!--    &lt;!&ndash;1 事务管理器,依赖于数据源&ndash;&gt;-->
    <!--    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager"-->
    <!--          p:dataSource-ref="dataSource"/>-->
    <!--    &lt;!&ndash;2编写通知：对事务进行增强，需要编写对切入点和具体执行事务细节&ndash;&gt;-->
    <!--    <tx:advice id="txAdvice" transaction-manager="transactionManager">-->
    <!--        <tx:attributes>-->
    <!--            &lt;!&ndash;name:* 表示任意方法名称&ndash;&gt;-->
    <!--            <tx:method name="*" propagation="REQUIRED" isolation="DEFAULT" read-only="false"/>-->
    <!--        </tx:attributes>-->
    <!--    </tx:advice>-->
    <!--    &lt;!&ndash;3编写aop，让spring自动对目标生成代理，需要使用AspectJ的表达式&ndash;&gt;-->
    <!--    <aop:config>-->
    <!--        &lt;!&ndash;3-1切入点&ndash;&gt;-->
    <!--        <aop:pointcut id="txPointCut" expression="execution(* com.chuhelan.dao.AccountDaoImpl.*(..))"/>-->
    <!--        &lt;!&ndash;3-2切面，将切入点与通知整合&ndash;&gt;-->
    <!--        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>-->
    <!--    </aop:config>-->
    <!--    &lt;!&ndash;开启使用注解完成织入工作&ndash;&gt;-->
    <!--&lt;!&ndash;    <aop:aspectj-autoproxy/>&ndash;&gt; -->
    <!--    &lt;!&ndash;  <bean name="myAdvice" class="com.chuhelan.dao.UserAdvice"/>&ndash;&gt;-->


<!--    <bean id="transactionManager"-->
<!--          class="org.springframework.jdbc.datasource.DataSourceTransactionManager"-->
<!--          p:dataSource-ref="dataSource"/>-->
<!--    &lt;!&ndash;2编写通知：对事务进行增强，需要编写对切入点和具体执行事务细节&ndash;&gt;-->
<!--    <tx:advice id="txAdvice" transaction-manager="transactionManager">-->
<!--        <tx:attributes>-->
<!--            &lt;!&ndash; name:* 表示任意方法名称&ndash;&gt;-->
<!--            <tx:method name="*" propagation="REQUIRED" isolation="DEFAULT"-->
<!--                       read-only="false"/>-->
<!--        </tx:attributes>-->
<!--    </tx:advice>-->
<!--    &lt;!&ndash; 3编写aop，让spring自动对目标生成代理，需要使用AspectJ的表达式&ndash;&gt;-->
<!--    <aop:config>-->
<!--        &lt;!&ndash;3-1切入点&ndash;&gt;-->
<!--        <aop:pointcut id="txPointCut" expression="execution(*-->
<!--com.chuhelan.dao.AccountDaoImpl.transfer(..))"/>-->
<!--        &lt;!&ndash;3-2切面，将切入点与通知整合&ndash;&gt;-->
<!--        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>-->
<!--    </aop:config>-->
<!--    &lt;!&ndash;开启使用注解完成织入工作&ndash;&gt;-->
<!--    <aop:aspectj-autoproxy/>-->


</beans>
```

### 编写实体类 User

```java
package com.chuhelan.domain;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-25 13:55
 **/

public class User {
    private Integer id;
    private String account;
    private String password;

    public User() {
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
```

### 编写工具类UserRowMapper

```java
package com.chuhelan.mapper;

import com.chuhelan.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-25 13:56
 **/

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setAccount(resultSet.getString("account"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
```

### 编写UserDao接口

```java
package com.chuhelan.dao;


import com.chuhelan.domain.User;

import java.util.List;

public interface UserDao {
    int insertUser(User user);//插入一个实体
    int deleteById(Integer id);//根据id删除一个实体
    int updateUser(User user);//更新一个实体
    List<User> getAllUser();//获取所有实体
    User getUserById(Integer id);//根据id获取一个实体
    List<User> getUserLike(String keywords);//根据关键字实现模糊查询
}
```

### 编写UserDaoImpl

```java
package com.chuhelan.dao;

import com.chuhelan.domain.User;
import com.chuhelan.mapper.UserRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-25 14:13
 **/

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //增加一个日志查看回调的id
    private final Logger logger =
            LoggerFactory.getLogger(UserDaoImpl.class);


//    @Override
//    public int insertUser(User user) {
//        int n = 0;
//        String sql = "insert into t_user(id,account,password) values(null,?,?)";
//        Object[] args = {user.getAccount(), user.getPassword()};
//        n = jdbcTemplate.update(sql, args);
//        return n;
//    }

    @Override
    public int insertUser(User user) {
        int n = 0;
        String sql = "INSERT INTO t_user VALUES(null,?,?)";
        Object[] args = {user.getAccount(), user.getPassword()};
        GeneratedKeyHolder KeyHolder = new GeneratedKeyHolder();
        n = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
// 如果不是拼接的，参数直接放在sql语句中，则使用下面的语句
// return connection.prepareStatement(sql,args);
                PreparedStatement psmt = connection.prepareStatement(sql, new
                        String[]{"id"});
                psmt.setString(1, (String) args[0]);
                psmt.setString(2, (String) args[1]);
                return psmt;
            }
        }, KeyHolder);
        Integer newId = KeyHolder.getKey().intValue();
        user.setId(newId);
        logger.info("后台存储数据：" + user.toString());
        return n;
    }

    @Override
    public int deleteById(Integer id) {
        int n = 0;
        String sql = "delete from t_user where id=?";
        Object[] args = {id};
        n = jdbcTemplate.update(sql, args);
        return n;
    }

    @Override
    public int updateUser(User user) {
        int n = 0;
        String sql = "update t_user set account=? , password=? where id=?";
        Object[] args = {user.getAccount(), user.getPassword(), user.getId()};
        n = jdbcTemplate.update(sql, args);
        return n;
    }

    public List<User> getAllUser() {
        String sql = "SELECT * from t_user";
// return jdbcTemplate.query(sql, new UserRowMapper());
// 如果列名和属性名都是相同的，也可以直接使用BeanPropertyRowMapper，如果不一样
// 则使用自己定义的UserRowMapper
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>
                (User.class));
    }


    @Override
    public User getUserById(Integer id) {
        String sql = "select * from t_user where id=" + id;
        return jdbcTemplate.queryForObject(sql, new UserRowMapper());
    }


    @Override
    public List<User> getUserLike(String keywords) {
        String sql = "select * from t_user where account like " +
                "'%" + keywords + "%'";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
}
```

### 编写测试单元

```java
package com.chuhelan.dao;

import com.chuhelan.domain.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
class AccountDaoTest {
    @Autowired
    AccountDao accountDao;

    @Test
    void addAccount() {
        Account account1 = new Account("Jack", 10000);
        Account account2 = new Account("Rose", 500);
        accountDao.addAccount(account1);
        accountDao.addAccount(account2);
    }

    @Test
    void updateAccount() {
        Account account = accountDao.getAccountById(2);
        account.setUsername("John");
        account.setBalance(10000);
        int n = accountDao.updateAccount(account);
        assertEquals(1, n);
    }

    @Test
    void deleteAccount() {
        int n = accountDao.deleteAccount(1);
        assertEquals(1, n);
    }

    @Test
    void transfer() {
        accountDao.transfer("Jack", "John", 200d);
    }

    @Test
    void getAccountById() {
        Account account;
        account = accountDao.getAccountById(5);
        System.out.println(account);
    }

    @Test
    void getAllAccount() {
        List<Account> list = accountDao.getAllAccount();
// list.forEach(account -> System.out.println(account));
        list.forEach(System.out::println);
    }

    @Test
    public void getAccountLike() throws Exception {
        List<Account> list = accountDao.getAccountLike("三");
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
```

测试结果：

![image-20210502122351561](https://gitee.com/im-not-winnie/pic-bed/raw/master/img/20210502122351.png)