package com.bluedream.sample.storedemoorder1.kafka;

import com.bluedream.sample.storedemoorder1.model.CustomerOrders;
import com.bluedream.sample.storedemoorder1.model.OrderStatusChangeEvent;
import com.bluedream.sample.storedemoorder1.respository.CustomerOrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class Receiver {

    @Autowired
    private CustomerOrdersRepository customerOrdersRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private final CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {

        return latch;
    }

    // @KafkaListener(topics = "accounts.customer.change")
    @KafkaListener(topics = "${mysetting.kafka.topic.accounts-customer}")
    public void receiveCustomerOrder(CustomerOrders customerOrders) {

        log.info("received payload='{}'", customerOrders);
        latch.countDown();
        customerOrdersRepository.save(customerOrders);
    }

    // @KafkaListener(topics = "fulfillment.order.change")
    @KafkaListener(topics = "${mysetting.kafka.topic.fulfillment-order}")
    public void receiveOrderStatusChangeEvents(OrderStatusChangeEvent orderStatusChangeEvent) {

        log.info("received payload='{}'", orderStatusChangeEvent);
        latch.countDown();

        Criteria criteria = Criteria.where("orders.guid")
                .is(orderStatusChangeEvent.getGuid());
        Query query = Query.query(criteria);

        Update update = new Update();
        update.addToSet("orders.$.orderStatusEvents", orderStatusChangeEvent.getOrderStatusEvent());
        mongoTemplate.updateFirst(query, update, "customer.orders");
    }
}