package com.carrijo.hexagonal.application.core.usecase;

import com.carrijo.hexagonal.application.core.domain.Customer;
import com.carrijo.hexagonal.application.ports.out.FIndCustomerByIdOutputPort;

import java.util.Optional;

public class FindCustomerByIdUseCase implements FIndCustomerByIdOutputPort{

    private final FIndCustomerByIdOutputPort fIndCustomerByIdOutputPort;

    public FindCustomerByIdUseCase (FIndCustomerByIdOutputPort fIndCustomerByIdOutputPort) {
        this.fIndCustomerByIdOutputPort = fIndCustomerByIdOutputPort;
    }

    @Override
    public Optional<Customer> find(String id) {
        return Optional.ofNullable(fIndCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found")));
    }
}
