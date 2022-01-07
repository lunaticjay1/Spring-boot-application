package com.customers.Springboot.application.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException
{
    String errorCode;
    public CustomerNotFoundException(String exception, String errorCode) {
        super(exception);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }



}

