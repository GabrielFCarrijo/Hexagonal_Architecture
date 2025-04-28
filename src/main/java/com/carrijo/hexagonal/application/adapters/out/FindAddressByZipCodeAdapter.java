package com.carrijo.hexagonal.application.adapters.out;

import com.carrijo.hexagonal.application.adapters.out.client.FindAddressByZipCodeClient;
import com.carrijo.hexagonal.application.adapters.out.client.mapper.AddressResponseMapper;
import com.carrijo.hexagonal.application.core.domain.Address;
import com.carrijo.hexagonal.application.ports.out.FindAddressByZipCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCode {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find (String zipCode) {
        var adressResponde = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(adressResponde);
    }
}
