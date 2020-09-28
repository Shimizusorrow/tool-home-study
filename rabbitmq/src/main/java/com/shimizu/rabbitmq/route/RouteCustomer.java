package com.shimizu.rabbitmq.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/16 13:31
 */
@Component
public class RouteCustomer {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "directs", type = "direct"),//自定义交换机名称和类型
                    key = {"info", "error", "warn"}
            )
    })
    public void receive1(String message) {
        System.out.println("message1 :" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "directs", type = "direct"),//自定义交换机名称和类型
                    key = {"error","info"}
            )
    })
    public void receive2(String message) {
        System.out.println("message2 :" + message);
    }
}
