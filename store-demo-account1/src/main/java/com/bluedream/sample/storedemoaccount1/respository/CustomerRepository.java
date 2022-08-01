package com.bluedream.sample.storedemoaccount1.respository;


import com.bluedream.sample.storedemoaccount1.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

//    List<Customer> findByName(Name name);
}