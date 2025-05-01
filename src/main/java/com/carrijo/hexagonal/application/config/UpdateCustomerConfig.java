package com.carrijo.hexagonal.application.config;

import com.carrijo.hexagonal.application.adapters.out.FindAddressByZipCodeAdapter;
import com.carrijo.hexagonal.application.adapters.out.UpdateCustomerAdapter;
import com.carrijo.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.carrijo.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.carrijo.hexagonal.application.ports.in.FindCustomerByInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase (
            FindCustomerByInputPort findCustomerByInputPort,
            FindAddressByZipCodeAdapter findAddressByZipCode,
            UpdateCustomerAdapter updateCustomerOutputPort
    ) {
        return new UpdateCustomerUseCase(
                findCustomerByInputPort,
                findAddressByZipCode,
                updateCustomerOutputPort
        );
    }
}
