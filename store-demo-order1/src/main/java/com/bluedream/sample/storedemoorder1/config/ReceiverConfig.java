package com.bluedream.sample.storedemoorder1.config;

import com.bluedream.sample.storedemoorder1.kafka.Receiver;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.ConsumerFactory;

import java.util.Map;

public interface ReceiverConfig {

    @Bean
    Map<String, Object> consumerConfigs();

    @Bean
    ConsumerFactory<String, String> consumerFactory();

    @Bean
    Receiver receiver();
}
