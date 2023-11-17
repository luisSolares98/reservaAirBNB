package com.nur.rabbit;

import com.nur.model.Publication;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = Config.QUEUE)
    public void listener(CustomMessage message) {
        System.out.println(message);
    }

}