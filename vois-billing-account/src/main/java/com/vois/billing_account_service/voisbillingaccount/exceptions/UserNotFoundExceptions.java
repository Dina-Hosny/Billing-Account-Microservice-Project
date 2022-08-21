package com.vois.billing_account_service.voisbillingaccount.exceptions;

public class UserNotFoundExceptions extends RuntimeException {
    public UserNotFoundExceptions(String id) {
        super("Could not find subscriber " + id);
    }

}
