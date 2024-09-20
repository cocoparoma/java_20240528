package kr.kh.study2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.study2.dao.PostDAO;


@Controller
public class HomeController {
	
	@Autowired
	private PostDAO postDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/")
	public String home(Model mo) {
		//DB연동 확인용
		System.out.println("DB동작 여부 판별 : " + postDao.count());
		
		//암호화 동작 여부
		String str = "test";
		String enc = passwordEncoder.encode(str);
		
		System.out.println("암호화 이전 문자열 : " + str);
		System.out.println("암호화 된 문자열 : " + enc);
		System.out.println("암호화 된 문자열 일치 여부(abc) :" + passwordEncoder.matches("abc", enc));
		System.out.println("암호화 된 문자열 일치 여부(test) :" + passwordEncoder.matches("test", enc));
		
		return "/home";
	}
	
	@GetMapping("/post/list")
	public String postList(Model mo) {
		//DB연동 확인용
		System.out.println(postDao.count());
		return "/home";
	}
	
	@GetMapping("/post/detail")
	public String postDetail(Model mo) {
		//DB연동 확인용
		System.out.println(postDao.count());
		return "/home";
	}
	
	
	@GetMapping("/post/insert")
	public String postInsert(Model mo) {
		//DB연동 확인용
		System.out.println(postDao.count());
		return "/home";
	}
	
	
	
	
	
	
	
	
}
