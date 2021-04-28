package com.shimizu.hutool.abstracts;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-28 10:05
 */
public class DefaultNumberGenerate extends AbstractNumberGenerate {

    private DefaultNumberGenerate() {

    }

    public static void addString(String str) {
        DefaultNumberGenerate.getSet().add(str);
    }

    public static void print() {
        System.out.println(DefaultNumberGenerate.class.getName());
        DefaultNumberGenerate.getSet().forEach(System.out::println);
    }
}
