package com.carrijo.hexagonal.application.adapters.out.client.mapper;

import com.carrijo.hexagonal.application.adapters.out.client.response.AddressResponse;
import com.carrijo.hexagonal.application.core.domain.Address;
import org.springframework.web.bind.annotation.Mapping;

public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
