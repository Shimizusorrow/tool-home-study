package com.example.security.config.security.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.management.timer.Timer;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-30 08:58
 */

@ConfigurationProperties(
        prefix = "security.jwt"
)
public class JwtProperties {
    /**
     * 加盐
     */
    private String salt = "shimizu";

    /**
     * 默认12小时
     */
    private Long expirationTime = Timer.ONE_HOUR * 12;

    /**
     * JWT 的签名算法,默认是 HS256
     */
    private SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;

    public void setAlgorithm(String algorithm) {
        this.algorithm = SignatureAlgorithm.valueOf(algorithm);
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public SignatureAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(SignatureAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
}
