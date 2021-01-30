package com.example.security.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEncoderUtilsTest {
    @Test
    void decode() {
        System.out.println(PasswordEncoderUtils
                .getBCryptPasswordEncoder().encode("4"));
    }
}