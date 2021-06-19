package com.example.newstudy.algorithm;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Shimizu
 * @date 2021-06-05 08:19
 */
public class _6 {
    @Test
    void test() {

        int[] a = new int[]{1, 2, 2, 3, 3};
        int[] b = new int[]{1, 2, 2, 3, 3};
        Stream.of(Arrays.asList(intersect(a, b))).forEach(System.out::println);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] rs = new int[Math.min(len1, len2)];
        return rs;
    }

    @Test
    void test2() {
        String s = "9,8";
        System.out.println(isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        char[] array = s.toLowerCase().toCharArray();
        int len = array.length;
        if (len <= 1) {
            return true;
        }
        List<Character> c = new ArrayList<>(Math.max(16, (int) (array.length / 0.75) + 1));
        for (int i = 0; i < len; i++) {
            if (isNumberOrWord(array[i])) {
                c.add(array[i]);
            }
        }
        if (c.size() <= 1) {
            return true;
        }
        for (int i = 0, clen = c.size() - 1; i <= (clen + 1) / 2; i++) {
            if (!c.get(i).equals(c.get(clen - i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumberOrWord(char c) {
        if (c - '0' >= 0 && c - '0' <= 9 || c - 'a' >= 0 && c - 'a' < 26) {
            return true;
        }
        return false;
    }

    @Test
    void testOOM() {
        List<Byte[]> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                list.add(new Byte[1024 * 1024]);
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("执行了" + i + "次");
        }
    }

    @Test
    void testStringValue() {
        int a = 1, b = 2;
        System.out.println(String.format("%d-%d", a, b));
    }

}
