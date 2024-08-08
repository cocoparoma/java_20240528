package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = "";
		id = request.getParameter("id");
		String pw = "";
		pw = request.getParameter("pw");
		
		
		MemberVO user = memberService.getUser(id, pw);
		
		if (user == null) {
			request.setAttribute("msg", "로그인 땡");
			request.setAttribute("url", "/login");
		} else {
			request.setAttribute("msg", "로그인 정답");
			request.setAttribute("url", "/");
			
			// 세션에 로그인 정보를 저장(로그인토큰)
			request.getSession().setAttribute("user", user);
			
		}
		
		
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
