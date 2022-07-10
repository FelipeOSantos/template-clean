package br.dev.fos.clean.templateclean.infrastructure.customer.persistence;

import org.springframework.stereotype.Component;

import br.dev.fos.clean.templateclean.infrastructure.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * // TODO criar uma camada de persistence que acessa a camada de repository e implenta um adapter Out
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class CustomerPersistence {
    
    private final CustomerRepository customerRepository;

    public void test() {

        log.debug(">> test()");

        this.customerRepository.updateAge("Felipe", 34);

        log.debug("<< test()");
    }

}
