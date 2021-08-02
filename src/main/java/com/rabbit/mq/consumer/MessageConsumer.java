package com.rabbit.mq.consumer;

import com.rabbit.mq.model.CustomMessage;
import com.rabbit.mq.config.MqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
* It would be a different service or micro-service
*
* */
@Component
public class MessageConsumer {

    @RabbitListener(queues = MqConfig.QUEUE)
    public void listener(CustomMessage message) {
        System.out.println("::::::::::::::::: Received From Queue ::::::::::::::::::::::::");
        System.out.println(message);
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }
}
