
package com.ayu.cafe.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.ayu.cafe.JWT.CustomerUserDetailsService;
import com.ayu.cafe.JWT.JwtFilter;
import com.ayu.cafe.JWT.JwtUtils;
import com.ayu.cafe.POJO.User;
import com.ayu.cafe.constatnts.CafeConstants;
import com.ayu.cafe.dao.UserDao;
import com.ayu.cafe.service.UserService;
import com.ayu.cafe.utils.CafeUtils;
import com.ayu.cafe.wrapper.UserWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	CustomerUserDetailsService customerUserDetailsService;

	@Autowired
	JwtUtils jwtUtil;

	@Autowired
	JwtFilter jwtFilter;

	@Override
	public ResponseEntity<String> signup(Map<String, String> requestMap) {
		// log.info("Inside signup{}",requestMap)
		try {
			if (validateSignUpMap(requestMap)) {

				User user = userDao.findByMailId(requestMap.get("mail"));
				if (Objects.isNull(user)) {
					userDao.save(getUserFromMap(requestMap));
					return CafeUtils.getResponseEntity("User Successfully Registered", HttpStatus.OK);

				} else {
					return CafeUtils.getResponseEntity("The User Already Exists", HttpStatus.BAD_REQUEST);
				}

			} else {
				return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.BAD_REQUEST);

	}

	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if (requestMap.containsKey("contactNumber") && requestMap.containsKey("name") && requestMap.containsKey("mail")
				&& requestMap.containsKey("password")) {
			return true;
		}
		return false;

	}

	private User getUserFromMap(Map<String, String> requestMap) {
		User user = new User();
		user.setName(requestMap.get("name"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setMail(requestMap.get("mail"));
		user.setPassword(requestMap.get("password"));
		user.setStatus("false");
		user.setRole("user");

		return user;

	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {

		try {

			Authentication auth = authenticationManager.authenticate(

					new UsernamePasswordAuthenticationToken(requestMap.get("mail"), requestMap.get("password")));
			if (auth.isAuthenticated()) {
				if (customerUserDetailsService.getUserDeatil().getStatus().equalsIgnoreCase("true")) {
					return new ResponseEntity<String>(
							"{\"token\":\""
									+ jwtUtil.generateToken(customerUserDetailsService.getUserDeatil().getMail(),
											customerUserDetailsService.getUserDeatil().getRole())
									+ "\"}",
							HttpStatus.OK);

				} else {
					return new ResponseEntity<String>("{\"message\":\"" + "Wait for Admin approval" + "\"}",
							HttpStatus.BAD_REQUEST);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new ResponseEntity<String>("{\"message\":\"" + "Bad Credential" + "\"}", HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<List<UserWrapper>> getAllUser() {
		try {
			if (jwtFilter.isAdmin()) {
				return new ResponseEntity<> (userDao.getAllUsers(), HttpStatus.OK);

			} else {
				return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> updateUser(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
