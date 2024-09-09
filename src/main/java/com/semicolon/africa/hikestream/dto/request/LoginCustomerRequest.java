package com.semicolon.africa.hikestream.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.StandardException;

@Getter
@Setter
public class LoginCustomerRequest {
    private String email;
    private String password;
}
