package com.example.foodorder.service;

import com.example.foodorder.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer getCustomerById(Long customerId);
    Customer updateCustomer(Customer customer);

    void deleteCustomerById(Long customerId);


}
