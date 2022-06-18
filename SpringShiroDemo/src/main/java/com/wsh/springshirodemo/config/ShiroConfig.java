package com.wsh.springshirodemo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.catalina.User;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author huwenshuai
 * @date 2022/6/15 14:45
 */
@Configuration
public class ShiroConfig {

    //subject
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);


        HashMap<String, String> filterMap = new HashMap<>();
        /*
        anon:无需认证就可以访问
        authc:必须认证才能访问
        user:必须拥有记住我功能才能访问
        perms:拥有对某个资源的权限才能访问
        role:拥有某个角色权限才能访问
         */
//        filterMap.put("/user/add", "authc");
//        filterMap.put("/user/update", "authc");
//        filterMap.put("/user/*", "authc");
        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/update", "perms[user:update]");

        bean.setFilterChainDefinitionMap(filterMap);

        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/unAuth");



        return bean;
    }
    //SecurityManager
    @Bean
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //Realm
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

}
