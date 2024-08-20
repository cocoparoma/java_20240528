package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.kh.app.model.vo.UserVO;
import kr.kh.app.service.UserService;
import kr.kh.app.service.UserServiceImp;


@WebServlet("/check/id")
public class CheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameter, json object mk
		String me_id = request.getParameter("me_id");
		
		JSONObject jobj = new JSONObject();
		
		System.out.println("me_id : " + me_id);
		
		UserVO user = userService.findUserByID(me_id);
		
		boolean res = false;
		
		if (user == null) {
			res = true;
		}
		
		
		// res 데이터를 result라는 이름으로 보냄
		jobj.put("result", res);
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}


}
