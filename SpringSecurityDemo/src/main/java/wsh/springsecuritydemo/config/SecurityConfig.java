package wsh.springsecuritydemo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author huwenshuai
 * @date 2022/6/14 17:23
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //请求授权的规则
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限直接跳到登录页面
        http.formLogin().loginPage("/toLogin");
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //认证
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()) //设置密码加密
                .withUser("wsh")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("vip2", "vip3")
                .and()
                .withUser("lx")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("vip1")
                .and()
                .withUser("root")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("vip1","vip2", "vip3");
    }
}
