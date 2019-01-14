package com.ssm.shoppingstreet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.shoppingstreet.dao.UserDao;
import com.ssm.shoppingstreet.modal.User;
import com.ssm.shoppingstreet.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	public void addUser(String name,String password,String rePassword,String email,String phone,String inviterName,int inviterId){
		this.userDao.addUser(name, password, rePassword, email, phone, inviterName, inviterId);
	}
	public User findUserByName(String name) {
		return this.userDao.findUserByName(name);
	}
}
