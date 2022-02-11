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
	public Dictionary update(String id, Dictionary t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		dictionaryRepository.deleteById(id);
	}

}
