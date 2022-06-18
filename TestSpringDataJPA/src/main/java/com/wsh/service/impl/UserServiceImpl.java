package com.wsh.service.impl;

import com.wsh.dao.UserDao;
import com.wsh.pojo.User;
import com.wsh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huwenshuai
 * @date 2022/6/8 19:26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List findAll() {

        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }



    @Override
    public List findByUserName(String userName) {
        return  userDao.findByUserName(userName);
    }
}
