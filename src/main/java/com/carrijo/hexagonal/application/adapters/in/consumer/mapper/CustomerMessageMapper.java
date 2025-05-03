package com.carrijo.hexagonal.application.adapters.in.consumer.mapper;

import com.carrijo.hexagonal.application.adapters.in.consumer.message.CustomerMessage;
import com.carrijo.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMessageMapper {
    @Mapping(target = "address", source = "address")
    Customer toCustomer(CustomerMessage customerMessage);
}
