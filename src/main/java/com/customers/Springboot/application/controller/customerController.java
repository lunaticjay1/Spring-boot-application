package com.customers.Springboot.application.controller;


import com.customers.Springboot.application.entity.Customer;
import com.customers.Springboot.application.error.CustomerNotFoundException;
import com.customers.Springboot.application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class customerController {


    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public Customer saveCustomer(@Valid @RequestBody Customer customer){
        return customerService.saveCustomer(customer);

    }
    @GetMapping("/getCustomers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/getCustomers/{id}")
    public Customer getCustomerById(@PathVariable("id") Long customerId) throws CustomerNotFoundException {
        return customerService.getCustomerById(customerId);
    }

    @DeleteMapping("/getCustomers/{id}")
    public String deleteCustomerById(@PathVariable("id") Long customerId){
        customerService.deleteCustomerById(customerId);
        return "Customer deleted succesfully";
    }

    @PutMapping("/getCustomers/{id}")
    public Customer updateCustomer(@PathVariable("id") Long customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);
    }

    @GetMapping("/getCustomers/name/{name}")
    public Customer getCustomerByName(@PathVariable("name") String customerName){
        return customerService.getCustomerByName(customerName);
    }
}
