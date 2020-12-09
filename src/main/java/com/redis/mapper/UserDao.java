package com.redis.mapper;

import com.redis.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xsyz
 * @created 2020-12-09   18:47
 */
@Component
public interface UserDao {
    List<User> findAll();
    int update(User user);
}
