package com.semicolon.africa.hikestream.services;

import com.semicolon.africa.hikestream.data.model.Customers;
import com.semicolon.africa.hikestream.data.repository.CustomerRepository;
import com.semicolon.africa.hikestream.dto.request.*;
import com.semicolon.africa.hikestream.dto.response.*;
import com.semicolon.africa.hikestream.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.africa.hikestream.utils.Mapper.*;

@Service
public class CustomerServiceImpl implements CustomerService{
    
    @Autowired
   private CustomerRepository customerRepository;

    @Override
    public SignupCustomerResponse signUp(SignupCustomerRequest request) {
        validateCustomerEmail(request.getEmail());
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
        validateCustomerEmail(loginRequest.getEmail());
        customers.setPassword(loginRequest.getPassword());
        customers.setEmail(loginRequest.getEmail());
        if (isValueIsNullOrEmpty(customers.getEmail()) ||
                isValueIsNullOrEmpty(customers.getPassword())) {
            throw new EmptyFieldsException("Empty fields, please enter all fields");
        }
        if (isValueIsNullOrEmpty(loginRequest.getEmail()) ||
                isValueIsNullOrEmpty(loginRequest.getPassword())) {
            throw new EmptyFieldsException("Empty fields, please enter all fields");
        } else {
            LoginCustomerResponse response = new LoginCustomerResponse();
            response.setPassword(customers.getPassword());
            response.setEmail(customers.getEmail());
            response.setLoggedIn(true);
            response.setMessage("Login Successfully");
            return response;
        }
    }

    private void validateCustomerEmail(String email) {
        customerRepository.findCustomerByEmail(email).
                orElseThrow(() -> new CustomerNotFoundException("Customer Does not exist"));
    }

    @Override
    public LogoutCustomerResponse logout(String email) {
        Customers customers = new Customers();
        customers.setLoggedIn(true);
        validateCustomerEmail(email);
        customerRepository.save(customers);
        LogoutCustomerResponse response = new LogoutCustomerResponse();
        response.setMessage("Logout successfully");
        return response;
    }

    @Override
    public AddCustomerResponse addCustomer(AddCustomerRequest request) {
        Customers customers = addCustomerRequest(request);
        if (isValueIsNullOrEmpty(request.getFirstName()) ||
                isValueIsNullOrEmpty(request.getLastName()) ||
                isValueIsNullOrEmpty(request.getEmail())||
                isValueIsNullOrEmpty(request.getPhoneNumber())||
                isValueIsNullOrEmpty(request.getHomeAddress())){
            throw new EmptyFieldsException("Empty fields, please enter all fields");
        }
        if (!request.getEmail().contains("@") || ! request.getEmail().contains(".")){
            throw new InvalidEmailInputException("Email must contain @ or .");
        }
        customerRepository.save(customers);
        return addCustomerResponse(customers);
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) {
        Customers customers = findByCustomerEmail(request.getEmail());
        updateCustomerRequest(request, customers);
        if (isValueIsNullOrEmpty(request.getFirstName())||
                isValueIsNullOrEmpty(request.getEmail())||
                isValueIsNullOrEmpty(request.getLastName())||
                isValueIsNullOrEmpty(request.getHomeAddress())||
                isValueIsNullOrEmpty(request.getPhoneNumber())){
            throw new InvalidEmailInputException("Empty fields, please enter all fields");
        }
        return UpdateCustomerResponseMapping(customers);
    }
    private Customers findByCustomerEmail(String email) {
        return customerRepository.findCustomerByEmail(email)
                .orElseThrow(()-> new CustomerDoesNotExistException("Account Not Found"));
    }

    @Override
    public PurchaseResponse purchase(PurchaseRequest purchaseRequest) {
        return null;
    }

    @Override
    public DeleteCustomerResponse deleteCustomerFirstName(String firstName) {
        Customers customers = findByFirstName(firstName);
        customerRepository.delete(customers);
        DeleteCustomerResponse response = new DeleteCustomerResponse();
        response.setMessage("Delete successfully");
        return response;
    }

    private Customers findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName).
                orElseThrow(()-> new FirstNameNotFound("Not found"));
    }

    @Override
    public List<Customers> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customers> findCustomerByFirstName(String firstName) {
        return customerRepository.findCustomerByFirstName(firstName);
    }

    @Override
    public List<Customers> findCustomerByLastName(String lastName) {
        return customerRepository.findCustomerByLastName(lastName);
    }

    @Override
    public List<Customers> findCustomerByPhoneNumber(String phoneNumber) {
        return customerRepository.findCustomersByPhoneNumber(phoneNumber);
    }

    private boolean passwordLength(String password) {
        return password.length() == 8;
    }
    private boolean isValueIsNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
