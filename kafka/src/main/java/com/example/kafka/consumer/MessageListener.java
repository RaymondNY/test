package com.example.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = {"test"},groupId = "grouptest")
    public void listener(ConsumerRecord<String,String> record) throws InterruptedException {
        //获取消息
        String message = record.value();
        if (message.equals("hello4")) {
            Thread.sleep(999999);
        }
        //消息偏移量
        long offset = record.offset();
        System.out.println("读取的消息："+message+"\n当前偏移量："+offset);
    }
}

