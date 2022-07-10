package br.dev.fos.clean.templateclean.usecase.customer.find;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.dev.fos.clean.templateclean.domain.customer.model.Customer;
import br.dev.fos.clean.templateclean.infrastructure.customer.repository.CustomerRepository;
import br.dev.fos.clean.templateclean.usecase.customer.find.dto.InputFindCustomerDTO;

@ExtendWith(MockitoExtension.class)
public class FindCustomerUseCaseUnitTest {

    @InjectMocks
    private FindCustomerUseCase findCustomerUseCase;

    @Mock
    private CustomerRepository customerRepository;

    private Optional<Customer> optionalCustomerMock;

    @BeforeEach
    public void setUp() {
        this.optionalCustomerMock = Optional.of(new Customer("Felipe", 34));
    }

    @Test
    void findCustomer() {

        InputFindCustomerDTO inputFindCustomerDTO = new InputFindCustomerDTO();
        inputFindCustomerDTO.setId("123");

        doReturn(this.optionalCustomerMock).when(customerRepository).findById(inputFindCustomerDTO.getId());

        var outputFindCustomerDTO = findCustomerUseCase.execute(inputFindCustomerDTO);

        assertNotNull(outputFindCustomerDTO);
        assertEquals(optionalCustomerMock.get().getName(), outputFindCustomerDTO.getName());

    }


}
