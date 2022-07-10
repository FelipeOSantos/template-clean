package br.dev.fos.clean.templateclean.infrastructure.customer.repositoty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.dev.fos.clean.templateclean.domain.customer.model.Customer;
import br.dev.fos.clean.templateclean.infrastructure.customer.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerRepositoryUnitTest {

    @Mock
    private CustomerRepository customerRepository;

    private Customer customerMock;

    @BeforeEach
    public void setUp() {
        this.customerMock = new Customer("Felipe", 34);
    }

    @Test
    void saveCustomer() {

        Customer customer = new Customer("Felipe", 34);

        doReturn(this.customerMock).when(customerRepository).save(customer);
        
        Customer savedCustomer = customerRepository.save(customer);
        assertNotNull(savedCustomer);
        assertEquals(customer.getName(), savedCustomer.getName());
        assertEquals(customer.getAge(), savedCustomer.getAge());

    }
}
