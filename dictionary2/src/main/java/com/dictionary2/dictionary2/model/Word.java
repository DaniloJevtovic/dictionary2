package com.dictionary2.dictionary2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Word {

	@Id
	private String id;
	
	private String word;
	
	private String translate;
	
	private String description;	
	
//	private String picture;
	
	private String wgId;
	
	private String dicId;
	
}
