package com.dictionary2.dictionary2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionary2.dictionary2.model.Word;
import com.dictionary2.dictionary2.service.WordService;

@RestController
@RequestMapping("api/words")
public class WordController extends CrudController<Word> {

	@Autowired
	private WordService wordService;

	@GetMapping("/dic/{id}")
	public Page<Word> getWordsForDic(@PathVariable String id, @PageableDefault(size = 5) Pageable pageable) {
		return wordService.getWordsForDic(id, pageable);
	}

	@GetMapping("/wg/{id}")
	public Page<Word> getWordsForWg(@PathVariable String id, @PageableDefault(size = 5) Pageable pageable) {
		return wordService.getWordsForGroup(id, pageable);
	}

	@GetMapping("/dic/{id}/search/{value}")
	public List<Word> searchInDic(@PathVariable String id, @PathVariable String value) {
		return wordService.searchInDic(id, value);
	}

	@GetMapping("/wg/{id}/search/{value}")
	public List<Word> searchInWg(@PathVariable String id, @PathVariable String value) {
		return wordService.searchInWg(id, value);
	}
	
	@PatchMapping("/{id}/favorite/{value}")
	public void updateFav(@PathVariable String id, @PathVariable Boolean value) {
		wordService.updateFav(id, value);
	}
}
