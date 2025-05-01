package com.carrijo.hexagonal.application.config;

import com.carrijo.hexagonal.application.adapters.out.DeleteCustomerByIdAdapter;
import com.carrijo.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.carrijo.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.carrijo.hexagonal.application.ports.in.FindCustomerByInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByInputPort findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter)
    {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
