package com.vois.billing_account_service.voisbillingaccount.controllers;


import com.vois.billing_account_service.voisbillingaccount.models.User;
import com.vois.billing_account_service.voisbillingaccount.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/vois/internship-program/v1")
public class BillingAccountControllers {
    @GetMapping("/hello")
    public String hello(){
        String hello = "Hello";
        return hello;
    }
    @Autowired
    private UserService userService;

    @GetMapping("/{ban}/subscribers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> GetUsersByBan(@PathVariable(value = "ban") String ban) {
        return userService.getUsersByBan(ban);
    }

    @GetMapping("/{ban}.{subscriber}")
    Optional<User> GetUser(@PathVariable(value = "ban") String ban, @PathVariable(value = "subscriber") long subscriberId) {

        return userService.getUser(ban, subscriberId);
    }

    @PostMapping("/subscriber")
    User CreateUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public String missingValue(NullPointerException ex) {
        return ex.getMessage();
    }

}
