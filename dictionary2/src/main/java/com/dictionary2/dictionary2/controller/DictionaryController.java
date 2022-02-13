package com.dictionary2.dictionary2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionary2.dictionary2.model.Dictionary;
import com.dictionary2.dictionary2.service.DictionaryService;

@RestController
@RequestMapping("api/dictionaries")
public class DictionaryController extends CrudController<Dictionary> {

	@Autowired
	private DictionaryService dictionaryService;

	@GetMapping("/user/{id}")
	public List<Dictionary> getDictionariesForUser(@PathVariable String id) {
		return dictionaryService.getDictionariesForUser(id);
	}

}
