package com.carrijo.hexagonal.application.core.usecase;

import com.carrijo.hexagonal.application.ports.in.FindCustomerByInputPort;
import com.carrijo.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase {

    private final FindCustomerByInputPort findCustomerByInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase (FindCustomerByInputPort findCustomerByInputPort,DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByInputPort = findCustomerByInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    public void delete(String id) {
        findCustomerByInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
