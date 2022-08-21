package com.vois.billing_account_service.voisbillingaccount.Messeges;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vois.billing_account_service.voisbillingaccount.exceptions.UserExistsExceptions;


@ControllerAdvice
public class UserExist {

    @ResponseBody
    @ExceptionHandler(UserExistsExceptions.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String subscriberExistsHandler(UserExistsExceptions ex) {
        return ex.getMessage();
    }
}
