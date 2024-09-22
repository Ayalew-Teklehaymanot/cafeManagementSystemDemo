package com.ayu.cafe.restImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ayu.cafe.constatnts.CafeConstants;
import com.ayu.cafe.rest.UserRest;
import com.ayu.cafe.service.UserService;
import com.ayu.cafe.utils.CafeUtils;
import com.ayu.cafe.wrapper.UserWrapper;

@RestController
public class UserRestImpl implements UserRest {

	@Autowired
	UserService userService;

	@Override
	public ResponseEntity<String> signup(Map<String, String> requestMap) {

		try {
			return userService.signup(requestMap);

		}

		catch (Exception ex) {
			ex.printStackTrace();

		}

		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {

		try {

			return userService.login(requestMap);

		} catch (Exception ex) {
			ex.printStackTrace();
			

		}

		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<UserWrapper>> getAllUser() {
		try {
			return  userService.getAllUser();
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return new ResponseEntity<List<UserWrapper>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> updateUser(Map<String, String> requestMap) {
		try {
			return userService.updateUser(requestMap);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
