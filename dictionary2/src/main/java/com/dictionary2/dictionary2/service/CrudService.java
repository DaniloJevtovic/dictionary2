package com.dictionary2.dictionary2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T> {
	
	public List<T> findAll();

	public Page<T> findAllPage(Pageable pageable);
	
	public T findById(String id);

	public T save(T t);

	public T update(String id, T t);

	public void deleteById(String id);
	
}
