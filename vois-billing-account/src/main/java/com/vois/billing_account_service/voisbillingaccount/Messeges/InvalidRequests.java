package com.vois.billing_account_service.voisbillingaccount.Messeges;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vois.billing_account_service.voisbillingaccount.exceptions.InvalidRequestsExceptions;



@ControllerAdvice
public class InvalidRequests {

    @ResponseBody
    @ExceptionHandler(InvalidRequestsExceptions.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String invalidRequestHandler(InvalidRequestsExceptions ex) {
        return ex.getMessage();
    }
}








