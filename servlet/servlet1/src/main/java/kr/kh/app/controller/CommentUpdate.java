package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/comment/update")
public class CommentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cm_id = request.getParameter("cm_id");
		String cm_content = request.getParameter("cm_content");

		JSONObject jobj = new JSONObject();
		
		try {
			int cmid = Integer.parseInt(cm_id);
			System.out.println(cmid);
			
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			System.out.println(user + ": user");
			
			
			CommentVO comment = new CommentVO(cmid, cm_content);
			System.out.println(comment);
			
			
			boolean res = postService.updateComment(comment, user);
			System.out.println(res);
			
			
			
			jobj.put("result", res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}
	
	

}
