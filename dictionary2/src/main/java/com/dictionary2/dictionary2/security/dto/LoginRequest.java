package com.dictionary2.dictionary2.security.dto;

import lombok.Data;

@Data
public class LoginRequest {

	private String email;
	
	private String password;
}
