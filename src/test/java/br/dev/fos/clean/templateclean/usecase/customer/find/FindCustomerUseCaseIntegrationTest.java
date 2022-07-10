package br.dev.fos.clean.templateclean.usecase.customer.find;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import br.dev.fos.clean.templateclean.infrastructure.MongoDbContainerBaseTest;
import br.dev.fos.clean.templateclean.usecase.customer.find.dto.InputFindCustomerDTO;

@Testcontainers
@SpringBootTest(properties = { 
    "command.line.runner.enabled=false", 
    "application.runner.enabled=false" })
public class FindCustomerUseCaseIntegrationTest extends MongoDbContainerBaseTest {

    @Autowired
    private FindCustomerUseCase findCustomerUseCase;

    @Test
    void containerStartsAndPublicPortIsAvailable() {
        assertTrue(getMongoDBContainerInstance().isRunning());
    }

    @Test
    void saveCustomer() {

        InputFindCustomerDTO inputFindCustomerDTO = new InputFindCustomerDTO();
        inputFindCustomerDTO.setId("123");


        assertThrows(NoSuchElementException.class, () -> {
            findCustomerUseCase.execute(inputFindCustomerDTO);
        });

    }
}
