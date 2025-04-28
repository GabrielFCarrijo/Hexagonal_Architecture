package com.carrijo.hexagonal.application.adapters.out;

import com.carrijo.hexagonal.application.adapters.out.repository.CustomerRepository;
import com.carrijo.hexagonal.application.adapters.out.repository.mapper.CustomerMapper;
import com.carrijo.hexagonal.application.core.domain.Customer;
import com.carrijo.hexagonal.application.ports.out.FIndCustomerByIdOutputPort;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FIndCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Optional<Customer> find (String id) {
        val customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerMapper.toCustomer(entity));
    }
}
