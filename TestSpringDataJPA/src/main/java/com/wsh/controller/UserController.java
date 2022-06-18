package com.wsh.controller;

import com.wsh.dao.UserDao;
import com.wsh.pojo.User;
import com.wsh.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author huwenshuai
 * @date 2022/6/8 19:19
 */
@RestController
@RequestMapping("/test")
@Slf4j
@Api(tags = "用户测试接口")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/list")
    //跨域方法1 可以加@CrossOrigin注解
//    @CrossOrigin
    public List findAll() {
        return userService.findAll();

    }

    @PostMapping("/add")
    @ApiOperation(value = "保存用户方法",notes = "保存用户方法根据用户对象")
    @ApiImplicitParam
    public void save() {
        //userService.save(new User(12345, "张三", "wsh123@qq.com"));
    }

    @GetMapping("/findByName/{userName}")
    public List findByName(@PathVariable("userName")String name)  {

        return userService.findByUserName(name);
    }


}
