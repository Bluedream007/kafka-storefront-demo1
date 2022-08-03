package com.bluedream.sample.storedemoorder1.respository;


import com.bluedream.sample.storedemoorder1.model.CustomerOrders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerOrdersRepository extends MongoRepository<CustomerOrders, String> {

}