package com.wsh.testjwtdemo.dao;

import com.wsh.testjwtdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huwenshuai
 * @date 2022/6/13 20:15
 */
@Mapper
public interface UserDao {

    User login(User user);
}
