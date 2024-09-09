package com.semicolon.africa.hikestream.services;

import com.semicolon.africa.hikestream.data.model.Customers;
import com.semicolon.africa.hikestream.dto.request.*;
import com.semicolon.africa.hikestream.dto.response.*;

import java.util.List;

public interface CustomerService {
    SignupCustomerResponse signUp(SignupCustomerRequest request);

    LoginCustomerResponse login(LoginCustomerRequest loginRequest);

    LogoutCustomerResponse logout(String email);

    AddCustomerResponse addCustomer(AddCustomerRequest request);

    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request);

    PurchaseResponse purchase(PurchaseRequest purchaseRequest);

    DeleteCustomerResponse deleteCustomerFirstName(String firstName);

    List<Customers> findAllCustomers();

    List<Customers> findCustomerByFirstName(String firstName);

    List<Customers> findCustomerByLastName(String lastName);

    List<Customers> findCustomerByPhoneNumber(String phoneNumber);


}
