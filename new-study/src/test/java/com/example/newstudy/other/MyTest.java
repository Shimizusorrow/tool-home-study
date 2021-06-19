package com.example.newstudy.other;

import org.junit.jupiter.api.Test;

/**
 * @author Shimizu
 * @date 2021-05-27 15:22
 */
public class MyTest {
    @Test
    void test() {
        String a = "i";
        String b = new String("i");
        String c = "i";
        System.out.println(a == b);
        System.out.println(a == c);

        c = "4";
        System.out.println("a: " + a);
        System.out.println("c: " + c);
    }

    @Test
    void testMath() {
        System.out.println(Math.round(-1.5));
    }

    @Test
    void test2() {
        int a = 3;
        int b = 4;
        System.out.println(a ^ a ^ b);
        System.out.println(b ^ a ^ b);
    }

    /**
     * 如何将字符串翻转
     */
    @Test
    void test3() {
        String a = "Hello world";
        char[] chars = a.toCharArray();
        char[] reverse = new char[chars.length];
        for (int i = 0, len = chars.length - 1; i <= len / 2; i++) {
            reverse[i] = chars[len - i];
            reverse[len - i] = chars[i];
        }
        System.out.println(reverse);
    }

    @Test
    void test4() {
        String b = "HELLO WORLD";
        char[] chars = b.toCharArray();
        for (int i = 0, len = chars.length - 1; i < len / 2; i++) {
            chars[i] = (char) (chars[i] ^ chars[len - i]);
            chars[len - i] = (char) (chars[len - i] ^ chars[i]);
            chars[i] = (char) (chars[len - i] ^ chars[i]);
        }
        System.out.println(chars);
    }

    @Test
    void testTry() {
        System.out.println(hello());
    }

    private String hello() {
        try {
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        return "2";
    }
}
