package com.shimizu.rabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/16 11:33
 */
@Component   // 持久化 非独占 不是自动删除的队列
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloCustomer {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("message" + message);
    }

}
