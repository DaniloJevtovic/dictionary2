package com.dictionary2.dictionary2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dictionary2.dictionary2.model.Grammar;

public interface GrammarRepository extends MongoRepository<Grammar, String> {

	Page<Grammar> findByDicId(String id, Pageable pageable);
}
