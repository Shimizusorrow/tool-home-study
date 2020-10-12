package com.shimizu.hutool;

import cn.hutool.core.convert.Convert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sun.rmi.runtime.Log;

import javax.management.timer.Timer;
import java.nio.charset.Charset;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/24 8:54
 */
@ExtendWith(SpringExtension.class)
public class HuToolTest {

    @Test
    void test() {
        String a = Convert.toStr(1);
    }

    @Test
    void copy() {
//        InputStream inputStream=new InputStream(new Fi);
//        IoUtil.copy();
    }

    @Test
    void testConvert() {
        String a = "010101010101010101";
        String s = Long.toHexString(Long.parseLong(a));
        System.out.println("---------------");
        System.out.println(s);
        String s1 = Convert.toHex(a, Charset.defaultCharset());
    }

    @Test
    void otherTest() {
        List<String> strings = Arrays.asList("1", "2");
        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(strings.get(strings.size() - 1));
        System.out.println(objects.get(strings.size() - 1));
    }

    @Test
    void _2020_10_7() {
        HouseCategoryEnum[] values = HouseCategoryEnum.values();
        List<HouseCategoryEnum> houseCategoryEnums = Arrays.asList(values);
        List<String> strings = houseCategoryEnums.stream().map(Enum::name).collect(Collectors.toList());
        strings.forEach(System.out::println);
    }

    @Test
    void _2020_10_9() {
        Long value = Long.valueOf("5301");
        String s = Long.toHexString(value);
        System.out.println(s);
        /**
         *
         */
        Long of = Long.valueOf("6401");
        String s1 = Long.toHexString(of);
        System.out.println(String.format("%x", of));

    }

    @Test
    void _2020_10_10() {
        System.out.println();
        System.out.println(Timer.ONE_DAY * 365 * 8 + ((int) (Math.random() * 100000)));
        System.out.println(220752072946L / (Timer.ONE_DAY * 365));
        System.out.println(252288058988L / (Timer.ONE_DAY * 365));

        System.out.println(shelfLife2Hex(220752072946L));
        System.out.println(shelfLife2Hex(252288058988L));

        System.out.println(String.valueOf(0));

        System.out.println(productDate2Hex(1602315857000L));
        System.out.println((1602315857000L - MIN_PRODUCT_TIME) / Timer.ONE_DAY);

        String x="1234567891234567890012345";
        System.out.println(x.substring(20,24));
    }

    private String shelfLife2Hex(Long shelfLife) {
        int year = (int) (shelfLife / (Timer.ONE_DAY * 365));
        if (year == 10) {
            return "a";
        }
        if (year == 11) {
            return "b";
        }
        if (year == 12) {
            return "c";
        }
        if (year >= 15 && year < 20) {
            return "c";
        }
        if (year >= 20 && year < 25) {
            return "d";
        }
        if (year >= 25 && year < 99) {
            return "e";
        }
        if (year >= 99) {
            return "f";
        }
        return String.valueOf(year);
    }
    private final Long MIN_PRODUCT_TIME = 946656000000L;

    private String productDate2Hex(Long productDate) {
        return String.format("%04x", (productDate - MIN_PRODUCT_TIME) / Timer.ONE_DAY);
    }
}
