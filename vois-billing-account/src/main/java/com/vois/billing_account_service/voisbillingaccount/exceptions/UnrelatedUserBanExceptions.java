package com.vois.billing_account_service.voisbillingaccount.exceptions;

public class UnrelatedUserBanExceptions extends RuntimeException {
    public UnrelatedUserBanExceptions(String subscriberId, String ban) {
        super("Unrelated billing account number " + ban + " with subscriber with id " + subscriberId);
    }

    public UnrelatedUserBanExceptions(String id) {

        super(id);

    }
}
