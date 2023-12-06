package com.nur.controller;

import com.nur.rabbit.Config;
import com.nur.rabbit.CustomMessage;
import com.nur.rabbit.Pattern;
import com.nur.rabbit.Response;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/publish")
public class RabbitController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/")
    public String publishMessage(@RequestBody CustomMessage message) {

        Pattern pattern = Pattern.builder().cmd(Config.EXCHANGE).build();

        CustomMessage message2 = CustomMessage.builder().id(UUID.randomUUID())
                .message(message.getMessage()).build();

        Response response = Response.builder().data(message2).pattern(pattern).build();

        template.convertAndSend(Config.EXCHANGE, response);

        return "Message Published";
    }
}