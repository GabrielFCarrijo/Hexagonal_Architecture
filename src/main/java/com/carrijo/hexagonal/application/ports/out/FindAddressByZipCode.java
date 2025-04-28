package com.carrijo.hexagonal.application.ports.out;

import com.carrijo.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCode {

    Address find(String zipCode);
}
