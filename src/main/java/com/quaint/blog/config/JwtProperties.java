package com.quaint.blog.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author  by quaint on 2019-12-11
 */
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtProperties {

    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}

