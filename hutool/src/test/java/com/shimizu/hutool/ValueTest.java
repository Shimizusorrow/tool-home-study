package com.shimizu.hutool;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("value")
//@SpringBootTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
public class ValueTest {

    @Test
    void testList() {
        System.out.println(Box.name);
        System.out.println(Box.goods);
    }

    @Test
    void testString(){
//        String a=null;
//        System.out.println(a.length());
        System.out.println(String.format("%x",200));
    }


}

