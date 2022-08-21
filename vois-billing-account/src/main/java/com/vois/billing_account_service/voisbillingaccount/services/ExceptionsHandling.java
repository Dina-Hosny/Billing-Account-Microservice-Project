package com.vois.billing_account_service.voisbillingaccount.services;

import com.sun.istack.NotNull;
import com.vois.billing_account_service.voisbillingaccount.exceptions.InvalidRequestsExceptions;
import com.vois.billing_account_service.voisbillingaccount.exceptions.UnrelatedUserBanExceptions;
import com.vois.billing_account_service.voisbillingaccount.exceptions.UserExistsExceptions;
import com.vois.billing_account_service.voisbillingaccount.exceptions.UserNotFoundExceptions;
import com.vois.billing_account_service.voisbillingaccount.models.User;
import com.vois.billing_account_service.voisbillingaccount.repositories.UserRepository;

import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExceptionsHandling {
    @Autowired
    private UserRepository subscriberRepository;

    private Pattern startWithAlphaPattern;

    private Pattern alphaNumericPattern;

    private Pattern emailPattern;

    public ExceptionsHandling() {
        String startWithAlphaRe = "^[A-Za-z].*";
        startWithAlphaPattern = Pattern.compile(startWithAlphaRe);

        String alphaNumericRe = "\\w*$";
        alphaNumericPattern = Pattern.compile(alphaNumericRe);
    }

    /**
     * verifies if the ban is valid
     * @param ban
     * @throws InvalidRequestsExceptions if ban is invalid
     */
    private void verifyBan(String ban) throws InvalidRequestsExceptions{
        if (!NumberUtils.isDigits(ban)) throw new InvalidRequestsExceptions("Billing account number can only contain numbers");
        if (ban.length() != 9) throw new InvalidRequestsExceptions("Billing account number needs to be 9 digits long");
    }

    /**
     * checks if username is valid
     * @param username
     * @throws InvalidRequestsExceptions if invalid username
     */
    private void verifyUsername(String username) throws InvalidRequestsExceptions {

        if (!startWithAlphaPattern.matcher(username).matches())
            throw new InvalidRequestsExceptions("Username has to start with an alphabet");
        if (!alphaNumericPattern.matcher(username).matches())
            throw new InvalidRequestsExceptions("Username has to only contain an alphanumeric characters");
        if (username.length() < 3 || username.length() > 15)
            throw new InvalidRequestsExceptions("Username has to be between 3 and 15 characters long");

    }

    /**
     * checks if phone number is valid
     * @param phone
     * @throws InvalidRequestsExceptions if invalid phone number
     */
    private void verifyPhone(String phone) throws InvalidRequestsExceptions {
        if (!NumberUtils.isDigits(phone)) throw new InvalidRequestsExceptions("phone number can only contain numbers");
        if (phone.length() != 11) throw new InvalidRequestsExceptions("phone number needs to be 11 digits long");
    }

    /**
     * gets all subscribers subscribed to a given billing account
     *
     * @param ban
     * @return list of subscribers
     */
    public String getBan(String ban){
        verifyBan(ban);

        return ban;
    }

    /**
     * gets a subscriber with given subscriber id and ban
     * @param ban billing account number
     * @param Id
     * @return subscriber with given id and ban
     * @throws UserNotFoundExceptions if no subscriber exists
     * @throws UnrelatedUserBanExceptions if wrong billing account number
     */
    public UserRepository findByBanAndId(String ban, String Id) throws UserNotFoundExceptions, UnrelatedUserBanExceptions{
        verifyBan(ban);

        User user = UserRepository.findById(Long.parseLong(Id)).orElseThrow(
                ()-> new UnrelatedUserBanExceptions(Id)
        );

        if (!user.getBan().equalsIgnoreCase(ban)) throw new UnrelatedUserBanExceptions(Id, ban);

        return (UserRepository) user;
    }

    /**
     * creates new subscriber
     * @param user
     * @return the created subscriber
     * @throws UserExistsExceptions if subscriber already exists
     */
    public User createSubscriber(User user) throws UserExistsExceptions {
        verifyBan(user.getBan());
        verifyUsername(user.getUserName());
        verifyPhone(user.getPhoneNumber());

        if (UserRepository.findById(user.getId()).isPresent());
            throw new UserExistsExceptions("subscriber id", user.getId());

    }
}

