package com.shimizu.hutool;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
public class CatTest {
    @Data
    @NoArgsConstructor
    private class Cat {
        private String id;
        private String name;

        public Cat(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Data
    @NoArgsConstructor
    private class Dog {
        private String id;
        private String name;

        public Dog(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static List<Cat> cats = new ArrayList<>();

    @BeforeEach
    void before() {
        cats.add(new Cat("0", "小黑"));
        cats.add(new Cat("1", "小红"));
    }

    @Test
    void test() {
        List<Dog> dogs = cats.stream().map(it -> {
            if ("0".equals(it.getId())) {
                return new Dog(it.getId(), it.getName());
            }
            return null;
        }).filter(it->!Objects.isNull(it)).collect(Collectors.toList());
        dogs.forEach(it-> System.out.println(it.toString()));
    }
}
