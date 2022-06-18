package com.wsh.dao;

import com.wsh.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author huwenshuai
 * @date 2022/6/8 19:20
 */
public interface UserDao extends JpaRepository<User,Integer> {

    List findByUserName(String userName);

    @Query("select u from User u where u.userName = :userName")
    Optional<User> findByNameCustomeQuery(@Param("userName") String userName);
}
