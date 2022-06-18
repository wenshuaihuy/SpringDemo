package com.wsh.springshirodemo;

import com.wsh.springshirodemo.pojo.User;
import com.wsh.springshirodemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringShiroDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        User qqq = userService.queryUserByName("wsh");
        System.out.println(qqq);
    }

}
