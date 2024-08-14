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


@WebServlet("/comment/insert")
public class CommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String po_id = request.getParameter("cm_po_id");
		String content = request.getParameter("cm_content");
		String ori_id = request.getParameter("cm_ori_id");
		
		JSONObject jobj = new JSONObject();

		
		try {
			int cm_po_id = Integer.parseInt(po_id);
			int cm_ori_id = Integer.parseInt(ori_id);
			
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			String cm_me_id = user.getMe_id();
			
			System.out.println(cm_me_id);
			
			CommentVO comment = new CommentVO(cm_po_id, cm_ori_id, content, cm_me_id);			
			boolean res = postService.insertComment(comment);
			
			
			jobj.put("result", res);
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jobj);
	}

}
