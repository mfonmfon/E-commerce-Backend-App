package com.semicolon.africa.hikestream.data.repository;

import com.semicolon.africa.hikestream.data.model.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customers, String> {
  Optional<Customers>  findCustomerByEmail(String email);

  Optional<Customers> findByFirstName(String firstName);

  List<Customers> findCustomerByFirstName(String firstName);

  List<Customers> findCustomerByLastName(String lastName);

  List<Customers> findCustomersByPhoneNumber(String phoneNumber);
}
