package com.semicolon.africa.hikestream.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCustomerResponse {
    private String email;
    private String password;
    private String message;
}
