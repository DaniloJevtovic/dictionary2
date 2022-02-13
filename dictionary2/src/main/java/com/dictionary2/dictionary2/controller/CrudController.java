package com.dictionary2.dictionary2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dictionary2.dictionary2.service.CrudService;

@RestController
public abstract class CrudController<T> {

	@Autowired
	private CrudService<T> crudService;

	@GetMapping
	public List<T> getAll() {
		return crudService.findAll();
	}

	@GetMapping("/page")
	public Page<T> getAllPage(@PageableDefault(size = 1) Pageable pageable) {
		return crudService.findAllPage(pageable);
	}

	@GetMapping("/{id}")
	public T getById(@PathVariable String id) {
		return crudService.findById(id);
	}

	@PostMapping
	public T save(@RequestBody T t) {
		return crudService.save(t);
	}

	@PutMapping
	public T update(@RequestBody T t) {
		return crudService.save(t);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		crudService.deleteById(id);
	}

}
