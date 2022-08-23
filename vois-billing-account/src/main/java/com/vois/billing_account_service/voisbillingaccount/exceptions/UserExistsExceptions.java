package com.vois.billing_account_service.voisbillingaccount.exceptions;


public class UserExistsExceptions extends RuntimeException{


    public UserExistsExceptions(String database_value, String input_value ) {
        super(String.format("Already Found id duplicate value:%s,%s", database_value, input_value));

    }


}
