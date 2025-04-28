package com.carrijo.hexagonal.application.adapters.out.repository;

import com.carrijo.hexagonal.application.adapters.out.repository.entity.CustomerEntity;
import com.carrijo.hexagonal.application.core.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
