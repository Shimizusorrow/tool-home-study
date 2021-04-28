package com.shimizu.hutool.abstracts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.beans.Transient;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-28 10:06
 */
@ExtendWith(SpringExtension.class)
public class AbstractTest {
    @Test
    void test() {
        DefaultNumberGenerate.addString("1");
        DefaultNumberGenerate.print();
        RecordNumberGenerate.print();
    }

    @Test
    void testNumberGenerate() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(NumberGenerateUtils.generate());
        }
        Thread.sleep(Duration.ofSeconds(11).toMillis());
        System.out.println(NumberGenerateUtils.generate());
    }

    @Test
    void sout() {
        System.out.println(String.format("04", 4163));
        System.out.println(String.format("04X", 4635));
    }
}
