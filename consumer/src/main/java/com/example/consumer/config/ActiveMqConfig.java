package com.example.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * @author pengyu
 * @date 2021/7/5 11:29
 * @description: activemq配置
 * @create: 2021-07-05 11:29
 */
@Configuration
public class ActiveMqConfig {

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
