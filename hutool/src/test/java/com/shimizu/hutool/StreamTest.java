package com.shimizu.hutool;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
public class StreamTest {

    @Test
    void filterTest() {
        ArrayList<User> users = new ArrayList<>(Arrays.asList(
                new User("张三", "男", 18),
                new User("李四", "男", 18),
                new User("王五", "男", 18),
                new User("张三", "女", 16),
                new User("张三", "女", 15),
                new User("赵六", "男", 15),
                new User("江七", "男", 20)
        ));

        users.stream().filter(it -> "张三".equals(it.getName()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    @Test
    void testCollectAndThen() {
        ArrayList<User> users = new ArrayList<>(Arrays.asList(
                new User("张三", "男", 18),
                new User("李四", "男", 18),
                new User("王五", "男", 18),
                new User("张三", "女", 16),
                new User("张三", "女", 15),
                new User("赵六", "男", 15),
                new User("江七", "男", 20)
        ));
        ArrayList<String> collect = users.stream().collect(Collectors.collectingAndThen(
                Collectors.collectingAndThen(
                        Collectors.groupingBy(User::getName),
                        it -> it.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList())
                ),
                ArrayList::new
        ));
    }

    /**
     * 对数组元素 进行整合
     */
    @Test
    void testGroupBy() {
        ArrayList<User> users = new ArrayList<>(Arrays.asList(
                new User("张三", "男", 18),
                new User("李四", "男", 18),
                new User("王五", "男", 18),
                new User("张三", "女", 16),
                new User("张三", "女", 15),
                new User("赵六", "男", 15),
                new User("江七", "男", 20)
        ));

        Map<String, User> map = new HashMap<>();
        users.stream().forEach(it -> {
            if (!map.containsKey(it.name + it.gender)) {
                map.put(it.name + it.gender, it);
            } else {
                User user = map.get(it.name + it.gender);
                user.age = user.age + it.age;
                map.put(it.name + it.gender, user);
            }
        });
        List<User> users1 = map.entrySet().stream().map(it -> it.getValue()).collect(Collectors.toList());
        users1.forEach(it -> {
            System.out.println(it.name + it.gender + ":" + it.age);
        });
    }

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
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(it -> it.getName() + it.gender))),
                ArrayList::new
        ));
//        List<User> duplicateName = users.stream().filter(it -> !it.name.equals("张三")).collect(Collectors.toList());
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    @Test
    void test() {
        List<String> list = Arrays.asList("1-1,1-2,1-3");
        String a = "1-02";
        String[] split = a.split("-");
        System.out.println(Integer.parseInt(split[0]));
        System.out.println(Integer.parseInt(split[1]));
    }
}
