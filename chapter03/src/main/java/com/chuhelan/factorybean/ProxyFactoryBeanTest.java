package com.chuhelan.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.chuhelan.jdk.UserDao;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 12:36
 **/

public class ProxyFactoryBeanTest {
    public static void main(String[] args) {
        String xmlPath = "applicationContext.xml";
        ApplicationContext ac =
                new ClassPathXmlApplicationContext(xmlPath);
        //从spring容器获得内容
        UserDao userDao = (UserDao) ac.getBean("userDaoProxy");
        //执行方法
        userDao.addUser();
        userDao.deleteUser();
    }
}