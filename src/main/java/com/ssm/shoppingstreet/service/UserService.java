package com.ssm.shoppingstreet.service;

import com.ssm.shoppingstreet.modal.User;

public interface UserService {
	void addUser(String name,String password,String rePassword,String email,String phone,String inviterName,int inviterId);
	User findUserByName(String name);
}
