package com.customers.Springboot.application.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    @NotNull(message = "Name cannot be null, it is a required field")
    @Size(min = 4, max = 32)
    public String customerName;

    @NotNull(message = "Address cannot be null, it is a required field")
    @Size(min = 4, max = 32)
    public String customerAddress;

    @NotNull(message = "Account type cannot be null")
    @Pattern(regexp = "CHECKING|SAVINGS",  flags = Pattern.Flag.CASE_INSENSITIVE,message = "Customer account type should be CHECKING or SAVINGS")

    private String customerAccountType;

    //test

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }


    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerAccountType() {
        return customerAccountType;
    }

    public void setCustomerAccountType(String customerAccountType) {
        this.customerAccountType = customerAccountType;
    }

    public Customer(Long customerId, String customerName, String customerAddress, String customerAccountType) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerAccountType = customerAccountType;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerAccountType='" + customerAccountType + '\'' +
                '}';
    }
}
