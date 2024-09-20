package kr.kh.study2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.study2.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void pw_test(String str) {
		
		String enc = passwordEncoder.encode(str);
		boolean res = passwordEncoder.matches(str, enc);
		
		System.out.println(str);
		System.out.println(enc);
		System.out.println(res);
		
	}
	
}
