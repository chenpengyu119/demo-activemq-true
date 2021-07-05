package com.example.provider.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

/**
 * @author pengyu
 * @date 2021/7/5 10:56
 * @description: activemq配置类
 * @create: 2021-07-05 10:56
 */
@Configuration
public class ActivemqConfig {

    @Value("${travlesky.activemq.cdm.topic}")
    private String cdmTopic;

    /**
     * 定义topic
     */
    @Bean(name = "cdm-activemq-topic")
    public Destination getTopic(){
        return new ActiveMQTopic(cdmTopic);
    }

    /**
     * 定义topic 连接工厂
     */
    @Bean
    public JmsListenerContainerFactory<?> topicConnFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        //设置为发布订阅方式, 默认情况下使用的生产消费者方式
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }
}
