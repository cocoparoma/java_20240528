package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/detail")
public class PostDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 번호를 가져옴
		String idStr = request.getParameter("po_id");
		System.out.println(idStr);
		try {
			int id = Integer.parseInt(idStr);
			

			postService.updatePostView(id);

			// 서비스에게 가져온 게시글 번호에 맞는 게시글 정보를 가져오라고 시킴
			PostVO post = postService.getPost(id);
			// 게시글 화면에 전송
			request.setAttribute("post", post);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/views/post/detail.jsp").forward(request, response);
	}


}
