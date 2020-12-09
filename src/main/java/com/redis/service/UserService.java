package com.redis.service;

import com.redis.mapper.UserDao;
import com.redis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xsyz
 * @created 2020-12-09   18:50
 */
@Service
public interface UserService {
    List<User> findAll();
    int update(User user);




}
