package com.shimizu.hutool;

import cn.hutool.core.convert.Convert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
}
