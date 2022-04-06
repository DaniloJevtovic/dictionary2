package com.dictionary2.dictionary2.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Group {

	@Id
	private String id;

	private String name;

	private String description;

	private int numOfItems;

	private String color;

	private GroupType type;

	private String dicId;
}
