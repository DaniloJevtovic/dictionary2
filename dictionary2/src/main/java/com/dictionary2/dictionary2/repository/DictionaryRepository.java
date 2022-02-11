package com.dictionary2.dictionary2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dictionary2.dictionary2.model.Dictionary;

public interface DictionaryRepository extends MongoRepository<Dictionary, String> {
	
	List<Dictionary> findByUserId(String id);

}
