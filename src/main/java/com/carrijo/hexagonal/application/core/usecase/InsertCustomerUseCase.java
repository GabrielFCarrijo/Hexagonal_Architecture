package com.carrijo.hexagonal.application.core.usecase;

import com.carrijo.hexagonal.application.core.domain.Customer;
import com.carrijo.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.carrijo.hexagonal.application.ports.out.FindAddressByZipCode;
import com.carrijo.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCode addressByZipCode;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase (
            FindAddressByZipCode addressByZipCode,
            InsertCustomerOutputPort insertCustomerOutputPort
    ) {
        this.addressByZipCode = addressByZipCode;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert (Customer customer,String zipCode) {
        var adrees = addressByZipCode.find(zipCode);
        customer.setAdress(adrees);

        insertCustomerOutputPort.insert(customer);
    }
}

