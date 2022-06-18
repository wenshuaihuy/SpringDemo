package com.wsh.testjwtdemo.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsh.testjwtdemo.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;
import java.util.HashMap;

/**
 * @author huwenshuai
 * @date 2022/6/14 15:40
 */
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<>();

        String token = request.getHeader("token");
        try {
            JWTUtils.verifyToken(token);
            hashMap.put("msg", "success!!");
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            hashMap.put("msg", "无效的签名");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            hashMap.put("msg", "token过期");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            hashMap.put("msg", "token算法不一致");
        } catch (Exception e) {
            e.printStackTrace();
            hashMap.put("msg", "token无效");
        }
        hashMap.put("state", false);
        //将map转为json
        String json = new ObjectMapper().writeValueAsString(hashMap);
        log.debug("json:" + json);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
