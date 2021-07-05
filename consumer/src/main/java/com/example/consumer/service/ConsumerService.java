package com.example.consumer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author pengyu
 * @date 2021/7/5 11:30
 * @description:
 * @create: 2021-07-05 11:30
 */
@Service
public class ConsumerService {



    @JmsListener(destination = "ZUMTAP.FLIGHT.OUTPUT",containerFactory = "topicConnFactory")
    public void topicListener(String msg){
        System.out.println("接收到一条消息："+msg);
    }
}

