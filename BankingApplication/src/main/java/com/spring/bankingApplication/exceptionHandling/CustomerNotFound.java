package com.spring.bankingApplication.exceptionHandling;

import com.spring.bankingApplication.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFound extends RuntimeException{
    public CustomerNotFound(String message){
            super(message);
    }
    public CustomerNotFound(){
    }
}
