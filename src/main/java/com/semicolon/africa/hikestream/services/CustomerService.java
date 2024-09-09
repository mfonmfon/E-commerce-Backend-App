package com.semicolon.africa.hikestream.services;

import com.semicolon.africa.hikestream.data.model.Customers;
import com.semicolon.africa.hikestream.dto.request.AddCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.LoginCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.UpdateCustomerRequest;
import com.semicolon.africa.hikestream.dto.response.*;
import com.semicolon.africa.hikestream.dto.request.SignupCustomerRequest;

import java.util.List;

public interface CustomerService {
    SignupCustomerResponse signUp(SignupCustomerRequest request);

    LoginCustomerResponse login(LoginCustomerRequest loginRequest);

    LogoutCustomerResponse logout();

    AddCustomerResponse addCustomer(AddCustomerRequest request);

    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request);

    DeleteCustomerResponse deleteCustomerFirstName(String firstName);

    List<Customers> findAllCustomers();

    List<Customers> findCustomerByFirstName(String firstName);

    List<Customers> findCustomerByLastName(String lastName);

    List<Customers> findCustomerByPhoneNumber(String phoneNumber);


}
