package com.wsh.testjwtdemo.service.impl;

import com.wsh.testjwtdemo.dao.UserDao;
import com.wsh.testjwtdemo.entity.User;
import com.wsh.testjwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huwenshuai
 * @date 2022/6/13 20:24
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User userDB = userDao.login(user);
        if (userDB != null) {
            return userDB;
        }
        throw new RuntimeException("fail");

    }
}
