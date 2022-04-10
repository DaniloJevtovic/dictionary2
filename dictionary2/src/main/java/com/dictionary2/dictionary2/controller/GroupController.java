package com.dictionary2.dictionary2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionary2.dictionary2.model.Group;
import com.dictionary2.dictionary2.service.GroupService;

@RestController
@RequestMapping("api/groups")
public class GroupController extends CrudController<Group> {

	@Autowired
	private GroupService groupService;

	@GetMapping("/dic/{id}/all")
	public List<Group> getAllGroupsForDictionary(@PathVariable String id) {
		return groupService.getAllGroupsForDictionary(id);
	}

	@GetMapping("/dic/{id}/group/{type}")
	public List<Group> getGroupsForDictionaryByType(@PathVariable String id, @PathVariable String type) {
		return groupService.getGroupsForDictionaryByType(id, type);
	}

	@PutMapping("/{id}/increase")
	public void icreaseItemsInGroup(@PathVariable String id) {
		groupService.increaseItemsInGroup(id);
	}

	@PutMapping("/{id}/decrease")
	public void decreaseItemsInGroup(@PathVariable String id) {
		groupService.decreaseItemsInGroup(id);
	}

	@PatchMapping("/{id}/num/{newNum}")
	public void updateNumOfItemsInGroup(@PathVariable String id, @PathVariable int newNum) {
		groupService.updateNumOfItemsInGroup(id, newNum);
	}

}
