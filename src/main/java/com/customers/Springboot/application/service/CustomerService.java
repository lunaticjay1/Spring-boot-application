package com.customers.Springboot.application.service;

import com.customers.Springboot.application.entity.Customer;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);

    public List<Customer> getCustomers();


    public Customer getCustomerById(Long customerId);

    public void deleteCustomerById(Long customerId);

    public Customer updateCustomer(Long customerId, Customer customer);

    public Customer getCustomerByName(String customerName);
}
