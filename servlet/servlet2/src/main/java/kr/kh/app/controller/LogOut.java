package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.UserVO;
import kr.kh.app.service.UserService;
import kr.kh.app.service.UserServiceImp;


@WebServlet("/logout")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImp();	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원의 쿠키 정보를 업데이트 null로
		UserVO user = (UserVO)request.getSession().getAttribute("user");
		if(user != null) {
			user.setMe_cookie(null);
			userService.updateMemberCookie(user);
		}
		
		//세션에 있는 회원 정보를 지움
		request.getSession().removeAttribute("user");
		
		//알림
		request.setAttribute("msg", "로그아웃 완료.");
		request.setAttribute("url", "/");
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

}
