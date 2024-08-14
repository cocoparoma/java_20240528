package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/comment/delete")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("connected");
		JSONObject jobj = new JSONObject();
		
		String poid = request.getParameter("po_id");
		String meid = request.getParameter("me_id");
		String cmid = request.getParameter("cm_id");
		
		System.out.println(poid + "//" + meid + "//"+ cmid );
		try {
			int co_id = Integer.parseInt(cmid);
			
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			boolean res = postService.deleteComment(co_id , user);
			jobj.put("result", res);
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}

}
