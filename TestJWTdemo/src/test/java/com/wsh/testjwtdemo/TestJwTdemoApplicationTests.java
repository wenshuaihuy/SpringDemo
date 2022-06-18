package com.wsh.testjwtdemo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
class TestJwTdemoApplicationTests {

    static String token = "";


    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 600);
        String token1 = JWT.create()
                .withClaim("username", "zhangsan") //设置自定义用户名
                .withClaim("userId",12)
                .withExpiresAt(instance.getTime()) //设置过期时间
                .sign(Algorithm.HMAC256("token!!!"));
        System.out.println(token1);
        token = token1;
        System.out.println("instance==" + instance.getTime());
    }

    @Test
    public void test2() {
        JWTVerifier build = JWT.require(Algorithm.HMAC256("token!!!")).build();
        DecodedJWT verify = build.verify(token);
        String payload = verify.getPayload();
        System.out.println("payload:" + payload);
        System.out.println("payload-username:" + verify.getClaim("username").asString());
        System.out.println("payload-userId:" + verify.getClaim("userId").asInt());
        System.out.println("过期时间:" + verify.getExpiresAt());

    }

}
