package com.vois.billing_account_service.voisbillingaccount.services;


import com.vois.billing_account_service.voisbillingaccount.exceptions.UserExistsExceptions;
import com.vois.billing_account_service.voisbillingaccount.models.User;
import com.vois.billing_account_service.voisbillingaccount.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    /**
     * verifies if the ban is valid
     * @param ban
     * @throws UserExistsExceptions if ban is invalid
     */
    public List<User> getUsersByBan(String ban){

        return userRepository.findByBan(ban);
    }

    public Optional<User> getUser(String ban, long userId){
        Optional<User> user = userRepository.findByBanAndId(ban,userId);
        return user;
    }
    public User createUser(User user) throws UserExistsExceptions {

        if (userRepository.findById(user.getId()).isPresent()) {
            throw new UserExistsExceptions("Id", String.valueOf(user.getId()));
        }

        if (userRepository.findItemByUsername(user.getUserName()).isPresent()) {
            throw new UserExistsExceptions("UserName", user.getUserName());
        }

        if (userRepository.findItemByPhoneNumber(user.getPhoneNumber()).isPresent()) {
            throw new UserExistsExceptions("PhoneNumber", user.getPhoneNumber());
        }

        return userRepository.save(user);
    }

}
