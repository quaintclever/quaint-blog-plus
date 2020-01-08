package com.quaint.blog.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.quaint.blog.config.JwtProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-11 11:34
 */
@Slf4j
@Component
public class JwtUtils {

    /**
     * 需要静态注入的 对象
     */
    private static JwtProperties jwtProperties;

    @Autowired
    public void setJwtProperties(JwtProperties jwtProperties) {
        JwtUtils.jwtProperties = jwtProperties;
    }

    /**
     * 生成token
     */
    public static String createToken(String issuer, Map<String, String> claims) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecretKey());
//            Algorithm algorithm = Algorithm.HMAC256("test");
            JWTCreator.Builder builder = JWT.create()
                    .withIssuer(issuer);
            claims.forEach(builder::withClaim);
            return builder.sign(algorithm);
        } catch (IllegalArgumentException | JWTCreationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 验证jwt，并返回数据
     */
    public static Map<String, String> verifyToken(String token){
        Algorithm algorithm;
        Map<String, Claim> map;
        try {
            algorithm = Algorithm.HMAC256(jwtProperties.getSecretKey());
//            algorithm = Algorithm.HMAC256("test");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            map = jwt.getClaims();
        } catch (Exception e) {
            log.warn("utils -> 验证token失败");
            return null;
        }
        Map<String, String> resultMap = new HashMap<>(map.size());
        map.forEach((k, v) -> resultMap.put(k, v.asString()));
        return resultMap;
    }

//    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("test","name");
//        String token = createToken("1",map);
//        System.out.println(token);
//        Map<String,String> testMap = verifyToken(token);
//        System.out.println(testMap.keySet());
//        System.out.println(testMap.get("test"));
//        System.out.println(testMap.get("iss"));
//    }

}
