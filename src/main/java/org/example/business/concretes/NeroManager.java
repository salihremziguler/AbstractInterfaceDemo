package org.example.business.concretes;

import org.example.business.abstracts.BaseCustomerManager;
import org.example.entities.Customer;

public class NeroManager implements BaseCustomerManager {
    @Override
    public void save(Customer customer) {
        System.out.println("Saved to db "+customer.getFirstName());
    }

}
