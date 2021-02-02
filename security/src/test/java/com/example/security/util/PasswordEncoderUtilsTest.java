package com.example.security.util;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    @Test
    void test() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        System.out.println(integers.size());
        integers.remove(1);
        System.out.println(integers.size());

    }
}