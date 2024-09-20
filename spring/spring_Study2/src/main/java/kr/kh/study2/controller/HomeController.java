package kr.kh.study2.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
	private JavaMailSender mailSender;
	
	
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
		
		//메일전송 테스트
//		mailSend("bnbz201@naver.com", "메일 테스트", "전송이 잘 되었습니다.");//이메일 아이디와 비번을 안적어서 테스트 안됨
		
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
	
	
	public boolean mailSend(String to, String title, String content) {

	    String setfrom = "stajun@naver.com"; //의미 없으나 필요함
	   try{
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom(setfrom);// 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(to);// 받는사람 이메일
	        messageHelper.setSubject(title);// 메일제목은 생략이 가능하다
	        messageHelper.setText(content, true);// 메일 내용

	        mailSender.send(message);
	        return true;
	    } catch(Exception e){
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	
	
	
}
