package com.shimizu.hutool;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
        String x="xxxx";

        System.out.println(String.format("%X",15));

    }

    @Test
    void Test() {

        TreeSet<String> set = new TreeSet<String>();
        List<String> list = new ArrayList<>();
        for (int i = 10; i < 20; i++) {
            list.add(String.format("%02x", i));
            set.add(String.format("%02x", i));
        }
        list.forEach(it -> System.out.println(it));
        System.out.println("====");
        set.forEach(it -> System.out.println(it));
    }

    @Test
    void tests() {
        String e1 = String.format("%x", 11);
        String e2 = String.format("%x", 12);
        String e3 = String.format("%x", 13);
        String e4 = String.format("%x", 14);
        Set<Bos> bos = new TreeSet<>();
        bos.add(new Bos(e1));
        bos.add(new Bos(e2));
        bos.add(new Bos(e3));
        bos.add(new Bos(e4));

        bos.forEach(it -> System.out.println(it.getId()));
    }

    @Test
    void box(){

        System.out.println(BoxRfidParseUtils.parseEquipSerialNumber("33030024101004131dd800260021FFFF"));
        System.out.println(BoxRfidParseUtils.parseEquipSerialNumber("33030024101004131dd800240021FFFF"));
    }

    @Getter
    @Setter
    @NoArgsConstructor
    class Bos implements Comparable<Bos> {
        private String id;


        public Bos(String id) {
            this.id = id;
        }

        @Override
        public int compareTo(Bos o) {
            return Integer.parseInt(this.getId(), 16) - Integer.parseInt(o.getId(), 16);
            /**
             * e
             * d
             * c
             * b
             */
//            return Integer.parseInt(o.getId(), 16) - Integer.parseInt(this.getId(), 16);
        }
    }
}
