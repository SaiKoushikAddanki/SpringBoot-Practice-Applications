package com.koushik.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koushik.demo.model.AuthenticationRequest;
import com.koushik.demo.model.AuthenticationResponse;
import com.koushik.demo.service.MyuserDetailsService;
import com.koushik.demo.utilities.JwtUtil;

@RestController
public class GatewayController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	MyuserDetailsService myuserDetailsService;
	@Autowired
	JwtUtil jwtUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid username or password",e);
		}
		
		final UserDetails userDetails = myuserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@GetMapping("/welcome")
	public String getInitialMessage() {
		return "Welcome to the Hotel Reservation System";
	}
}
