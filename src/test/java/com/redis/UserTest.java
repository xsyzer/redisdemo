package com.redis;

import com.redis.pojo.User;
import com.redis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

/**
 * @author xsyz
 * @created 2020-12-09   18:59
 */
@SpringBootTest(classes = RedisApplication.class)
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void findall(){
        userService.findAll().forEach(System.out::println);
        System.out.println("===============");
        userService.findAll().forEach(System.out::println);

    }
}
