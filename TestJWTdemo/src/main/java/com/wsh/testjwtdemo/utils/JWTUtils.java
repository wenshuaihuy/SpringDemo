package com.wsh.testjwtdemo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;

import java.util.Calendar;
import java.util.Map;

/**
 * @author huwenshuai
 * @date 2022/6/13 14:49
 */
@Logger
@Slf4j
public class JWTUtils {
    private static final String SIGN = "TOKEN!!!!@#$%ASDF";


    /**
     * getToken head.payload.sign
     * @param map
     * @return
     */
    public static String getToken(Map<String,String> map) {
        Calendar instance = Calendar.getInstance();
        //设置七天过期
        instance.add(Calendar.DATE, 7);
        JWTCreator.Builder builder = JWT.create();
        //遍历map里的东西并且设置payload
        map.forEach(builder::withClaim);
        String token = builder
                .withExpiresAt(instance.getTime()) //设置过期时间
                .sign(Algorithm.HMAC256(SIGN)); //sign
        log.debug("token:"+token);
        System.out.println("过期时间：" + instance.getTime());
        return token;
    }

    /**
     * Verify Token
     * @param token token
     */
    public static DecodedJWT verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }

    /**
     * get Token Info
     * @param token
     * @return
     */
//    public static DecodedJWT getTokenInfo(String token) {
//        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
//    }


}
