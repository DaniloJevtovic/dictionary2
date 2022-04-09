package com.dictionary2.dictionary2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dictionary2.dictionary2.model.Group;

public interface GroupRepository extends MongoRepository<Group, String> {

	List<Group> findByDicId(String id);

	List<Group> findByDicIdAndType(String id, String type);

}
