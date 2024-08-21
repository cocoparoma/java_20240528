package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.node.BooleanNode;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.UserVO;
import kr.kh.app.service.UserService;
import kr.kh.app.service.UserServiceImp;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImp();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get Parameter
		String me_id = request.getParameter("me_id");
		String me_pw = request.getParameter("me_pw");
		
		// input var
		System.out.println("login-me_id:"+me_id);
		System.out.println("login-me_pw:"+me_pw);
		
		// loginDTO 
		LoginDTO userDto = new LoginDTO(me_id, me_pw);
		
		// 유저 정보 확인
		UserVO user = userService.getUser(userDto);

		// 유저가 존재하면
		if (user != null) {
			request.setAttribute("msg", "안녕하세요, "+ user.getMe_id() + "님 접속을 환영합니다.");
			request.setAttribute("url", "/");
			
			// 세션에 저장해야함 - 로그인토큰 
			// UserVO user 를 user라는 이름으로 세션에 저장 (전방향 사용가능한 Static 같음)
			userService.idSuccessFailReturnZero(user);
			
			request.getSession().setAttribute("user", user);
		} else {
			// 실패시 + 아이디가 있는데 실패시
			UserVO userVO = userService.findUserByID(me_id);
			
			if (userVO != null) {
				userService.idFailAdd1(userVO);
				request.setAttribute("msg", "로그인에 실패하였습니다. 비밀번호를 확인해 주세요");
				request.setAttribute("url", "/login");
			} else {
				request.setAttribute("msg", "로그인에 실패하였습니다. 아이디와 비밀번호를 확인해 주세요");
				request.setAttribute("url", "/login");
			}
			
			
		}
		
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

}
