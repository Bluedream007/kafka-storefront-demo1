package com.bluedream.sample.storedemoorder1.kafka;


import com.bluedream.sample.storedemoorder1.model.FulfillmentRequestEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
public class Sender {

    @Autowired
    private KafkaTemplate<String, FulfillmentRequestEvent> kafkaTemplate;

    public void send(String topic, FulfillmentRequestEvent payload) {

        log.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }
}