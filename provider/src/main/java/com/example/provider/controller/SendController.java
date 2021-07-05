package com.example.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @author pengyu
 * @date 2021/7/5 11:05
 * @description: 发送消息Controller
 * @create: 2021-07-05 11:05
 */
@RestController
public class SendController {

    /**
     * 引入topic
     */
    @Autowired
    @Qualifier("cdm-activemq-topic")
    private Destination topic;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("sendTopic")
    public void sendTopic(){
        jmsMessagingTemplate.convertAndSend(topic, "这是一条测试消息");
    }
}
