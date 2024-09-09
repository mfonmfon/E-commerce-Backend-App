package com.semicolon.africa.hikestream.services;

import com.semicolon.africa.hikestream.data.model.Customers;
import com.semicolon.africa.hikestream.data.repository.CustomerRepository;
import com.semicolon.africa.hikestream.dto.request.AddCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.LoginCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.SignupCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.UpdateCustomerRequest;
import com.semicolon.africa.hikestream.dto.response.*;
import com.semicolon.africa.hikestream.exception.CustomerNotFoundException;
import com.semicolon.africa.hikestream.exception.EmptyFieldsException;
import com.semicolon.africa.hikestream.exception.PasswordLengthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.africa.hikestream.utils.Mapper.AddCustomerRequestMapper;
import static com.semicolon.africa.hikestream.utils.Mapper.AddCustomerResponseMapper;

@Service
public class CustomerServiceImpl implements CustomerService{
    
    @Autowired
   private CustomerRepository customerRepository;

    @Override
    public SignupCustomerResponse signUp(SignupCustomerRequest request) {
        Customers customers = new Customers();
        AddCustomerRequestMapper(request, customers);
        if(isValueIsNullOrEmpty(request.getFirstName())||
                isValueIsNullOrEmpty(request.getLastName())||
                isValueIsNullOrEmpty(request.getEmail())||
                isValueIsNullOrEmpty(request.getPassword())||
                isValueIsNullOrEmpty(request.getConfirmPassword())||
                isValueIsNullOrEmpty(request.getPhoneNumber())||
                isValueIsNullOrEmpty(request.getHomeAddress())){
            throw new EmptyFieldsException("Empty fields, please enter all fields");
        }
        if (!passwordLength(request.getPassword())){
            throw new PasswordLengthException("password length must be 8");
        }
        customerRepository.save(customers);
        return AddCustomerResponseMapper(customers);
    }

    @Override
    public LoginCustomerResponse login(LoginCustomerRequest loginRequest) {
        Customers customers = new Customers();
        findCustomerByEmail(loginRequest.getEmail());
        customers.setPassword(loginRequest.getPassword());
        customers.setEmail(loginRequest.getEmail());
        if (isValueIsNullOrEmpty(loginRequest.getEmail())||
                isValueIsNullOrEmpty(loginRequest.getPassword())){
            throw new EmptyFieldsException("Empty fields, please enter all fields");
        }
        LoginCustomerResponse response = new LoginCustomerResponse();
        response.setPassword(customers.getPassword());
        response.setEmail(customers.getEmail());
        response.setMessage("Login Successfully");
        return response;
    }

    private void findCustomerByEmail(String email) {
        customerRepository.findCustomerByEmail(email).
                orElseThrow(() -> new CustomerNotFoundException("Customer Does not exist"));
    }

    @Override
    public LogoutCustomerResponse logout() {
        return null;
    }

    @Override
    public AddCustomerResponse addCustomer(AddCustomerRequest request) {
        return null;
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) {
        return null;
    }

    @Override
    public DeleteCustomerResponse deleteCustomerFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Customers> findAllCustomers() {
        return List.of();
    }

    @Override
    public List<Customers> findCustomerByFirstName(String firstName) {
        return List.of();
    }

    @Override
    public List<Customers> findCustomerByLastName(String lastName) {
        return List.of();
    }

    @Override
    public List<Customers> findCustomerByPhoneNumber(String phoneNumber) {
        return List.of();
    }

    private boolean passwordLength(String password) {
        return password.length() == 8;
    }
    private boolean isValueIsNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }


}
