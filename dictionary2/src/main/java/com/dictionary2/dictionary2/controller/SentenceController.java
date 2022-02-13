package com.dictionary2.dictionary2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionary2.dictionary2.model.Sentence;
import com.dictionary2.dictionary2.service.SentenceService;

@RestController
@RequestMapping("api/sentences")
public class SentenceController extends CrudController<Sentence> {

	@Autowired
	private SentenceService sentenceService;

	@GetMapping("/dic/{id}")
	public Page<Sentence> getWordsForDic(@PathVariable String id, @PageableDefault(size = 1) Pageable pageable) {
		return sentenceService.getSentencesForDic(id, pageable);
	}

	@GetMapping("/sg/{id}")
	public Page<Sentence> getWordsForWg(@PathVariable String id, @PageableDefault(size = 1) Pageable pageable) {
		return sentenceService.getSentencesForDic(id, pageable);
	}
}