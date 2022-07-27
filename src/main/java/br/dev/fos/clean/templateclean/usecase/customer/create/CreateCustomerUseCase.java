package br.dev.fos.clean.templateclean.usecase.customer.create;

import br.dev.fos.clean.templateclean.domain.customer.model.Customer;
import br.dev.fos.clean.templateclean.infrastructure.customer.repository.CustomerRepository;
import br.dev.fos.clean.templateclean.usecase.customer.create.dto.InputCreateCustomerDto;
import br.dev.fos.clean.templateclean.usecase.customer.create.dto.OutputCreateCustomerDto;
import br.dev.fos.clean.templateclean.usecase.customer.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreateCustomerUseCase {
    
    private final CustomerRepository customerRepository;

    public OutputCreateCustomerDto execute(InputCreateCustomerDto inputCreateCustomerDto) {

        log.debug(">> execute()");

        Customer createdCustomer = customerRepository.save(CustomerMapper.INSTANCE.inputCreateCustomerDtoToCustomer(inputCreateCustomerDto));

        log.debug("<< execute()");

        return CustomerMapper.INSTANCE.customerToOutputCreateCustomerDto(createdCustomer);
    }
}
