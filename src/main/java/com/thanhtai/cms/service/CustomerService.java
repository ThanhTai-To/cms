package com.thanhtai.cms.service;

import com.thanhtai.cms.dao.CustomerDAO;
import com.thanhtai.cms.exception.CustomerNotFoundException;
import com.thanhtai.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    //private int customerIdCount = 1;
    //private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer) {
        /*customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;*/
        return customerDAO.save(customer);
        //return customer;
    }

    public List<Customer> getCustomers() {
        return customerDAO.findAll();
        //return customerList;
    }

    public Customer getCustomer(int id) {
//        return customerList
//                .stream()
//                .filter(customer ->
//                    customer.getCustomerId() == id
//                )
//                .findFirst()
//                .get();

        Optional<Customer> optionalCustomer = customerDAO.findById(id);

        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not available");
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int id, Customer customer) {
//        customerList.stream()
//                .forEach(c -> {
//                    if(c.getCustomerId() == id) {
//                        c.setCustomerFirstName(customer.getCustomerFirstName());
//                        c.setCustomerLastName(customer.getCustomerLastName());
//                        c.setCustomerEmail(customer.getCustomerEmail());
//                    }
//                });
//
//        return customerList.stream()
//                            .filter(c -> c.getCustomerId() == id )
//                            .findFirst()
//                            .get();
        customer.setCustomerId(id);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId) {
//        customerList.stream()
//                .forEach(c -> {
//                    if (c.getCustomerId() == customerId) {
//                        customerList.remove(c);
//                    }
//                });
        customerDAO.deleteById(customerId);
    }


}
