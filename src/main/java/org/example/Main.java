package org.example;


import org.example.business.abstracts.BaseCustomerManager;
import org.example.business.concretes.StarbucksManager;
import org.example.utilities.Mernis;
import org.example.entities.Customer;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {


        Customer customer1=new Customer();
        customer1.setFirstName("Salih Remzi");
        customer1.setLastName("Güler");
        customer1.setNationalityId("13344077942");
        customer1.setDateOfBirth(LocalDate.of(2002,8,25));


        BaseCustomerManager baseCustomerManager=new StarbucksManager(new Mernis());
        baseCustomerManager.save(customer1);



    }
}