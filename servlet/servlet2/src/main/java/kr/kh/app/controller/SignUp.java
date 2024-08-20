package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.backend.Sender;

import kr.kh.app.model.dto.SignUpDTO;
import kr.kh.app.service.UserService;
import kr.kh.app.service.UserServiceImp;


@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImp();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get Parameter
		String me_id = request.getParameter("me_id");
		String me_pw = request.getParameter("me_pw");
		String me_pw2 = request.getParameter("me_pw2");
		String me_email = request.getParameter("me_email");
		
		String id_ch = request.getParameter("id_ch");
		System.out.println("id_ch :" + id_ch);
		// 아이디 확정을 받지 않았다면
		if (!id_ch.equals("good")) {
			System.out.println("아이디 중복체크 미적용");
			throw new RuntimeException();
		}
		
		// input var
//		System.out.println("id : "+me_id);
//		System.out.println("pw : "+me_pw);
//		System.out.println("pw2 : "+me_pw2);
//		System.out.println("email : "+me_email);
		
		
		
		try {


			
			
			// 정보를 넘길 때 객체상태로 감싸서 주는 것을 추천합니다
			SignUpDTO userDto = new SignUpDTO(me_id, me_pw, me_email);
			
			// pw1 != pw2 일시 catch로 넘김
			if (!me_pw.equals(me_pw2)) {
				System.out.println("me_pw != me_pw2");
				throw new RuntimeException();
			}
			
			//service에서 Regex 검사
			boolean res = userService.signup(userDto);
			if (res) {
				System.out.println("send msg : success-msg");
				request.setAttribute("msg", "회원가입에 성공하였습니다.");
				request.setAttribute("url", "/");
			} else {
				System.out.println("res = false");
				throw new RuntimeException();
			}
			
			
		} catch (Exception e) {
			
			
			// 어떤 이유로든 실패시 실패 이유와 함께 catch 방문
			System.out.println("send msg : fail-msg");
			request.setAttribute("msg", "회원가입에 실패하였습니다.");
			request.setAttribute("url", "/signup");
			e.printStackTrace();
		}
		
		// send msg
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

}
