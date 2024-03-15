package org.example.business.abstracts;

import org.example.business.abstracts.CustomerService;
import org.example.entities.Customer;

import java.io.IOException;

public interface BaseCustomerManager {

    public void save(Customer customer) throws IOException;
}
