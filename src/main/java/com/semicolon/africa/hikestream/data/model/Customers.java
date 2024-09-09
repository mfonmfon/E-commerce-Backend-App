package com.semicolon.africa.hikestream.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Customers {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private String homeAddress;
    private String phoneNumber;
    private boolean isLoggedIn;
    private BillingInformation billingInformation;
    @DBRef
    List<ShoppingCart> shoppingCart = new ArrayList<>();
}
