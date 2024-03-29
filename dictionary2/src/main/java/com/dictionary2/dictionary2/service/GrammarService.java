package com.dictionary2.dictionary2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dictionary2.dictionary2.model.Grammar;
import com.dictionary2.dictionary2.repository.GrammarRepository;

@Service
public class GrammarService implements CrudService<Grammar> {

	@Autowired
	private GrammarRepository grammarRepository;

	@Override
	public List<Grammar> findAll() {
		return grammarRepository.findAll();
	}

	@Override
	public Page<Grammar> findAllPage(Pageable pageable) {
		return grammarRepository.findAll(pageable);
	}

	@Override
	public Grammar findById(String id) {
		return grammarRepository.findById(id).orElse(null);
	}

	@Override
	public Grammar save(Grammar t) {
		return grammarRepository.save(t);
	}

	@Override
	public void deleteById(String id) {
		grammarRepository.deleteById(id);
	}

	public Page<Grammar> getGrammarsForDictionary(String dicId, Pageable pageable) {
		return grammarRepository.findByDicId(dicId, pageable);
	}

	public Page<Grammar> searchByGrammar(String dicId, String grammar, Pageable pageable) {
		return grammarRepository.findByDicIdAndGrammarContains(dicId, grammar, pageable);
	}

	public Long deleteAllGrammarsForDic(String dicId) {
		return grammarRepository.removeByDicId(dicId);
	}
}
