package org.example.utilities;

import org.example.entities.Customer;

import java.io.IOException;

public interface CustomerCheckService {

    boolean isValid(Customer customer) throws IOException;


}
