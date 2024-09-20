package kr.kh.study2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study2.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDao;
	
}
