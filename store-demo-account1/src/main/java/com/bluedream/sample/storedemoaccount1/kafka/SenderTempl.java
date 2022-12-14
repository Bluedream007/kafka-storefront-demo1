package com.bluedream.sample.storedemoaccount1.kafka;

import com.bluedream.sample.storedemoaccount1.model.CustomerChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
public class SenderTempl {

    @Autowired
    private KafkaTemplate<String, CustomerChangeEvent> kafkaTemplate;

    public void send(String topic, CustomerChangeEvent payload) {

        log.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }
}