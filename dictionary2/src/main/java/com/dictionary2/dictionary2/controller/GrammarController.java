package com.dictionary2.dictionary2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionary2.dictionary2.model.Grammar;
import com.dictionary2.dictionary2.service.GrammarService;

@RestController
@RequestMapping("api/grammars")
public class GrammarController extends CrudController<Grammar> {

	@Autowired
	private GrammarService grammarService;

	@GetMapping("/dic/{id}")
	public Page<Grammar> getGrammarsForDic(@PathVariable String id, @PageableDefault(size = 30) Pageable pageable) {
		return grammarService.getGrammarsForDictionary(id, pageable);
	}

	@GetMapping("/dic/{id}/search/{grammar}")
	public Page<Grammar> searchByGrammar(@PathVariable String id, @PathVariable String grammar, Pageable pageable) {
		return grammarService.searchByGrammar(id, grammar, pageable);
	}

}
