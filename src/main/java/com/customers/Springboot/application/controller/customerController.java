package com.customers.Springboot.application.controller;


import com.customers.Springboot.application.entity.Customer;
import com.customers.Springboot.application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

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
    public Customer getCustomerById(@PathVariable("id") Long customerId){
        return customerService.getCustomerById(customerId);
    }

    @DeleteMapping("/getCustomers/{id}")
    public String deleteCustomerById(@PathVariable("id") Long customerId){
        customerService.deleteCustomerById(customerId);
        return "Customer deleted succesfully";
    }

    @PutMapping("/getCustomers/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long customerId, @RequestBody Customer customer) {
        Customer existingCustomer = customerService.getCustomerById(customerId);
        if (existingCustomer != null){
            return new ResponseEntity<Object>(customerService.updateCustomer(customerId, customer), HttpStatus.OK);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with ID " + customerId);
    }

    @GetMapping("/getCustomers/name/{name}")
    public Customer getCustomerByName(@PathVariable("name") String customerName){
        return customerService.getCustomerByName(customerName);
    }
}
