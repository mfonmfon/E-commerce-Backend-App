package com.semicolon.africa.hikestream.utils;

import com.semicolon.africa.hikestream.data.model.Customers;
import com.semicolon.africa.hikestream.dto.request.AddCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.SignupCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.UpdateCustomerRequest;
import com.semicolon.africa.hikestream.dto.response.AddCustomerResponse;
import com.semicolon.africa.hikestream.dto.response.SignupCustomerResponse;
import com.semicolon.africa.hikestream.dto.response.UpdateCustomerResponse;
import com.semicolon.africa.hikestream.exception.InvalidEmailInputException;

public class Mapper {

    public static void AddCustomerRequestMapper(SignupCustomerRequest request, Customers customers) {
        customers.setFirstName(request.getFirstName());
        customers.setLastName(request.getLastName());
        customers.setPhoneNumber(request.getPhoneNumber());
        customers.setEmail(request.getEmail());
        if(!customers.getEmail().contains("@") || !customers.getEmail().contains(".")){
            throw new InvalidEmailInputException("Email must contain @ and .");
        }
        customers.setHomeAddress(request.getHomeAddress());
        customers.setPassword(request.getPassword());
        customers.setConfirmPassword(request.getConfirmPassword());
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

    public static Customers addCustomerRequest(AddCustomerRequest request) {
        Customers customers = new Customers();
        customers.setFirstName(request.getFirstName());
        customers.setLastName(request.getLastName());
        customers.setEmail(request.getEmail());
        customers.setPhoneNumber(request.getPhoneNumber());
        customers.setHomeAddress(request.getHomeAddress());
        return customers;
    }

    public static AddCustomerResponse addCustomerResponse(Customers customers) {
        AddCustomerResponse response = new AddCustomerResponse();
        response.setFirstName(customers.getFirstName());
        response.setLastName(customers.getLastName());
        response.setEmail(customers.getEmail());
        response.setPhoneNumber(customers.getPhoneNumber());
        response.setHomeAddress(customers.getHomeAddress());
        response.setMessage("Successfully added a customer");
        return response;
    }
    public static void updateCustomerRequest(UpdateCustomerRequest request, Customers customers) {
        customers.setFirstName(request.getFirstName());
        customers.setLastName(request.getLastName());
        customers.setEmail(request.getEmail());
        if (!customers.getEmail().contains("@")|| !customers.getEmail().contains(".")){
            throw new InvalidEmailInputException("Please enter a valid email");
        }
        customers.setPhoneNumber(request.getPhoneNumber());
        customers.setHomeAddress(request.getHomeAddress());
    }

    public static UpdateCustomerResponse UpdateCustomerResponseMapping(Customers customers) {
        UpdateCustomerResponse response = new UpdateCustomerResponse();
        response.setFirstName(customers.getFirstName());
        response.setLastName(customers.getLastName());
        response.setEmail(customers.getEmail());
        response.setPhoneNumber(customers.getPhoneNumber());
        response.setHomeAddress(customers.getHomeAddress());
        return response;
    }

}
