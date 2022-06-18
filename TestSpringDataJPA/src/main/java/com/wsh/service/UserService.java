package com.wsh.service;

import com.wsh.pojo.User;

import java.util.List;

/**
 * @author huwenshuai
 * @date 2022/6/8 19:26
 */
public interface UserService {

    List findAll();

    void save(User user);

    List findByUserName(String userName);
}
