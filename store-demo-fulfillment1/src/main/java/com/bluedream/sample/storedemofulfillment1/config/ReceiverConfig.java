package com.bluedream.sample.storedemofulfillment1.config;

import com.bluedream.sample.storedemofulfillment1.kafka.Receiver;
import com.bluedream.sample.storedemofulfillment1.model.FulfillmentRequestEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

import java.util.Map;

public interface ReceiverConfig {

    @Bean
    Map<String, Object> consumerConfigs();

    @Bean
    ConsumerFactory<String, String> consumerFactory();

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory();


    /*
    @Bean
    ConsumerFactory<String, FulfillmentRequestEvent> consumerFactory();

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, FulfillmentRequestEvent> kafkaListenerContainerFactory();
     */
    @Bean
    Receiver receiver();
}
