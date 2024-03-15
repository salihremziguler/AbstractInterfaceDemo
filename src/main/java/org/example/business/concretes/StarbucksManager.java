package org.example.business.concretes;

import org.example.business.abstracts.BaseCustomerManager;
import org.example.utilities.CustomerCheckService;
import org.example.entities.Customer;

import java.io.IOException;

public class StarbucksManager implements BaseCustomerManager {

   CustomerCheckService customerCheckService;
   public StarbucksManager(CustomerCheckService customerCheckService)
   {
       this.customerCheckService=customerCheckService;
   }
    @Override
    public void save(Customer customer) throws IOException {

       if(customerCheckService.isValid(customer))
       {
           System.out.println("Kullanıcı Doğrulandı");
           System.out.println("Saved to db "+customer.getFirstName());
       }
       else
       {
           System.out.println("Geçersiz Kullanıcı!!!");
       }


    }
}
