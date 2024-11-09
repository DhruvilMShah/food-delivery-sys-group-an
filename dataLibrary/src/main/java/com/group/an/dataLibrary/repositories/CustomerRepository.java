package com.group.an.dataLibrary.repositories;

import com.group.an.dataLibrary.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository <Customer,Integer> {

    Customer findByCustomerId(int customerId);

}
