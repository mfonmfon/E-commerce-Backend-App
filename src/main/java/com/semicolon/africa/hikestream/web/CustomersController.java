package com.semicolon.africa.hikestream.web;

import com.semicolon.africa.hikestream.dto.request.LoginCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.SignupCustomerRequest;
import com.semicolon.africa.hikestream.dto.response.ApiResponse;
import com.semicolon.africa.hikestream.dto.response.LoginCustomerResponse;
import com.semicolon.africa.hikestream.dto.response.SignupCustomerResponse;
import com.semicolon.africa.hikestream.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupCustomerRequest request) {
        try {
            SignupCustomerResponse response = customerService.signUp(request);
            return new ResponseEntity<>(new ApiResponse(true, response),
                    HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginCustomerRequest request){
        try {
            LoginCustomerResponse response = customerService.login(request);
            return new ResponseEntity<>(new ApiResponse(true, response),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
}