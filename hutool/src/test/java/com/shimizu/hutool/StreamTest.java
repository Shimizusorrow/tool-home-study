package com.shimizu.hutool;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.ArrayEquals;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
public class StreamTest {

    /**
     * collectingAndThen 方法对数组对象or元素去重
     */
    @Test
    void testCollectingAndThen() {
        ArrayList<User> users = new ArrayList<>(Arrays.asList(
                new User("张三", "男", 18),
                new User("李四", "男", 18),
                new User("王五", "男", 18),
                new User("张三", "女", 16),
                new User("张三", "女", 15),
                new User("赵六", "男", 15),
                new User("江七", "男", 20)
        ));
        /**
         * 对名字进行去重
         */
        ArrayList<User> duplicateName = users.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getName))),
                ArrayList::new
        ));
        users.forEach(it -> {
            System.out.println(it.toString());
        });
        System.out.println("------对名字进行去重------");
        duplicateName.forEach(it -> {
            System.out.println(it.toString());
        });
    }

    /**
     * 测试类
     */
    @Data
    private class User {
        private String name;
        private String gender;
        private Integer age;

        public User(String name, String gender, Integer age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }
        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
