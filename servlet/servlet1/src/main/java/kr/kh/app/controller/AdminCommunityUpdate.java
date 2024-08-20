package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.AdminService;
import kr.kh.app.service.AdminServiceImp;

@WebServlet("/admin/community/update")
public class AdminCommunityUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminService adminService = new AdminServiceImp();   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 커뮤니티 번호를 가져옴
		String co_idStr = request.getParameter("co_id");
		// 수정될 커뮤니티 명
		String co_name = request.getParameter("co_name");
		System.out.println(co_idStr + co_name);
		try {
			int co_id = Integer.parseInt(co_idStr);
			MemberVO admin = (MemberVO)request.getSession().getAttribute("user");
			
			if (adminService.updateCommunity(co_id, co_name, admin)) {
				request.setAttribute("msg", "커뮤니티 업데이트 성공");
			} else {
				
				
				throw new RuntimeException();				
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "커뮤니티 업데이트 실패");
		}
		request.setAttribute("url", "/admin/community");
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
