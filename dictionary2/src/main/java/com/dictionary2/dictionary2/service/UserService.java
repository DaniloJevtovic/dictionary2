package com.dictionary2.dictionary2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dictionary2.dictionary2.model.User;
import com.dictionary2.dictionary2.repository.UserRepository;
import com.dictionary2.dictionary2.security.TokenUtils;
import com.dictionary2.dictionary2.security.dto.LoginRequest;
import com.dictionary2.dictionary2.security.dto.JwtResponse;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	TokenUtils tokenUtils;

	public User getUserById(String id) {
		return userRepository.findById(id).orElse(null);
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getUserByEmail(username);

		if (user == null)
			throw new UsernameNotFoundException("User not found!");

		return user;
	}

	public JwtResponse login(LoginRequest request) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		User user = (User) authentication.getPrincipal();

		String jwt = tokenUtils.generateToken(user.getEmail());
		int expiresIn = tokenUtils.getExpiredIn();

		return new JwtResponse(jwt, expiresIn);
	}

	public User register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

}
