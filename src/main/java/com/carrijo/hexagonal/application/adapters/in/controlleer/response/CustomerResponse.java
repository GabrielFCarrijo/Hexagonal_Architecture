package com.carrijo.hexagonal.application.adapters.in.controlleer.response;

import com.carrijo.hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;
    private AddressResponse address;
    private String cpf;
    private Boolean isValidCPF;
}
