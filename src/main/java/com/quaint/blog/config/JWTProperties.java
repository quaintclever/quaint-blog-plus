package com.quaint.blog.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by quaint on 2019-12-11
 * @description
 */
@ConfigurationProperties(prefix = "jwt")
@Component
public class JWTProperties {

    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}

