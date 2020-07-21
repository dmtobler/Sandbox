package com.danielletobler.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AccessingDataMongodbApplication includes a main() method that autowires an instance of CustomerRepository. Spring Data MongoDB dynamically creates a proxy and injects it there. We use the CustomerRepository through a few tests. First, it saves a handful of Customer objects, demonstrating the save() method and setting up some data to use. Next, it calls findAll() to fetch all Customer objects from the database. Then it calls findByFirstName() to fetch a single Customer by her first name. Finally, it calls findByLastName() to find all customers whose last name is Smith.
 */

@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepo customers;

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Delete any existing customers from the collection
        customers.deleteAll();

        // Save a couple of new customers
        customers.save(new Customer("Danielle", "Tobler"));
        customers.save(new Customer("Justin", "Tobler"));
        customers.save(new Customer("Winchester", "Doggo"));

        // Fetch all customers
        System.out.println("\n\tCustomers found with findAll():");
        System.out.println("\t-------------------------------");
        // Use an enhanced for loop to print each customer from the repo's info
        for (Customer customer : customers.findAll()) {
            System.out.println("\t" + customer);
        }
        System.out.println();

        // Fetch an individual customer
        System.out.println("\n\tCustomer found with findByFirstName('Danielle'):");
        System.out.println("\t--------------------------------");
        System.out.println("\t" + customers.findByFirstName("Danielle"));

        System.out.println("\n\tCustomers found with findByLastName('Tobler'):");
        System.out.println("\t--------------------------------");
        for (Customer customer : customers.findByLastName("Tobler")) {
            System.out.println("\t" +customer);
        }
    }
}