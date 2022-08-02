
# Getting Started
### kafka-storefront-demo1 project
### Description
* Eventual Consistency with Spring for Apache Kafka: Part 1 of 2 & Part 2
  https://itnext.io/eventual-consistency-with-spring-for-apache-kafka-cfbbed450b5e
  https://itnext.io/eventual-consistency-with-spring-for-apache-kafka-part-2-of-2-23bedd512ccf

* Sub-projects
  - kafka-storefront-demo 1
    
### Build & Run

* Middleware & Environment Setting
* install & run middleware
  > cd /home/charlotte-lp/Charlotte/DVP_Java/Java_Test/Kafka/EventDriven-microservices/kafka-storefront-demo1/docker
  > docker-compose -f docker-compose-middleware-default.yml up -d
* [mongo-express](https://github.com/mongo-express/mongo-express)
  Web-based MongoDB admin interface written with Node.js, Express and Bootstrap3 
  - http://localhost:8081/

### Creating Sample Data
Create sample data for each service. Requires Kafka is running. Endpoints for Zuul, when using Docker Swarm/Stack, are different. See this [Python script](https://github.com/garystafford/storefront-kafka-docker/blob/master/refresh.py) for Zuul endpoints.

```bash
# accounts - create & show sample customer accounts - 2022/8/1 test okay
http http://localhost:8085/customers/sample
http http://localhost:8085/customers/summary

# orders - add sample orders to each customer
http http://localhost:8090/customers/sample/orders

# orders - send approved orders to fulfillment service
http http://localhost:8090/customers/sample/fulfill

# fulfillment - change fulfillment requests from approved to processing
http http://localhost:8095/fulfillments/sample/process

# fulfillment - change fulfillment requests from processing to shipping
http http://localhost:8095/fulfillments/sample/ship

# fulfillment - change fulfillment requests from processing to in transit
http http://localhost:8095/fulfillments/sample/in-transit

# fulfillment - change fulfillment requests from in transit to in received
http http://localhost:8095/fulfillments/sample/receive
```


### Reference Git
  - GitHub list
    - https://github.com/garystafford/storefront-demo-accounts
    - https://github.com/garystafford/storefront-demo

### Reference Documentation


