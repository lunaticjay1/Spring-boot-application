package com.customers.Springboot.application.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorDetails> details = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            ErrorDetails errors = new ErrorDetails();


            if (error.getDefaultMessage().contains("size")) {
                errors.setCode("CUS1008");
                errors.setDescription(error.getField() + " " + error.getDefaultMessage());

            } else {
                String[] errorMessage = error.getDefaultMessage().split("-");
                errors.setCode(errorMessage[1]);
                errors.setDescription(errorMessage[0]);
            }
            details.add(errors);
        }
        ErrorResponse error = new ErrorResponse("Fatal", "Customer System", details);
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public final ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
        List<ErrorDetails> details = new ArrayList<>();
        ErrorDetails errors = new ErrorDetails();
        errors.setCode(ex.getErrorCode());
        errors.setDescription(ex.getLocalizedMessage());
        details.add(errors);
        ErrorResponse error = new ErrorResponse("Fatal", "Customer System", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

}
