package com.carrijo.hexagonal.application.ports.out;

import com.carrijo.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
