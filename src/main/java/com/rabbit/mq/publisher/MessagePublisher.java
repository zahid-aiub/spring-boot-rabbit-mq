package com.rabbit.mq.publisher;

import com.rabbit.mq.model.CustomMessage;
import com.rabbit.mq.config.MqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/publish")
    public String publish(@RequestBody CustomMessage customMessage) {
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessage(customMessage.getMessage());
        customMessage.setMessageDate(new Date());
        rabbitTemplate.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTING_KEY, customMessage);
        return "Message sent to Queue";
    }

}
