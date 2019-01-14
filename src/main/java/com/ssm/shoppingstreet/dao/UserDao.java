package com.ssm.shoppingstreet.dao;

import org.apache.ibatis.annotations.Param;

import com.ssm.shoppingstreet.modal.User;

public interface UserDao {
	void addUser(@Param("name")String name,@Param("password")String password,@Param("rePassword")String rePassword,@Param("email")String email,@Param("phone")String phone,@Param("inviterName")String inviterName,@Param("inviterId")int inviterId);
	User findUserByName(@Param("name")String name);
}
