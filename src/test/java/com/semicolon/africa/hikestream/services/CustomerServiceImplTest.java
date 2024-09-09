package com.semicolon.africa.hikestream.services;

import com.semicolon.africa.hikestream.data.repository.CustomerRepository;
import com.semicolon.africa.hikestream.dto.request.LoginCustomerRequest;
import com.semicolon.africa.hikestream.dto.request.SignupCustomerRequest;
import com.semicolon.africa.hikestream.dto.response.LoginCustomerResponse;
import com.semicolon.africa.hikestream.dto.response.SignupCustomerResponse;
import com.semicolon.africa.hikestream.exception.EmptyFieldsException;
import com.semicolon.africa.hikestream.exception.PasswordLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    public void testThaCustomerCanSignUp(){
        SignupCustomerRequest request = new SignupCustomerRequest();
        request.setFirstName("Eniola");
        request.setLastName("Ola");
        request.setPhoneNumber("08123115688");
        request.setEmail("eniola@gmail.com");
        request.setHomeAddress("Herbert macaulay way, Sabo, Yaba, Lagos");
        request.setPassword("12345");
        SignupCustomerResponse response = customerService.signUp(request);
        assertThat(response.getMessage()).contains("Signup successfully");
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatWhenFieldsAreEmpty_ThrowEmptyFieldsException(){
        SignupCustomerRequest request = new SignupCustomerRequest();
        request.setFirstName("ww");
        request.setLastName("ddd");
        request.setPhoneNumber("ddd");
        request.setEmail("ddd");
        request.setHomeAddress("fkf");
        request.setPassword("sss");
        assertThrows(EmptyFieldsException.class, ()-> customerService.signUp(request));
    }

    @Test
    public void testThatPasswordLengthMustBeEight_ThrowPasswordLengthException(){
        SignupCustomerRequest request = new SignupCustomerRequest();
        request.setFirstName("Victor");
        request.setLastName("Emaye");
        request.setPhoneNumber("0903432322");
        request.setEmail("victoremaye@gmail.com");
        request.setHomeAddress("Ojata,Lagos, Nigeria");
        request.setPassword("123454");
        assertThrows(PasswordLengthException.class, ()-> customerService.signUp(request));
    }


    @Test
    public void testThatNofFieldsIsEmpty_Blank(){
        SignupCustomerRequest request = new SignupCustomerRequest();
        request.setFirstName("dd");
        request.setLastName("dd");
        request.setPhoneNumber("dd");
        request.setEmail("mfon@gmail.com");
        request.setHomeAddress("www");
        request.setPassword("12345678");
        assertThrows(EmptyFieldsException.class, ()-> customerService.signUp(request));
    }

    @Test
    public void testThatCustomerCanLogin(){
       LoginCustomerRequest request = new LoginCustomerRequest();
       request.setPassword("12345678");
       request.setEmail("mfon@gmail.com");
       LoginCustomerResponse response = customerService.login(request);
       assertThat(response).isNotNull();
       assertThat(response.getMessage()).contains("Login successfully");
    }
}