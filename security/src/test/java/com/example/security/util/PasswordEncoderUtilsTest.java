package com.example.security.util;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEncoderUtilsTest {
    @Test
    void encode() {
        System.out.println(PasswordEncoderUtils
                .getBCryptPasswordEncoder().encode("4"));
    }

    @Test
    void decode() {
        PasswordEncoder encoder = PasswordEncoderUtils.getBCryptPasswordEncoder();
        String encode = encoder.encode("5");
        System.out.println(encode);
        System.out.println(encoder.matches("5", encode));

    }
}