package com.dictionary2.dictionary2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dictionary2.dictionary2.model.Sentence;

public interface SentenceRepository extends MongoRepository<Sentence, String> {

	Page<Sentence> findByDicId(String id, Pageable pageable);

	Page<Sentence> findBySgId(String id, Pageable pageable);

	// paginacija zbog filtera
	Page<Sentence> findByDicIdAndSentenceContainsOrDicIdAndTranslateContains(String id, String sentence, String id2,
			String translate, Pageable pageable);

	Page<Sentence> findBySgIdAndSentenceContainsOrSgIdAndTranslateContains(String wgId, String sentence, String wg1Id,
			String translate, Pageable pageable);

	Long removeByDicId(String dicId);

	Long removeBySgId(String sgId);

}
