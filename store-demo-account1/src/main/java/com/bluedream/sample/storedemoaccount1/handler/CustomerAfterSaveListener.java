package com.bluedream.sample.storedemoaccount1.handler;


import com.bluedream.sample.storedemoaccount1.kafka.SenderTempl;
import com.bluedream.sample.storedemoaccount1.model.Customer;
import com.bluedream.sample.storedemoaccount1.model.CustomerChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class CustomerAfterSaveListener extends AbstractMongoEventListener<Customer> {

    //@Value("${spring.kafka.topic.accounts-customer}")
    @Value("${mysetting.kafka.topic.accounts-customer}")
    private String topic;

    private final SenderTempl senderTempl;

    @Autowired
    public CustomerAfterSaveListener(SenderTempl senderTempl) {

        this.senderTempl = senderTempl;
    }

    @Override
    public void onAfterSave(@NotNull AfterSaveEvent<Customer> event) {

        log.info("onAfterSave event='{}'", event);
        Customer customer = event.getSource();

        CustomerChangeEvent customerChangeEvent = new CustomerChangeEvent();
        customerChangeEvent.setId(customer.getId());
        customerChangeEvent.setName(customer.getName());
        customerChangeEvent.setContact(customer.getContact());
        customerChangeEvent.setAddresses(customer.getAddresses());

        senderTempl.send(topic, customerChangeEvent);
    }
}