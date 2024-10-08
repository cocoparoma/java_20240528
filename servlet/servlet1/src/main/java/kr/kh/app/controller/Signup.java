package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;


@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		
		LoginDTO member = new LoginDTO(id, pw, email);
		
		if (memberService.signup(member)) {
			request.setAttribute("msg", "회원가입에 성공하였습니다.");
			request.setAttribute("url", "/");
//			response.sendRedirect(request.getContextPath()+"/");
		} else {
			request.setAttribute("msg", "회원가입~ 실패!");
			request.setAttribute("url", "/");
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}

}
