package com.carrijo.hexagonal.application.adapters.in.consumer;

import com.carrijo.hexagonal.application.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.carrijo.hexagonal.application.adapters.in.consumer.message.CustomerMessage;
import com.carrijo.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;
    @Autowired
    private CustomerMessageMapper customerMessageMapper;
    @KafkaListener(topics = "tp-cpf-validated", groupId = "carrijo")
    public void receive(CustomerMessage customerMessage) {
        updateCustomerInputPort.update(customerMessageMapper.toCustomer(customerMessage), customerMessage.getZipCode());
    }
}
