package kr.kh.boot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import kr.kh.boot.dao.PostDAO;



@Controller
public class MainController {
	
	@Autowired
	private PostDAO postDao;
	
	@GetMapping("/")
	public String home(Model mo, HttpSession session) {
		
		mo.addAttribute("count", postDao.count());
		mo.addAttribute("sid", session.getId());
		mo.addAttribute("name", "홍길동");
		return "index";
	}


	@GetMapping("/index2")
	public String home2(Model mo, HttpSession session) {
			
		mo.addAttribute("sid", session.getId());
		mo.addAttribute("name", "홍길동");
		return "index2";
	}
}
