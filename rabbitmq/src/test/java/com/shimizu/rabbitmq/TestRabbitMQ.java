package com.shimizu.rabbitmq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 生产者测试
 *
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/16 11:14
 */
@SpringBootTest(classes = RabbitmqApplication.class)
@ExtendWith(SpringExtension.class)
public class TestRabbitMQ {
    /**
     * 注入 rabbitTemplate
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @BeforeEach
    void before() {
        assertNotNull(rabbitTemplate);
    }

    /**
     * topic 动态路由 订阅模式
     */
    @Test
    void testTopic(){
        rabbitTemplate.convertAndSend("topics","order.sss","user.save 路由消息");
    }
    /**
     * route 模式
     */
    @Test
    void testRoute() {
        rabbitTemplate.convertAndSend("directs", "info", "发送info的key的路由信息");
    }

    /**
     * fannout  广播
     */
    @Test
    void testFanout() {
        rabbitTemplate.convertAndSend("logs", "", "Fanout 模型");
    }

    /**
     * 多队列
     */
    @Test
    void testWork() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "work 模型" + i);
        }
    }

    /**
     * 单一队列
     */
    @Test
    void testHelloWorld() {
        rabbitTemplate.convertAndSend("hello", "hello world");
    }

}
