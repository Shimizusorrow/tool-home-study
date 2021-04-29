package com.shimizu.hutool;

import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("value")
//@SpringBootTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class ValueTest {

    @Test
    void testListAdd() {
        List a = new ArrayList();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }
        a.add(0, 100);
        a.forEach(System.out::println);
    }

    @Test
    void testList() {
        System.out.println(Box.name);
        System.out.println(Box.goods);
    }

    @Test
    void test() {
        Da d = new Da(1);
        System.out.println(d.getA());
    }

    class Da {
        private final int a;

        public int getA() {
            return a;
        }

        Da(int a) {
            this.a = a;
        }
    }

    @Test
    void testString() {
//        String a=null;
//        System.out.println(a.length());
        System.out.println(String.format("%x", 200));
    }


}

