package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.service.AdminService;
import kr.kh.app.service.AdminServiceImp;



@WebServlet("/admin/community/insert")
public class AdminCommunityInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminServiceImp();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String co_name = request.getParameter("co_name");

		if (adminService.insertCommunity(co_name)) {
			request.setAttribute("url", "/admin/community");
			request.setAttribute("msg", "커뮤니티 등록 성공");
		} else {
			request.setAttribute("url", "/admin/community");
			request.setAttribute("msg", "커뮤니티 등록 실패");
		}
		
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}
	

}