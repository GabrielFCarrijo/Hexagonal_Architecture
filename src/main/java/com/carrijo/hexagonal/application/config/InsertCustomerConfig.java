package com.carrijo.hexagonal.application.config;

import com.carrijo.hexagonal.application.adapters.out.FindAddressByZipCodeAdapter;
import com.carrijo.hexagonal.application.adapters.out.InsertCustomerAdapter;
import com.carrijo.hexagonal.application.adapters.out.SendCpfValidationAdapter;
import com.carrijo.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(
                findAddressByZipCodeAdapter,
                insertCustomerAdapter,
                sendCpfValidationAdapter
        );
    }
}