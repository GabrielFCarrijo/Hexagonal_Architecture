package com.carrijo.hexagonal.application.ports.in;

import com.carrijo.hexagonal.application.core.domain.Customer;

public interface FindCustomerByInputPort {

    Customer find(String id);
}
