package com.semicolon.africa.hikestream.data.repository;

import com.semicolon.africa.hikestream.data.model.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customers, String> {
  Optional<Customers>  findCustomerByEmail(String email);
}
