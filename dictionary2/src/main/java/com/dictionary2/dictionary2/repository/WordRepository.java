package com.dictionary2.dictionary2.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dictionary2.dictionary2.model.Word;

public interface WordRepository extends MongoRepository<Word, String> {

	Page<Word> findByDicId(String id, Pageable pageable);

	Page<Word> findByWgId(String id, Pageable pageable);
}
