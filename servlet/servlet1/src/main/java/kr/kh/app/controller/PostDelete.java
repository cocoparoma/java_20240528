package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;



@WebServlet("/post/delete")
public class PostDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String po_idstr = request.getParameter("po_id");
		PostVO post = null;
		try {
			int po_id = Integer.parseInt(po_idstr);
			
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			
			post = postService.getPost(po_id);
			
			if (postService.deletePost(po_id, user)) {
				request.setAttribute("msg", "게시글 삭제 성공");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "게시글 삭제 실패하였습니다.");
		}
		
		request.setAttribute("url", "/post/list?co_id=" + post.getPo_co_id());
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}


}
