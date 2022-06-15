package com.dictionary2.dictionary2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Grammar {

	@Id
	private String id;

	private String grammar;

	private String content;

	private String dicId;
}
