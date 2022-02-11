package com.dictionary2.dictionary2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dictionary2.dictionary2.model.Sentence;

public interface SentenceRepository extends MongoRepository<Sentence, String> {

	Page<Sentence> findByDicId(String id, Pageable pageable);
	
	Page<Sentence> findBySgId(String id, Pageable pageable);
	
}

