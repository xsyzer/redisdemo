package com.redis.service;

import com.redis.mapper.UserDao;
import com.redis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xsyz
 * @created 2020-12-09   18:58
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();

    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

}
