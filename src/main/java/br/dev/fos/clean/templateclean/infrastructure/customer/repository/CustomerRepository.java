package br.dev.fos.clean.templateclean.infrastructure.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.dev.fos.clean.templateclean.domain.customer.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>, CustomerRepositoryCustom {
    
}
