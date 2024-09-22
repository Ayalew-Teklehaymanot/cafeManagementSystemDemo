package com.ayu.cafe.JWT;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ayu.cafe.dao.UserDao;
/*
@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	UserDao userDao;

	private com.ayu.cafe.POJO.User userDetail;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		userDetail = userDao.findByMailId(username);
		if (!Objects.isNull(userDetail))
			return new User(userDetail.getMail(), userDetail.getPassword(), new ArrayList<>());
		else
			throw new UsernameNotFoundException("User Not Found");

	}
	
	public  com.ayu.cafe.POJO.User getUserDetail(){
		return userDetail;
	}

}*/

/////////////////////////
@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	UserDao userDao;

	private com.ayu.cafe.POJO.User userDetail;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		userDetail = userDao.findByMailId(username);
		if (!Objects.isNull(userDetail))
			return new User(userDetail.getMail(), userDetail.getPassword(), new ArrayList<>());
		else
			throw new UsernameNotFoundException("User Not Found.");

	}

	public com.ayu.cafe.POJO.User getUserDeatil() {

		return userDetail;
	}

}
