package br.dev.fos.clean.templateclean.usecase.customer.create;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.dev.fos.clean.templateclean.domain.customer.model.Customer;
import br.dev.fos.clean.templateclean.infrastructure.customer.repository.CustomerRepository;
import br.dev.fos.clean.templateclean.usecase.customer.create.dto.InputCreateCustomerDto;

@ExtendWith(MockitoExtension.class)
public class CreateCustomerUseCaseUnitTest {

    @InjectMocks
    private CreateCustomerUseCase createCustomerUseCase;

    @Mock
    private CustomerRepository customerRepository;

    private Customer customerMock;

    @BeforeEach
    public void setUp() {
        this.customerMock = new Customer("Felipe", 34);
    }

    @Test
    void saveCustomer() {

        InputCreateCustomerDto inputCreateCustomerDto = new InputCreateCustomerDto();
        inputCreateCustomerDto.setName("Felipe");
        
        Customer customer = new Customer("Felipe", 34);

        doReturn(customerMock).when(customerRepository).save(customer);

        var outputCreateCustomerDto = createCustomerUseCase.execute(inputCreateCustomerDto);

        assertNotNull(outputCreateCustomerDto);
        assertEquals(customerMock.getName(), outputCreateCustomerDto.getName());

    }

    @Test
    void saveCustomerNUllName() {

        InputCreateCustomerDto inputCreateCustomerDto = new InputCreateCustomerDto();
        inputCreateCustomerDto.setName("");
        
        Customer customer = new Customer("Felipe", 34);

        doReturn(customerMock).when(customerRepository).save(customer);

        var outputCreateCustomerDto = createCustomerUseCase.execute(inputCreateCustomerDto);

        assertNotNull(outputCreateCustomerDto);
        assertEquals(customerMock.getName(), outputCreateCustomerDto.getName());

    }
}
