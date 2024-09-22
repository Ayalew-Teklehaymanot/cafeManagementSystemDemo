package com.ayu.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ayu.cafe.wrapper.UserWrapper;

public interface UserService {

	ResponseEntity<String> signup(Map<String, String> requestMap);

	ResponseEntity<String> login(Map<String, String> requestMap);

	ResponseEntity<List<UserWrapper>> getAllUser();

	ResponseEntity<String> updateUser(Map<String, String> requestMap);

}
