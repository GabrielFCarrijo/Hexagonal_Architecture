package com.carrijo.hexagonal.application.core.usecase;

import com.carrijo.hexagonal.application.core.domain.Customer;
import com.carrijo.hexagonal.application.ports.in.FindCustomerByInputPort;
import com.carrijo.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.carrijo.hexagonal.application.ports.out.FindAddressByZipCode;
import com.carrijo.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByInputPort findCustomerByInputPort;
    private final FindAddressByZipCode findAddressByZipCode;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase (FindCustomerByInputPort findCustomerByInputPort,FindAddressByZipCode findAddressByZipCode,UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByInputPort = findCustomerByInputPort;
        this.findAddressByZipCode = findAddressByZipCode;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer,String zipCode) {
        findCustomerByInputPort.find(customer.getId());
        customer.setAdress(findAddressByZipCode.find(zipCode));

        updateCustomerOutputPort.update(customer);
    }
}
