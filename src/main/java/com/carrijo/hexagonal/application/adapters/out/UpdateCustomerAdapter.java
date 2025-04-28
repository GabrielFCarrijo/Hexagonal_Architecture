package com.carrijo.hexagonal.application.adapters.out;

import com.carrijo.hexagonal.application.adapters.out.repository.CustomerRepository;
import com.carrijo.hexagonal.application.adapters.out.repository.mapper.CustomerMapper;
import com.carrijo.hexagonal.application.core.domain.Customer;
import com.carrijo.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void update (Customer customer) {
        customerRepository.save(customerMapper.toCustomerEntity(customer));
    }
}
