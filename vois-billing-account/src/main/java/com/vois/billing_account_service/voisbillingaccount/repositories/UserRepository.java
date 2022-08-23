package com.vois.billing_account_service.voisbillingaccount.repositories;

import com.vois.billing_account_service.voisbillingaccount.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    /**
     * searches for all subscribers with a certain billing account number
     * @param Ban billing account number
     * @return a list of subscribers
     */
    @Query("select u from User u where u.Ban = ?1")
    List<User> findByBan(String Ban);


    @Query("select u from User u where u.UserName = ?1")
    Optional<User> findItemByUsername(String UserName);

    @Query("select u from User u where u.PhoneNumber = ?1")
    Optional<User> findItemByPhoneNumber(String PhoneNumber);

    @Query("select u from User u where u.Ban = :Ban and u.Id = :Id")
    Optional<User> findByBanAndId(@Param("Ban") String Ban, @Param("Id") long Id);

    @Query("select u from User u where u.Id = ?1")
     Optional<User> findById(long s);

}
