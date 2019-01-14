package com.ssm.shoppingstreet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssm.shoppingstreet.modal.Hello;
import com.ssm.shoppingstreet.service.HelloService;

@Controller
public class HelloController {
	@Autowired
	@Qualifier("helloService")
	private HelloService helloService;

	@GetMapping("/hello")
	public String hello(ModelMap map) {
		Hello hello = helloService.selectHelloById(1);
		map.addAttribute("hello", hello);
		return "hello";
	}
	
}
