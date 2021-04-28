package com.shimizu.hutool.abstracts;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-28 10:03
 */
public class RecordNumberGenerate extends AbstractNumberGenerate {
    private RecordNumberGenerate() {

    }

    public static void addString(String str) {
        RecordNumberGenerate.getSet().add(str);
    }

    public static void print() {
        System.out.println(RecordNumberGenerate.class.getName());
        RecordNumberGenerate.getSet().forEach(System.out::println);
    }
}
