package com.example.security.config.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author shimizu
 */
public interface SecurityUserParser {


    /**
     * 将 UserDetails 的内容转换为安全用户
     *
     * @param userDetails
     * @return
     */
    Object transferToSecurityUser(UserDetails userDetails);

}