package com.shimizu.excel;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式模糊匹配
 *
 * @author Shimizu
 * @description
 * @date 2021-03-11 15:09
 */
@ExtendWith(SpringExtension.class)
public class NormalTest {

    @Test
    void test23(){
        List<String> list = Arrays.asList("1", "2", "3");
        List<String> strings = Arrays.asList("1", "2","2","3");
        System.out.println(
                list.containsAll(strings)
        );
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getDayOfMonth());
    }

    @Test
    void test() {
        List<String> list = Arrays.asList("张三", "张三啊", "我是张三", "我是Super张三");
        String search = "啊";
        String regex = String.format(".*%s.*", search);
        Pattern pattern = Pattern.compile(regex);

        list.stream()
                .filter(it -> pattern.matcher(it).matches())
                .forEach(System.out::println);
    }

    @Test
    void test2() {
        String a = "张三";
        String b = "张三啊";
        String c = "啊张三";
        String regex = String.format("%s.*|.*%s", a, a);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(c);
        System.out.println(regex + ">>>" + c + ";校验结果为：" + (matcher.matches() ? "通过" : "未通过"));
//        System.out.println(regex);
    }

    @Data
    public static class Asc {
        public String name;

        public Asc(String name) {
            this.name = name;
        }
    }

    @Test
    void tps() {
        List<Asc>ascs=new ArrayList<>();
        ascs.add(new Asc("2"));
        ascs.add(new Asc("2"));
        ascs.add(new Asc("2"));
        ascs.add(new Asc("2"));

        foreach(ascs);
        ascs.forEach(it-> System.out.println(it.name));
    }


    void foreach(List<Asc> list) {
        list.forEach(it -> it.name = "1");
    }
}
