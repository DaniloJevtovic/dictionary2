package com.dictionary2.dictionary2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dictionary2.dictionary2.model.Dictionary;
import com.dictionary2.dictionary2.repository.DictionaryRepository;

@Service
public class DictionaryService implements CrudService<Dictionary> {

	@Autowired
	private DictionaryRepository dictionaryRepository;

	@Autowired
	GroupService groupService;

	@Autowired
	SentenceService sentenceService;

	@Autowired
	WordService wordService;

	@Autowired
	GrammarService grammarService;

	@Override
	public List<Dictionary> findAll() {
		return dictionaryRepository.findAll();
	}

	@Override
	public Page<Dictionary> findAllPage(Pageable pageable) {
		return dictionaryRepository.findAll(pageable);
	}

	@Override
	public Dictionary findById(String id) {
		return dictionaryRepository.findById(id).orElse(null);
	}

	@Override
	public Dictionary save(Dictionary t) {
		return dictionaryRepository.save(t);
	}

	@Override
	public void deleteById(String id) {
		// brisanje svih grupa, rjeci, recenica i gramatika
		groupService.deleteAllGroupsForDic(id);
		wordService.deleteAllWordsForDic(id);
		sentenceService.deleteAllSentencesForDic(id);
		grammarService.deleteAllGrammarsForDic(id);

		dictionaryRepository.deleteById(id);
	}

	public List<Dictionary> getDictionariesForUser(String userId) {
		return dictionaryRepository.findByUserId(userId);
	}

}
