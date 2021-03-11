package com.chuhelan.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("studentBeans.xml");
        Student stu = (Student) ac.getBean("stu1");
        Student stu2 = (Student) ac.getBean("stu2",Student.class);
        System.out.println(stu);
        System.out.println(stu2);
    }

}