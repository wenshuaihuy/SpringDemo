package com.wsh.testjwtdemo.config;

import com.wsh.testjwtdemo.interceptor.JWTInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author huwenshuai
 * @date 2022/6/14 16:00
 */
@Component
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/user/test") //拦截
                .excludePathPatterns("/user/login") // 放行
        ;
    }
}
