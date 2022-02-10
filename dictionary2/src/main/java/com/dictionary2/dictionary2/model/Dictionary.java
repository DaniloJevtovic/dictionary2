package com.dictionary2.dictionary2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Dictionary {
	
	@Id
	private String id;

	private String name;
	
	private String description;
	
	private String color;
	
	private String userId;
}
