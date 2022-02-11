package com.dictionary2.dictionary2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dictionary2.dictionary2.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
