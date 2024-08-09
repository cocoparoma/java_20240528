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


@WebServlet("/content")
public class Content extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int poId = 0;
		
		try {
			poId = Integer.parseInt(request.getParameter("po_id"));
			System.out.println(poId);
			
			
			PostVO po = postService.getPost(poId);
			
			if (po == null) {
				return;
			}
			
			request.setAttribute("po", po);
			
			
			
			
			
			request.getRequestDispatcher("/WEB-INF/views/post/content.jsp").forward(request, response);
			
		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("msg", "잘못된 게시글 입니다.");
			request.setAttribute("url", "/post/list");
			
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
