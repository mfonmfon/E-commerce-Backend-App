package com.semicolon.africa.hikestream.data.repository;

import com.semicolon.africa.hikestream.data.model.Sellers;
import org.springframework.data.mongodb.core.MongoAdminOperations;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellersRepository extends MongoRepository<Sellers, String> {
}
