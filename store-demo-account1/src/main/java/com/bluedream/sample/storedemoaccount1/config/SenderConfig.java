package com.bluedream.sample.storedemoaccount1.config;


import com.bluedream.sample.storedemoaccount1.kafka.SenderTempl;
import com.bluedream.sample.storedemoaccount1.model.CustomerChangeEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

public interface SenderConfig {

    @Bean
    Map<String, Object> producerConfigs();

    @Bean
    ProducerFactory<String, CustomerChangeEvent> producerFactory();

    @Bean
    KafkaTemplate<String, CustomerChangeEvent> kafkaTemplate();

    @Bean
    SenderTempl senderTempl();
}
