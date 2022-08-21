package com.vois.billing_account_service.voisbillingaccount.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "test")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String UserName;
    private String FullName;
    private String Password;
    private String PhoneNumber;
    private String Ban;

    public void setId(long id) {
        Id = id;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setBan(String ban) {
        Ban = ban;
    }

    public String getFullName() {
        return FullName;
    }

    public long getId() {
        return Id;
    }

    public String getBan() {
        return Ban;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getUserName() {
        return UserName;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "Id='" + Id + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", FullName='" + FullName + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Ban='" + Ban + '\'' +
                '}';
    }

}
