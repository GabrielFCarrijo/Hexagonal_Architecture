package com.carrijo.hexagonal.application.adapters.out.repository.mapper;

import com.carrijo.hexagonal.application.adapters.in.controlleer.request.CustomerRequest;
import com.carrijo.hexagonal.application.adapters.in.controlleer.response.CustomerResponse;
import com.carrijo.hexagonal.application.adapters.out.repository.entity.CustomerEntity;
import com.carrijo.hexagonal.application.core.domain.Customer;
import org.springframework.web.bind.annotation.Mapping;

public interface CustomerMapper {
    CustomerEntity toCustomerEntity(Customer customer);
    Customer toCustomer(CustomerRequest customer);
    Customer toCustomer(CustomerEntity customer);
    CustomerResponse toCustomerResponse(Customer customer);
}
