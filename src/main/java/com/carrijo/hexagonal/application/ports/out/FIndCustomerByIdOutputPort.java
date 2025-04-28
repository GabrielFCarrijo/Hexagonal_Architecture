package com.carrijo.hexagonal.application.ports.out;

import com.carrijo.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FIndCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
