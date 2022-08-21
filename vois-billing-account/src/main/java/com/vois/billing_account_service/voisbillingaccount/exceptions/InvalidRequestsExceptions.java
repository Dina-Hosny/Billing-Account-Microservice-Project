package com.vois.billing_account_service.voisbillingaccount.exceptions;

public class InvalidRequestsExceptions extends RuntimeException {
    public InvalidRequestsExceptions(String error) {
        super("Invalid request, " + error);
    }

}
