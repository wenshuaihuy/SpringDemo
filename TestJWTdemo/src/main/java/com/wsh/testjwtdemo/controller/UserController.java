package com.wsh.testjwtdemo.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import com.wsh.testjwtdemo.entity.User;
import com.wsh.testjwtdemo.service.UserService;
import com.wsh.testjwtdemo.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huwenshuai
 * @date 2022/6/14 14:21
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public Map<String, Object> login(User user) {
        log.info("name:" + user.getName());
        log.info("password:" + user.getPassword());
        Map<String, Object> hashMap = new HashMap<>();
        try {
            User login = userService.login(user);
            Map<String, String> payload = new HashMap<>();
            payload.put("id", user.getId());
            payload.put("name", user.getName());
            payload.put("password", user.getPassword());
            String token = JWTUtils.getToken(payload);

            hashMap.put("state", true);
            hashMap.put("msg:", "success");
            hashMap.put("token:", token);


        } catch (Exception e) {
            hashMap.put("state", false);
            hashMap.put("msg:", e.getMessage());
        }
        return hashMap;
    }

    @PostMapping("/user/test")
    public Map<String, Object> testToken(HttpServletRequest request) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("state", true);
        hashMap.put("msg:", "success");
        return hashMap;

    }
}
