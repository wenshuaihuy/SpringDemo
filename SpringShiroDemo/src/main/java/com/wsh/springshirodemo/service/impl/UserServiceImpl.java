package com.wsh.springshirodemo.service.impl;

import com.wsh.springshirodemo.dao.UserDao;
import com.wsh.springshirodemo.pojo.User;
import com.wsh.springshirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huwenshuai
 * @date 2022/6/15 16:22
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserByName(String name) {
        return userDao.queryUserByName(name);
    }
}
