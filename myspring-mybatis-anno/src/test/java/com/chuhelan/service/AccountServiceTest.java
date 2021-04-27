package com.chuhelan.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations = {"/applicationContext.xml"})
@ContextConfiguration(locations ={ "classpath:applicationContext.xml"})
class AccountServiceTest {
    @Autowired
    AccountService accountService;
    @Test
    void transfer() {
        Boolean flag=accountService.transfer(1,3,100d);
        Assertions.assertEquals(true,flag);
    }
}
