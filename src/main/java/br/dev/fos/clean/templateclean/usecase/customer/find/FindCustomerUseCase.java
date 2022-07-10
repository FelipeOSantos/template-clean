package br.dev.fos.clean.templateclean.usecase.customer.find;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.fos.clean.templateclean.domain.customer.model.Customer;
import br.dev.fos.clean.templateclean.infrastructure.customer.repository.CustomerRepository;
import br.dev.fos.clean.templateclean.usecase.customer.find.dto.InputFindCustomerDTO;
import br.dev.fos.clean.templateclean.usecase.customer.find.dto.OutputFindCustomerDTO;
import br.dev.fos.clean.templateclean.usecase.customer.mapper.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
/*
 * // TODO criar interface para usecases somente para definir um contrato 
 */
@Slf4j
@Service
public class FindCustomerUseCase {
    
    @Autowired
    private CustomerRepository customerRepository;

    public OutputFindCustomerDTO execute(InputFindCustomerDTO inputFindCustomerDTO) {

        log.info(">> execute");

        Optional<Customer> customer = customerRepository.findById(inputFindCustomerDTO.getId());

        log.info("<< execute");
        
        return CustomerMapper.INSTANCE.customerToOutputFindCustomerDTO(customer.orElseThrow());
    }

}
