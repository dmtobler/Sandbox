package com.danielletobler.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB uses the MongoTemplate to execute the queries behind your find* methods. You
 * can use the template yourself for more complex queries, but this guide does not cover that. (see
 * the @see <a href="https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#reference">Spring Data MongoDB Reference Guide</a>)
 **/


public interface CustomerRepo extends MongoRepository<Customer, String> {

    // NOTE: We do not have to write the actual query for these. It is part of Spring Data magic. Literally magic going on here, folks.

    // Will return Customer objects from the Repo with matching firstName argument passed
    public Customer findByFirstName(String firstName);

    // Will return a list of Customer objects from Repo that match the lastName argument passed
    public List<Customer> findByLastName(String lastName);

}