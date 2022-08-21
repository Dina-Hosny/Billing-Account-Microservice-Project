package com.vois.billing_account_service.voisbillingaccount.Messeges;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vois.billing_account_service.voisbillingaccount.exceptions.UserNotFoundExceptions;


@ControllerAdvice
public class UserNotFound {

    @ResponseBody
    @ExceptionHandler(UserNotFoundExceptions.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String subscriberNotFoundHandler(UserNotFoundExceptions ex) {
        return ex.getMessage();
    }
}

