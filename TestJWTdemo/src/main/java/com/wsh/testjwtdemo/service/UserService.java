package com.wsh.testjwtdemo.service;

import com.wsh.testjwtdemo.entity.User;

/**
 * @author huwenshuai
 * @date 2022/6/13 20:23
 */
public interface UserService {

    User login(User user);
}
