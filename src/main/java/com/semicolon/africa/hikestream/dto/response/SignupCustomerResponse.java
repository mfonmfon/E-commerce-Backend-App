package com.semicolon.africa.hikestream.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupCustomerResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String password;
    private String confirmPassword;
    private String message;
}
