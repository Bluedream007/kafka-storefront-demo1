package com.bluedream.sample.storedemoaccount1.controller;

import com.bluedream.sample.storedemoaccount1.model.Customer;
import com.bluedream.sample.storedemoaccount1.respository.CustomerRepository;
import com.bluedream.sample.storedemoaccount1.utilities.SampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Value("${my-env-name}")
    private String strEnvName;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @RequestMapping(path = "/sample", method = RequestMethod.GET)
    public ResponseEntity<String> sampleData() {

        customerRepository.deleteAll();
        customerRepository.saveAll(SampleData.createSampleCustomers());

        return new ResponseEntity<>("Sample customer accounts created in Env: " + strEnvName, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/summary", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, List<Customer>>> customerSummary() {

        List<Customer> customerList = customerRepository.findAll();
        return new ResponseEntity<>(Collections.singletonMap("customers", customerList), HttpStatus.OK);
    }
}
