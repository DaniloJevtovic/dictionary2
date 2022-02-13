package com.dictionary2.dictionary2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dictionary2.dictionary2.model.Word;
import com.dictionary2.dictionary2.repository.WordRepository;

@Service
public class WordService implements CrudService<Word> {

	@Autowired
	private WordRepository wordRepository;

	@Override
	public List<Word> findAll() {
		return wordRepository.findAll();
	}

	@Override
	public Page<Word> findAllPage(Pageable pageable) {
		return wordRepository.findAll(pageable);
	}

	@Override
	public Word findById(String id) {
		return wordRepository.findById(id).orElse(null);
	}

	@Override
	public Word save(Word t) {
		return wordRepository.save(t);
	}

	@Override
	public void deleteById(String id) {
		wordRepository.deleteById(id);
	}

	public Page<Word> getWordsForDic(String dicId, Pageable pageable) {
		return wordRepository.findByDicId(dicId, pageable);
	}

	public Page<Word> getWordsForGroup(String wgId, Pageable pageable) {
		return wordRepository.findByWgId(wgId, pageable);
	}

}
