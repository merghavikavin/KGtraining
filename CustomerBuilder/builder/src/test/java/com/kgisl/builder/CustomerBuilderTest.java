package com.kgisl.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CustomerBuilderTest {

    @Test
    void testCustomerBuilder() {
        Customer customer = new CustomerBuilder()
                .withId(1)
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@example.com")
                .build();

        assertEquals(1, customer.getId());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("john.doe@example.com", customer.getEmail());
    }
}
