package com.shimizu.hutool.algorithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Vector;

/**
 * @author Shimizu
 * @description 大数组里面找到唯一一个出现奇数次的元素
 * @date 2020-12-09 14:01
 */
@ExtendWith(SpringExtension.class)
public class L1 {
    private Integer[] list = new Integer[100000];

    @Test
    void test() {
        int nums[] = new int[]{2, 2, 1};
        System.out.println(singleNumber(nums));
    }

    private int singleNumber(int[] nums) {
        int len = nums.length;
        int a = 0;
        for (int i = 0; i < len; i++) {
            a ^= nums[i];
        }
        return a;
    }
}
