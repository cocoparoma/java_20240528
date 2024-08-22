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

@WebServlet("/comm/detail")
public class CommDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get
		String po_id = request.getParameter("po_id");
		String co_id = request.getParameter("co_id");
		PostVO post = postService.getPost(po_id);

		
		
		
		// fu
		postService.addViewPoint(post.getPo_id());
		
		
		
		
		
		
		// set
		request.setAttribute("post", post);
		request.setAttribute("co_id", co_id);
		request.getRequestDispatcher("/WEB-INF/views/comm/detail.jsp").forward(request, response);
	}

}
