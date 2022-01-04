package com.customers.Springboot.application.repository;

import com.customers.Springboot.application.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //@Query(value = "SELECT * WHERE CUSTOMER_NAME = customerName", nativeQuery = true)
    public Customer findByCustomerName(String customerName);
}
