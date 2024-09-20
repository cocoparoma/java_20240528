package kr.kh.study2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.kh.study2.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
}
