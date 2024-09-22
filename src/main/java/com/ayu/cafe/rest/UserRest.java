package com.ayu.cafe.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ayu.cafe.wrapper.UserWrapper;

@RequestMapping(path = "/user")
public interface UserRest {

	@PostMapping(path = "/signup")
	public ResponseEntity<String> signup(@RequestBody(required = true) Map<String, String> requestMap);

	@PostMapping(path = "/login")
	public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap);
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<UserWrapper>> getAllUser();
	
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody(required=true) Map<String, String> requestMap);

}
