package com.chuhelan.dao;

import com.chuhelan.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations ={ "/applicationContext.xml"})
@Slf4j
@ContextConfiguration(locations ={ "classpath:applicationContext.xml"})
class UserDaoTest {
    @Autowired
    UserDao userDao;
    @Test
    void findAll() {
        List<User> all = userDao.findAll();
        log.info("查到的信息：\n"+all.toString());
    }
    @Test
    void findById() {
        Integer id=2;
        System.out.println(userDao.findById(id));
    }
    @Test
    void insert() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String birthStr="2010-2-1";
        Date birthday=sdf.parse(birthStr);
        User user=User.builder()
                .username("Lily")
                .birthday(birthday)
                .sex("女")
                .address("江苏南京")
                .build();
        int n=userDao.insert(user);
        if(n>0){
            log.info("插入用户："+user);
        }else{
            log.info("插入用户失败！");
        }
    }
}