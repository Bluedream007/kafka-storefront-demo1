package com.bluedream.sample.storedemofulfillment1.respository;


import com.bluedream.sample.storedemofulfillment1.model.Fulfillment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FulfillmentRepository extends MongoRepository<Fulfillment, String> {

}