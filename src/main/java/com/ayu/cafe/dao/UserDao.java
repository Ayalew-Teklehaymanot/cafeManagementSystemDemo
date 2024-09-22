package com.ayu.cafe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayu.cafe.POJO.User;
import com.ayu.cafe.wrapper.UserWrapper;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	User findByMailId(@Param("mail") String mail); 
	
	List<UserWrapper> getAllUsers();
}
