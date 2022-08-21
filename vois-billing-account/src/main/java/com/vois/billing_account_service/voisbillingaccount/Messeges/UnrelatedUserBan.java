package com.vois.billing_account_service.voisbillingaccount.Messeges;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vois.billing_account_service.voisbillingaccount.exceptions.UnrelatedUserBanExceptions;


@ControllerAdvice
public class UnrelatedUserBan {

    @ResponseBody
    @ExceptionHandler(UnrelatedUserBanExceptions.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String unrelatedBanHandler(UnrelatedUserBanExceptions ex) {
        return ex.getMessage();
    }
}



