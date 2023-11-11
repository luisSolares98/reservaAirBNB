package com.nur.controller;

import com.nur.rabbit.Config;
import com.nur.rabbit.CustomMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/publish")
public class RabbitController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/")
    public String publishMessage(@RequestBody CustomMessage message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(Config.EXCHANGE,
                Config.ROUTING_KEY, message);

        return "Message Published";
    }
}