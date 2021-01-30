package com.example.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-30 11:42
 */
public class PasswordEncoderUtils {
    private static final PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * TODO
     */
    static {
    }

    public static PasswordEncoder getBCryptPasswordEncoder() {
        return bCryptPasswordEncoder;
    }

    private PasswordEncoderUtils() {

    }
}
