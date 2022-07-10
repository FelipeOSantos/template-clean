package br.dev.fos.clean.templateclean.infrastructure.customer.repositoty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import br.dev.fos.clean.templateclean.domain.customer.model.Customer;
import br.dev.fos.clean.templateclean.infrastructure.MongoDbContainerBaseTest;
import br.dev.fos.clean.templateclean.infrastructure.customer.repository.CustomerRepository;

@Testcontainers
@SpringBootTest(properties = { 
    "command.line.runner.enabled=false", 
    "application.runner.enabled=false" })
public class CustomerRepositoryIntegrationTest extends MongoDbContainerBaseTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void containerStartsAndPublicPortIsAvailable() {
        assertTrue(getMongoDBContainerInstance().isRunning());
    }

    @Test
    void saveCustomer() {
        Customer customer = new Customer();
        customer.setName("Sunil");
        Customer c1 = customerRepository.save(customer);
        assertNotNull(c1);
        assertEquals("Sunil", c1.getName());

    }
}
