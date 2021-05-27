package com.shimizu.hutool.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Shimizu
 * @description
 * @date 2021-05-08 10:57
 */
//@ExtendWith(SpringExtension.class)
public class QueueTest {

    @Test
    void test() {
        ArrayDeque<String> q = new ArrayDeque<>();
        assertEquals(true, q.offer("1"));
        assertEquals("1", q.element());
        assertEquals(true, q.add("2"));
        assertEquals("1", q.poll());
        assertEquals(true, q.add("2"));
        assertEquals("2", q.pop());
        assertEquals("2", q.peek());

    }

    @Test
    void test2() {
        ArrayDeque<String> q = new ArrayDeque<>();
        //1->2->3
        q.offer("1");
        q.offer("2");
        q.offer("3");
        String pop = q.pop();
        System.out.println(pop);
        System.out.println("----");
        q.forEach(System.out::println);
    }

    @Test
    void test3() {
        ArrayDeque<String> q = new ArrayDeque<>();
        //1->2->3
        q.offer("1");
        q.offer("2");
        q.offer("3");
        String poll = q.poll();
        System.out.println(poll);
        System.out.println("----");
        q.forEach(System.out::println);
    }

    @Test
    void test4(){
        ArrayDeque<String> q = new ArrayDeque<>();
        System.out.println(q.poll());
        System.out.println(q.pop());
    }

}
