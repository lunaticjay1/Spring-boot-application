package com.customers.Springboot.application.service;


import com.customers.Springboot.application.entity.Customer;
import com.customers.Springboot.application.exception.CustomerNotFoundException;
import com.customers.Springboot.application.repository.CustomerRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Customer getCustomerById(Long customerId){
        Customer cst = customerRepository.findById(customerId).orElse(null);
        if (cst == null){
            throw new CustomerNotFoundException("Customer not found with ID " + customerId, "CUS1001");
        }
        return cst;
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        Customer cst = customerRepository.findById(customerId).orElse(null);
        if (cst == null){
            throw new CustomerNotFoundException("Customer not found with ID " + customerId, "CUS1002");
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {

        Customer cst = customerRepository.findById(customerId).orElse(null);
        if (cst == null){
            throw new CustomerNotFoundException("Customer not found with ID " + customerId, "CUS1003");
        }
        if (Objects.nonNull(customer.getCustomerName()) && (!StringUtils.isBlank(customer.getCustomerName()))){
            cst.setCustomerName(customer.getCustomerName());
        }
        if (Objects.nonNull(customer.getCustomerAddress()) && (!StringUtils.isBlank(customer.getCustomerAddress()))){
            cst.setCustomerAddress(customer.getCustomerAddress());
        }
        if (Objects.nonNull(customer.getCustomerAccountType()) && (!StringUtils.isBlank(customer.getCustomerAccountType()))){
            cst.setCustomerAccountType(customer.getCustomerAccountType());
        }

        return customerRepository.save(cst);
    }

    @Override
    public Customer getCustomerByName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }


}
