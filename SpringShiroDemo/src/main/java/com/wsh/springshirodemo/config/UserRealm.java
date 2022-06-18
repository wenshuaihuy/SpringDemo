package com.wsh.springshirodemo.config;

import com.wsh.springshirodemo.pojo.User;
import com.wsh.springshirodemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author huwenshuai
 * @date 2022/6/15 14:46
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.debug("授权======");
        System.out.println("授权======");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        info.addStringPermission(user.getPerms());

        return info;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.debug("认证======");
        System.out.println("认证======");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        User user = userService.queryUserByName(usernamePasswordToken.getUsername());
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("loginUser", user);
        if (user==null) {
            return null;
        }
        //密码认证shiro做
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
