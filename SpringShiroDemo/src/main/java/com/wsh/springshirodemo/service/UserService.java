package com.wsh.springshirodemo.service;

import com.wsh.springshirodemo.pojo.User;

/**
 * @author huwenshuai
 * @date 2022/6/15 16:21
 */
public interface UserService {
    public User queryUserByName(String name);
}
