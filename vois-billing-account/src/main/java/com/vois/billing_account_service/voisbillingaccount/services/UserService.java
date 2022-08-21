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
//        verifyBan(user.getBan());
//        verifyUsername(user.getUserName());
//        verifyPhone(user.getPhoneNumber());

        if (UserRepository.findById(user.getId()).isPresent()) {
            throw new UserExistsExceptions("User id", String.valueOf(user.getId()));
        }

        if (UserRepository.findItemByUsername(user.getUserName()).isPresent()) {
            throw new UserExistsExceptions("username", user.getUserName());
        }

        if (userRepository.findItemByPhoneNumber(user.getPhoneNumber()).isPresent()) {
            throw new UserExistsExceptions("email", user.getPhoneNumber());
        }

        return userRepository.save(user);
    }

}
