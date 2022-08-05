package com.bluedream.sample.storedemofulfillment1.kafka;

import com.bluedream.sample.storedemofulfillment1.model.Fulfillment;
import com.bluedream.sample.storedemofulfillment1.model.FulfillmentRequestEvent;
import com.bluedream.sample.storedemofulfillment1.respository.FulfillmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class Receiver {

    @Autowired
    private FulfillmentRepository fulfillmentRepository;

    private final CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {

        return latch;
    }

    //@KafkaListener(topics = "${spring.kafka.topic.orders-order}")
    @KafkaListener(topics = "${mysetting.kafka.topic.orders-order}")
    public void receive(FulfillmentRequestEvent fulfillmentRequestEvent) {

        log.info("received payload='{}'", fulfillmentRequestEvent.toString());
        latch.countDown();
        Fulfillment fulfillment = new Fulfillment();
        fulfillment.setId(fulfillmentRequestEvent.getId());
        fulfillment.setTimestamp(fulfillmentRequestEvent.getTimestamp());
        fulfillment.setName(fulfillmentRequestEvent.getName());
        fulfillment.setContact(fulfillmentRequestEvent.getContact());
        fulfillment.setAddress(fulfillmentRequestEvent.getAddress());
        fulfillment.setOrder(fulfillmentRequestEvent.getOrder());
        fulfillmentRepository.save(fulfillment);
    }
}