package com.shimizu.hutool;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.Collections;

@ExtendWith(SpringExtension.class)
public class SyStemTest {
    @Test
    void testGet() {
        System.getProperties().forEach((key, v) -> {
            System.out.println(String.format("key:[%s] -> v:[%s]", key, v));
        });
    }

    @Test
    void test() {
        String format = String.format("%04x", 65535);
        System.out.println(format);
    }

    @Test
    void t2() {
        String s = "33030025101004131DF500050051FFFF";
        BoxRfidParseUtils.parseBoxList2Set(Collections.singletonList(s)).forEach(it-> System.out.println(it));

    }
}
