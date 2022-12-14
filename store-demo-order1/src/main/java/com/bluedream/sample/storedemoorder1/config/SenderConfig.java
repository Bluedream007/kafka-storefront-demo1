package com.bluedream.sample.storedemoorder1.config;


import com.bluedream.sample.storedemoorder1.kafka.Sender;
import com.bluedream.sample.storedemoorder1.model.FulfillmentRequestEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

public interface SenderConfig {

    @Bean
    Map<String, Object> producerConfigs();

    @Bean
    ProducerFactory<String, FulfillmentRequestEvent> producerFactory();

    @Bean
    KafkaTemplate<String, FulfillmentRequestEvent> kafkaTemplate();

    @Bean
    Sender sender();
}
