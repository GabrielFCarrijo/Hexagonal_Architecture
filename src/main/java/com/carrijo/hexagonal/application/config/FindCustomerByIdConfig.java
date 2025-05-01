package com.carrijo.hexagonal.application.config;

import com.carrijo.hexagonal.application.adapters.out.FindAddressByZipCodeAdapter;
import com.carrijo.hexagonal.application.adapters.out.FindCustomerByIdAdapter;
import com.carrijo.hexagonal.application.adapters.out.InsertCustomerAdapter;
import com.carrijo.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.carrijo.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
