# MyBatis

## MyBatis的使用

- 创建Maven空项目
- 在pom文件中添加依赖
- 创建数据库
- 将日志属性文件、数据库连接属性文件拷贝到resources中
- 创建domain层，编写User实体类
- 创建dao层，编写UserDao接口
- 创建mapper.xml模板，编写与UserDao匹配的mapper文件

### 添加依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.chuhelan</groupId>
    <artifactId>chatper06</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>
    <!--打包方式-->
    <packaging>jar</packaging>
    <dependencies>
        <dependency>
            <groupId>cglib</groupId>
            <artifactId>cglib</artifactId>
            <version>3.1</version>
        </dependency>
        <!--数据库连接池依赖-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.5</version>
        </dependency>
        <!--mybatis依赖-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.6</version>
        </dependency>
        <!--sql依赖-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.23</version>
        </dependency>
        <!--日志依赖-->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.0-alpha1</version>
        </dependency>
        <!--桥接-->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>2.0.0-alpha1</version>
        </dependency>
        <!--log4j依赖-->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.14.0</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.18</version>
        </dependency>
        <!--Junit5依赖-->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.7.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### 创建数据库

![image-20210502114445607](https://gitee.com/im-not-winnie/pic-bed/raw/master/img/20210502114445.png)

### 日志文件

```properties
###日志全局属性配置###
log4j.rootLogger = INFO,stdout,D,E
#Mybatis日志配置
log4j.logger.com.example=TRACE

#控制台日志文件配置
log4j.appender.stdout = org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target = System.out
log4j.appender.stdout.Threshold =DEBUG
log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern = [%-5p] %d{yyyy-MM-dd HH:mm:ss} %l%m%n

#日志的输出文件配置
log4j.appender.D = org.apache.log4j.DailyRollingFileAppender
log4j.appender.D.File = logs/myLog.log
log4j.appender.D.Append = true
log4j.appender.D.Threshold = INFO
log4j.appender.D.layout = org.apache.log4j.PatternLayout
log4j.appender.D.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n

#日志的错误信息输出配置
log4j.appender.E = org.apache.log4j.DailyRollingFileAppender
log4j.appender.E.File =logs/myError.log
log4j.appender.E.Append = true
log4j.appender.E.Threshold = ERROR
log4j.appender.E.layout = org.apache.log4j.PatternLayout
log4j.appender.E.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n
```

### 数据库属性

- url添加数据库的地址
- username添加数据库用户名
- password添加数据库的密码

```properties
#######################  DB Connection Config  #######################


###----------------- DB Type -----------------
databaseType=mysql


###----------------- MySQL5+ -----------------
jdbc.driverClassName=com.mysql.cj.jdbc.Driver
jdbc.url=添加您的地址?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8
jdbc.username=用户名
jdbc.password=密码
```

### 项目目录

![image-20210502114936028](https://gitee.com/im-not-winnie/pic-bed/raw/master/img/image-20210502114936028.png)

#### 创建User实体类

```java
package com.chuhelan.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public User(String username, Date birthday, String sex, String address) {
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }
}
```

创建UserDao接口

```java
package com.chuhelan.dao;

import com.chuhelan.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wmp231316
 */
public interface UserDao {
    List<User> findAll();

    User findUserById(Integer id);

    int updateUser(User user);

    int insertUser(User user);

    int deleteUserById(Integer id);

    User findByMap(Map map);

    User findByCondition(@Param("id") Integer id, @Param("username") String username);

}
```

####  添加config模板

![image-20210502115248061](https://gitee.com/im-not-winnie/pic-bed/raw/master/img/20210502115248.png)

#### 添加mapper模板

![image-20210502115338887](https://gitee.com/im-not-winnie/pic-bed/raw/master/img/20210502115339.png)

#### mybatis-config文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <properties resource="jdbc.properties"/>
    <settings>
<!--        <setting name="cacheEnabled" value="true"/>-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
<!--        <setting name="lazyLoadingEnabled" value="true"/>-->
<!--        <setting name="autoMappingBehavior" value="true"/>-->
    </settings>
    <typeAliases>
        <typeAlias type="com.chuhelan.domain.User" alias="User"/>
        <!--        <package name="com.chuhelan.domain"/>-->
    </typeAliases>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driverClassName}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="com/chuhelan/dao/UserDao.xml"/>
<!--        <package name="com.chuhelan.dao"/>-->
    </mappers>
</configuration>
```

#### 配置mapper文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.chuhelan.dao.UserDao">
    <select id="findAll" resultType="com.chuhelan.domain.User">
        select * from t_user
    </select>
    <!--  #{}表示占位符，相当于? -->
    <select id="findUserById" resultType="com.chuhelan.domain.User" parameterType="integer">
        select * from t_user where id = #{id}
    </select>
    <update id="updateUser" parameterType="com.chuhelan.domain.User">
        update t_user set username=#{username} ,birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}
    </update>
    <insert id="insertUser" useGeneratedKeys="true" keyProperty="id" parameterType="com.chuhelan.domain.User">
        insert into t_user values(null,#{username},#{birthday},#{sex},#{address})
    </insert>

    <delete id="deleteUserById" parameterType="com.chuhelan.domain.User">
        delete from t_user where id = #{id}
    </delete>

    <select id="findByMap" resultType="com.chuhelan.domain.User">
        select * from t_user where id=#{id} and username=#{username}
    </select>

    <select id="findByCondition" resultType="com.chuhelan.domain.User">
        select * from t_user where id=#{id} and username=#{username}
    </select>

</mapper>
```

#### 编写测试用例

```java
package com.chuhelan.dao;

import com.chuhelan.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    UserDao userDao;
    InputStream inputStream;

    @BeforeEach
    void setUp() throws IOException {
        /*1 、加载配置文件*/
        String resource = "mybatis-config.xml";
        inputStream = Resources.getResourceAsStream(resource);
        /*2、根据配置文件创建SqlSessionFactory工厂对象*/
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /*3、通过SqlSession创建session核心接口（发送sql语句
         * 理解为一个数据库连接*/
        session = sqlSessionFactory.openSession();
        /*4、通过SqlSession获取接口的实现类对象UserDao*/
        userDao = session.getMapper(UserDao.class);
    }


    @AfterEach
    void tearDown() throws IOException {
//        要么在setUp()这个语句加入参数true
//        SqlSession session = sqlSessionFactory.openSession(true);
//        要么使用session.commit()
//        session.commit();
        session.close();
        inputStream.close();
    }

    @Test
    void findAll() {
        List<User> allUser = userDao.findAll();
        allUser.forEach(System.out::println);
    }

    @Test
    void findUserById() {
        Integer id = 2;
        User user = userDao.findUserById(id);
        System.out.println(user);
    }

    @Test
    void updateUser() throws ParseException {
        String birthdayStr = "2000-12-25";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(birthdayStr);
        User user = new User();
        user.setId(1);
        user.setUsername("Alex");
        user.setBirthday(birthday);
        user.setSex("female");
        user.setAddress("LA");
        System.out.println("Info before change :");

        User user1 = userDao.findUserById(user.getId());
//        complete change
        System.out.println(user1);
        userDao.updateUser(user);
        System.out.println("Info after change : ");
        user1 = userDao.findUserById(user.getId());
        System.out.println(user1);
    }

    @Test
    void insertUser() throws Exception {
        String birthdayStr = "1995-3-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(birthdayStr);
        User user = new User("HAM", birthday, "female", "united states of america");
        System.out.println(user);
        userDao.insertUser(user);
        System.out.println(user);
    }

    @Test
    void deleteUserById() {
        System.out.println("Before Delete User");
        findAll();
        Integer id = 5;
        userDao.deleteUserById(id);
        System.out.println("delete success!");
        findAll();
    }

    @Test
    void findByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id",4);
        map.put("username","HAM");
        User user = userDao.findByMap(map);
        System.out.println(user);
    }

    @Test
    void findByCondition(){
        User user = userDao.findByCondition(2,"Tom");
        System.out.println(user);
    }

}
```

运行测试结果

![image-20210502115628711](https://gitee.com/im-not-winnie/pic-bed/raw/master/img/20210502115628.png)



## Spring和MyBatis的整合

### 添加pom依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.chuhelan</groupId>
    <artifactId>myspring-mybatis-anno-a</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <!--打包方式-->
    <packaging>jar</packaging>
    <dependencies>
        <!--spring基础依赖-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.4</version>
        </dependency>
        <!--springJDBC依赖，SpringJDBC依赖Spring-tx,故不需要添加spring-tx依赖-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.3.4</version>
        </dependency>
        <!--spring测试依赖-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>5.3.4</version>
        </dependency>
        <!--事务依赖-->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.6</version>
        </dependency>
        <!-- spring-mybatis依赖 spring-mybatis桥接-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.6</version>
        </dependency>
        <!--数据库连接池依赖-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.5</version>
        </dependency>
        <!--数据库连接池依赖,本案例中选择它-->
        <dependency>
            <groupId>com.zaxxer</groupId>
            <artifactId>HikariCP</artifactId>
            <version>4.0.3</version>
        </dependency>
        <!--mybatis依赖-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.6</version>
        </dependency>
        <!-- MyBatis分页依赖 -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.2.0</version>
        </dependency>
        <!--mysql依赖-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.23</version>
        </dependency>
        <!--日志依赖-->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.0-alpha1</version>
        </dependency>
        <!--log4j依赖-->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.14.0</version>
        </dependency>
        <!--slf4j0log4j12桥接-->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>2.0.0-alpha1</version>
        </dependency>
        <!--lombok依赖-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.18</version>
        </dependency>
        <!--Junit5依赖-->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.7.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>


</project>
```

### 添加日志和数据库属性文件

```properties
###日志全局属性配置###
log4j.rootLogger = INFO,stdout,D,E

#控制台日志文件配置
log4j.appender.stdout = org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target = System.out
log4j.appender.stdout.Threshold = DEBUG
log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern = [%-5p] %d{yyyy-MM-dd HH:mm:ss} %l%m%n

#日志的输出文件配置
log4j.appender.D = org.apache.log4j.DailyRollingFileAppender
log4j.appender.D.File = logs/myLog.log
log4j.appender.D.Append = true
log4j.appender.D.Threshold = INFO
log4j.appender.D.layout = org.apache.log4j.PatternLayout
log4j.appender.D.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n

#日志的错误信息输出配置
log4j.appender.E = org.apache.log4j.DailyRollingFileAppender
log4j.appender.E.File =logs/myError.log
log4j.appender.E.Append = true
log4j.appender.E.Threshold = ERROR
log4j.appender.E.layout = org.apache.log4j.PatternLayout
log4j.appender.E.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n
```

```properties
#######################  DB Connection Config  #######################


###----------------- DB Type -----------------
databaseType=mysql


###----------------- MySQL5+ -----------------
jdbc.driverClassName=com.mysql.cj.jdbc.Driver
jdbc.url=
jdbc.username=
jdbc.password=
```

### 编写JdbcConfig

```java
package com.chuhelan.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-23 12:37
 **/

@Component
@PropertySource("classpath:jdbc.properties")
@Data
public class JdbcConfig {
    @Value("${jdbc.driverClassName}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String name;
    @Value("${jdbc.password}")
    private String password;
}
```

### 编写ApplicationConfig

```java
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
```

### 数据库文件

![image-20210502120605163](https://gitee.com/im-not-winnie/pic-bed/raw/master/img/20210502120605.png)

### Account

```java
package com.chuhelan.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-23 12:40
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements Serializable {
    private int id;
    private String username;
    private Double balance;
}
```

### AccountDao

```java
package com.chuhelan.dao;

import com.chuhelan.domain.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountDao {
    @Select("select * from t_account")
    List<Account> findAll();

    @Update("update t_account set balance=balance+ #{money} where id=#{id}")
    int addMoney(@Param("id") Integer id, @Param("money") Double money);

    @Update("update t_account set balance=balance- #{money} where id=#{id}")
    int subMoney(@Param("id") Integer id, @Param("money") Double money);
}
```

### AccountService

```java
package com.chuhelan.service;

import com.chuhelan.domain.Account;
import java.util.List;


public interface AccountService {
    List<Account> findAll();
    int changeMoney(Integer fromId,Integer toId,Double money);
}
```

### AccountServiceImpl

```java
package com.chuhelan.service;

import com.chuhelan.dao.AccountDao;
import com.chuhelan.domain.Account;
import com.chuhelan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-23 12:43
 **/

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
    @Override
    public int changeMoney(Integer fromId, Integer toId, Double money) {
        accountDao.subMoney(fromId,money);
// 模拟一个异常
// int result=1/0;
        accountDao.addMoney(toId,money);
        return 0;
    }
}
```

### AccountAdvice

```java
package com.chuhelan.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-23 12:44
 **/

@Aspect
//标识为切面
@Component
//定义组件

public class AccountAdvice {
    @Pointcut("execution(* com.chuhelan.service.*.*(..))")
    public void pointCut(){};
    @Before("pointCut()")
    public void before(JoinPoint jp){
        System.out.println("前置增强：开始账户操作！！");
    }
}
```

 ### 编写测试类

```java
package com.chuhelan.service;

import com.chuhelan.config.ApplicationConfig;
import com.chuhelan.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) //单元测试
@ContextConfiguration(classes={ApplicationConfig.class}) //加载应用配置文件类
@Slf4j //使用slf4j日志门面
class AccountServiceTest {
    @Autowired
    AccountService accountService;
    @Test
    void findAll() {
        List<Account> allAccount = accountService.findAll();
        System.out.println("获取所有用户");
        allAccount.forEach(System.out::println);
        log.info("查询所有用户");
        log.info(allAccount.toString());
    }
    @Test
    void changeMoney() {
        List<Account> allAccount = accountService.findAll();
        System.out.println("获取所有用户");
        allAccount.forEach(System.out::println);
        accountService.changeMoney(1,2,200d);
        allAccount = accountService.findAll();
        System.out.println("获取所有用户");
        allAccount.forEach(System.out::println);
    }
}
```

项目目录

![image-20210502120909889](https://gitee.com/im-not-winnie/pic-bed/raw/master/img/image-20210502120909889.png)

测试结果：

![image-20210502120939756](https://gitee.com/im-not-winnie/pic-bed/raw/master/img/20210502120940.png)

