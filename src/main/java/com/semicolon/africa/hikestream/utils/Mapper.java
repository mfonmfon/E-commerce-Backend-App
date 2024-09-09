package com.semicolon.africa.hikestream.utils;

import com.semicolon.africa.hikestream.data.model.Customers;
import com.semicolon.africa.hikestream.dto.request.SignupCustomerRequest;
import com.semicolon.africa.hikestream.dto.response.SignupCustomerResponse;

public class Mapper {

    public static void AddCustomerRequestMapper(SignupCustomerRequest request, Customers customers) {
        customers.setFirstName(request.getFirstName());
        customers.setLastName(request.getLastName());
        customers.setPhoneNumber(request.getPhoneNumber());
        customers.setEmail(request.getEmail());
//        if(!customers.getEmail().contains("@") || !customers.getEmail().contains(".")){
//            throw new InvalidEmailInputException("Email must contain @ and .");
//        }
        customers.setHomeAddress(request.getHomeAddress());
        customers.setPassword(request.getPassword());
    }


    public static SignupCustomerResponse AddCustomerResponseMapper(Customers customers) {
        SignupCustomerResponse response = new SignupCustomerResponse();
        response.setFirstName(customers.getFirstName());
        response.setLastName(customers.getLastName());
        response.setPhoneNumber(customers.getPhoneNumber());
        response.setEmail(customers.getEmail());
        response.setHomeAddress(customers.getHomeAddress());
        response.setPassword(customers.getPassword());
        response.setMessage("Signup successfully");
        return response;
    }
}
