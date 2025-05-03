package com.carrijo.hexagonal.application.core.usecase;

import com.carrijo.hexagonal.application.core.domain.Customer;
import com.carrijo.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.carrijo.hexagonal.application.ports.out.FindAddressByZipCode;
import com.carrijo.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.carrijo.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCode addressByZipCode;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase (
            FindAddressByZipCode addressByZipCode,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort
    ) {
        this.addressByZipCode = addressByZipCode;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert (Customer customer,String zipCode) {
        var adrees = addressByZipCode.find(zipCode);
        customer.setAdress(adrees);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}

