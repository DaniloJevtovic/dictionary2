package com.dictionary2.dictionary2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dictionary2.dictionary2.model.Group;
import com.dictionary2.dictionary2.repository.GroupRepository;

@Service
public class GroupService implements CrudService<Group> {

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public List<Group> findAll() {
		return groupRepository.findAll();
	}

	@Override
	public Page<Group> findAllPage(Pageable pageable) {
		return groupRepository.findAll(pageable);
	}

	@Override
	public Group findById(String id) {
		return groupRepository.findById(id).orElse(null);
	}

	@Override
	public Group save(Group t) {
		return groupRepository.save(t);
	}

	@Override
	public void deleteById(String id) {
		groupRepository.deleteById(id);
	}

	// grupe rjeci i recenica za rjecnik
	public List<Group> getAllGroupsForDictionary(String id, String type) {
		return groupRepository.findByDicIdAndType(id, type);
	}

}
