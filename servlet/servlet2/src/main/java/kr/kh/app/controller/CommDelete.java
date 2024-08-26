package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.UserVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/comm/delete")
public class CommDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get
		String co_id = request.getParameter("co_id");
		String po_id =request.getParameter("po_id");
		UserVO user = (UserVO)request.getSession().getAttribute("user");
		PostVO post = postService.getPost(po_id);
		
		// test
//		if (true) {
//			System.out.println("delete page : "+co_id);
//			System.out.println("delete page : "+po_id);
//			System.out.println("delete page : "+user);
//			System.out.println("delete page : "+post);
//		}
		
		// fn
		
		boolean res = postService.removePost(post, user);
		
		//set
		if (res) {
			request.setAttribute("msg", "해당 페이지가 삭제되었습니다.");
			request.setAttribute("url", "/comm/list?co_id="+co_id);
		} else {
			request.setAttribute("msg", "해당 페이지 삭제에 실패하였습니다.");
			request.setAttribute("url", "/comm/list?co_id="+co_id);
		}
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}



}
