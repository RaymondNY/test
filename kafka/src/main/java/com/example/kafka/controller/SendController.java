package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
public class SendController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /***
     * 发送消息
     * topic:要发送的队列
     * msg:发送的消息
     */
    @GetMapping(value = "/send/{topic}/{msg}")
    public String send(@PathVariable(value = "topic")String topic, @PathVariable(value = "msg")String msg){
        //消息发送
        for (int i = 0; i < 10; i++) {
            kafkaTemplate.send(topic,msg+i);
        }
        return "SUCCESS";
    }
}
