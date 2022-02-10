package com.dictionary2.dictionary2.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Document
@Data
public class Sentence {

	@Id
	private String id;
	
	private String word;
	
	private String translate;
	
	private String sgId;
	
	private String dicId;
}
