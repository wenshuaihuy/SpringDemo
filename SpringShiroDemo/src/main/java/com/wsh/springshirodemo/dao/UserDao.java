package com.wsh.springshirodemo.dao;

import com.wsh.springshirodemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huwenshuai
 * @date 2022/6/15 16:15
 */
@Mapper
public interface UserDao {
    public User queryUserByName(String name);
}
