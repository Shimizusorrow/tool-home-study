package com.example.newstudy.algorithm;

import org.junit.jupiter.api.Test;

/**
 * @author Shimizu
 * @date 2021-06-05 08:19
 */
public class _5 {
    @Test
    void test() {
        int a = 2;
        int b = 2;
        int c = 3;
        System.out.println(a ^ b ^ c ^ a ^ a);
        System.out.println(a & c);
        int[] e = new int[]{1, 2, 2, 3, 3};
        System.out.println(singleNumber(e));
    }

    public int singleNumber(int[] nums) {
        int temp = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            temp ^= nums[i];
        }
        return temp;
    }

}
