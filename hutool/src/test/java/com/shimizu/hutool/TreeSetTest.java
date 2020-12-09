package com.shimizu.hutool;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

/**
 * @author Shimizu
 * @description test
 * @date 2020-12-08 11:50
 */
@ExtendWith(SpringExtension.class)
public class TreeSetTest {
    @Test
    void test() {

        List<String> list = new ArrayList();
        String s = null;
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        if (!list.isEmpty()) {
            s = list.get(list.size() - 1);
        }
        System.out.println(s);


    }
}
