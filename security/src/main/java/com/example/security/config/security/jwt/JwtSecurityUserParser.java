package com.example.security.config.security.jwt;

import com.example.security.config.security.SecurityUserParser;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author shimizu
 */
public interface JwtSecurityUserParser extends SecurityUserParser {

    /**
     * 将 JWT 的用户转换为已认证的用户
     *
     * @param securityUser
     * @return
     */
    UserDetails transferToUserDetails(Object securityUser);

    /**
     * 反序列化指明的类型，用于 JWT 用户校验
     *
     * @return
     */
    Class<?> principleClass();

}