package com.ssm.shoppingstreet.dao;

import org.springframework.stereotype.Repository;

import com.ssm.shoppingstreet.modal.Hello;
@Repository
public interface HelloDao {
	Hello selectHelloById(Integer id);
}
