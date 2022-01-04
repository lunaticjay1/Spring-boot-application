package com.customers.Springboot.application.service;


import com.customers.Springboot.application.entity.Customer;
import com.customers.Springboot.application.error.CustomerNotFoundException;
import com.customers.Springboot.application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {



    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) throws CustomerNotFoundException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()){
            throw new CustomerNotFoundException("Customer Not Available");
        }
        return customer.get();
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer cst = customerRepository.findById(customerId).get();

        if (Objects.nonNull(customer.getCustomerName()) && (customer.getCustomerName() != "")){
            cst.setCustomerName(customer.getCustomerName());
        }
        if (Objects.nonNull(customer.getCustomerAddress()) && (customer.getCustomerAddress() != "")){
            cst.setCustomerAddress(customer.getCustomerAddress());
        }
        if (Objects.nonNull(customer.getCustomerAccountType()) && (customer.getCustomerAccountType() != "")){
            cst.setCustomerAccountType(customer.getCustomerAccountType());
        }

        return customerRepository.save(cst);
    }

    @Override
    public Customer getCustomerByName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }


}
