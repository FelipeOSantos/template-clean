package br.dev.fos.clean.templateclean.usecase.customer.find.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.dev.fos.clean.templateclean.domain.customer.model.Customer;
import br.dev.fos.clean.templateclean.usecase.customer.find.dto.OutputFindCustomerDTO;
import br.dev.fos.clean.templateclean.usecase.customer.mapper.CustomerMapper;

public class CustomerMapperUnitTest {
    private CustomerMapper mapper = CustomerMapper.INSTANCE;

    @Test
    public void shouldMapCustomerToDto() {

        Customer customer = new Customer("Felipe", 34);

        OutputFindCustomerDTO outputFindCustomerDTO = mapper.customerToOutputFindCustomerDTO(customer);

        assertNotNull(outputFindCustomerDTO);
        assertEquals(customer.getName(), outputFindCustomerDTO.getName());
        assertEquals(customer.getAge(), outputFindCustomerDTO.getAge());
    }
}
