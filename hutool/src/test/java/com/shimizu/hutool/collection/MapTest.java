package com.shimizu.hutool.collection;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shimizu
 * @description
 * @date 2021-05-08 11:14
 */
public class MapTest {
    @Test
    void putIfAbsent() {
        Map a = new HashMap<String, String>();
        Object o = a.putIfAbsent("1", "1");
        System.out.println(o);
    }

    @Test
    void test() {
        Map a = new HashMap<String, String>();
        Object put = a.put("1", "1");
        System.out.println(put);
        a.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });

    }
}
