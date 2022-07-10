package br.dev.fos.clean.templateclean.infrastructure.customer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import br.dev.fos.clean.templateclean.domain.customer.model.Customer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void updateAge(String name, Integer age) {

        log.debug(">> updateAge()");

        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("age", age);

        mongoTemplate.updateFirst(query, update, Customer.class);

        log.debug("<< updateAge()");

    }
    
}
