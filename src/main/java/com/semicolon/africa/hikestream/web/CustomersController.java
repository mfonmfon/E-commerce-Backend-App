package com.semicolon.africa.hikestream.web;

import com.semicolon.africa.hikestream.data.model.Customers;
import com.semicolon.africa.hikestream.dto.request.AddCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.LoginCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.SignupCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.UpdateCustomerRequest;
import com.semicolon.africa.hikestream.dto.response.*;
import com.semicolon.africa.hikestream.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.EOFException;
import java.util.List;

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

    @PostMapping("/addCustomers")
    public ResponseEntity<?> addCustomers(@RequestBody AddCustomerRequest request){
        try {
            AddCustomerResponse response = customerService.addCustomer(request);
            return new ResponseEntity<>(new ApiResponse(true, response),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCustomers")
    public ResponseEntity<?> updatedCustomers(@RequestBody UpdateCustomerRequest request){
        try {
            UpdateCustomerResponse response = customerService.updateCustomer(request);
            return new ResponseEntity<>(new ApiResponse(false, response),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.OK);
        }
    }
    @GetMapping
    public ResponseEntity<?> displayAllCustomers(){
       try {
           List<Customers> findAllCustomers = customerService.findAllCustomers();
           return new ResponseEntity<>(new ApiResponse(true, findAllCustomers),
                   HttpStatus.BAD_REQUEST);
       }
       catch (Exception exception){
           return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                   HttpStatus.BAD_REQUEST);
       }
    }
    @GetMapping("/searchByFirstName{firstName}")
    public ResponseEntity<?> searchByFirstName(@PathVariable String firstName){
       try {
           List<Customers> findByFirstName = customerService.findCustomerByFirstName(firstName);
           return new ResponseEntity<>(new ApiResponse(true, findByFirstName),
                   HttpStatus.OK);
       }
       catch (Exception exception){
           return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                   HttpStatus.BAD_REQUEST);
       }
    }
    @GetMapping("/searchByLastName{lastName}")
    public ResponseEntity<?> searchByLastName(@PathVariable String lastName){
        try {
            List<Customers> findByLastName = customerService.findCustomerByLastName(lastName);
            return new ResponseEntity<>(new ApiResponse(true, findByLastName),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/searchByPhoneNumber{phoneNumber}")
    public ResponseEntity<?> searchByPhoneNumber(@PathVariable String phoneNumber){
        try {
            List<Customers> searchByPhoneNumber = customerService.findCustomerByPhoneNumber(phoneNumber);
            return new ResponseEntity<>(new ApiResponse(true, searchByPhoneNumber),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteBy/firstName")
    public ResponseEntity<?> deleteBy(String firstName){
        try {
            DeleteCustomerResponse response = customerService.deleteCustomerFirstName(firstName);
            return new ResponseEntity<>(new ApiResponse(true, response),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/logout/{email}")
    public ResponseEntity<?> logout(@PathVariable String email){
        try {

        }

    }
}