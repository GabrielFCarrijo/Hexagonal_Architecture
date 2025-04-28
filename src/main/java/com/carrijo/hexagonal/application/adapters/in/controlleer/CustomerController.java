package com.carrijo.hexagonal.application.adapters.in.controlleer;

import com.carrijo.hexagonal.application.adapters.in.controlleer.request.CustomerRequest;
import com.carrijo.hexagonal.application.adapters.in.controlleer.response.CustomerResponse;
import com.carrijo.hexagonal.application.adapters.out.repository.mapper.CustomerMapper;
import com.carrijo.hexagonal.application.core.domain.Customer;
import com.carrijo.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.carrijo.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.carrijo.hexagonal.application.ports.in.FindCustomerByInputPort;
import com.carrijo.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private FindCustomerByInputPort findCustomerByInputPort;
    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;
    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {

        insertCustomerInputPort.insert(
                 customerMapper.toCustomer(customerRequest),
                 customerRequest.getZipCode()
         );

         return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        return ResponseEntity.ok().body(
                customerMapper.toCustomerResponse(
                        findCustomerByInputPort.find(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerUseCase.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
