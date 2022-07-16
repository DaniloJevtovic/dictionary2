package com.dictionary2.dictionary2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionary2.dictionary2.exception.ResourceConflictException;
import com.dictionary2.dictionary2.model.User;
import com.dictionary2.dictionary2.security.dto.LoginRequest;
import com.dictionary2.dictionary2.security.TokenUtils;
import com.dictionary2.dictionary2.security.dto.JwtResponse;
import com.dictionary2.dictionary2.service.UserService;

@RestController
@RequestMapping("api/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenUtils tokenUtils;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		Authentication authentication;

		try {
			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		} catch (Exception e) {
			return new ResponseEntity<>("wrong credentials", HttpStatus.BAD_REQUEST);
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
		User user = (User) authentication.getPrincipal();

		String jwt = tokenUtils.generateToken(user.getEmail());
		int expiresIn = tokenUtils.getExpiredIn();

		return ResponseEntity.ok(new JwtResponse(jwt, expiresIn));
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User regUser) {
		User user = userService.getUserByEmail(regUser.getEmail());

		if (user != null) {
			//throw new ResourceConflictException(regUser.getEmail(), "User with that email exists!");
			return new ResponseEntity<>("User with that email exists!", HttpStatus.BAD_REQUEST);
		}

		User newUser = userService.register(regUser);

		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

}
