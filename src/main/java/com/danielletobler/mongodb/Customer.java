package com.danielletobler.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MongoDB stores data in collections. Spring Data MongoDB maps the Customer class into a
 * collection called customer. If you want to change the name of the collection, you can use
 * Spring Data MongoDB’s @Document annotation on the class.
 **/

// Note: I have changed the MongoDB collection name to "customers" by adding an @Document annotation with a value of this name. By default, the collection name would the class name "customer"

@Document(value = "customers")
public class Customer {
//    ATTRIBUTES

    // Annotated with @Id for MongoDB mapping purposes
    @Id
    public String id;

    // No annotations required for firstName or lastName - it is assumed that they are mapped to fields that share the same name as the properties themselves.
    public String firstName;

    public String lastName;

//    CONSTRUCTORS

    // Empty constructor to allocate memory
    public Customer() {}

    // Constructor when firstName and lastName present
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    METHODS

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}