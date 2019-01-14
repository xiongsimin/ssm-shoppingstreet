package com.ssm.shoppingstreet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.shoppingstreet.dao.HelloDao;
import com.ssm.shoppingstreet.modal.Hello;
import com.ssm.shoppingstreet.service.HelloService;
@Service("helloService")
public class HelloServiceImpl implements HelloService{
	@Autowired
	private HelloDao helloDao;
	public Hello selectHelloById(Integer id) {
		return this.helloDao.selectHelloById(id);
	}
}
