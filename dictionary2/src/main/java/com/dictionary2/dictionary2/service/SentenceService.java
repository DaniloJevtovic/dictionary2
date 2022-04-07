package com.dictionary2.dictionary2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dictionary2.dictionary2.model.Sentence;
import com.dictionary2.dictionary2.repository.SentenceRepository;

@Service
public class SentenceService implements CrudService<Sentence> {

	@Autowired
	private SentenceRepository sentenceRepository;

	@Override
	public List<Sentence> findAll() {
		return sentenceRepository.findAll();
	}

	@Override
	public Page<Sentence> findAllPage(Pageable pageable) {
		return sentenceRepository.findAll(pageable);
	}

	@Override
	public Sentence findById(String id) {
		return sentenceRepository.findById(id).orElse(null);
	}

	@Override
	public Sentence save(Sentence t) {
		return sentenceRepository.save(t);
	}

	@Override
	public void deleteById(String id) {
		sentenceRepository.deleteById(id);
	}

	public Page<Sentence> getSentencesForDic(String dicId, Pageable pageable) {
		return sentenceRepository.findByDicId(dicId, pageable);
	}

	public Page<Sentence> getSentencesForGroup(String sgId, Pageable pageable) {
		return sentenceRepository.findBySgId(sgId, pageable);
	}

	public void updateFav(String id, Boolean favorite) {
		Sentence sentence = findById(id);
		sentence.setFavorite(favorite);
		sentenceRepository.save(sentence);
	}

}
