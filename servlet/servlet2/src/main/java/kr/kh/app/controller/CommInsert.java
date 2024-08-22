package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.filter.UserFilter;
import kr.kh.app.model.vo.CommVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.UserVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/comm/insert")
public class CommInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get
		String co_id = request.getParameter("co_id");
		CommVO comm = postService.getComm(co_id);
		
		
		
		
		// test
		if (true) {

		}
		
		
		
		
		
		// set
		request.setAttribute("co", comm);
		request.getRequestDispatcher("/WEB-INF/views/comm/insert.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get
		String co_id = request.getParameter("co_id");
		CommVO comm = postService.getComm(co_id);
		String po_name = request.getParameter("name");
		String po_content = request.getParameter("content");
		UserVO user = (UserVO)request.getSession().getAttribute("user");
		
		
		// test
		if (true) {
			System.out.println(co_id);
			System.out.println(po_name);
			System.out.println(po_content);
			System.out.println(user);
		}
		
		
		
		
		// fn 
		PostVO post = new PostVO(po_name, po_content, user.getMe_id(),comm.getCo_id());
		
		boolean res = postService.setPost(post);
		
		
		
		

		
		
		
		
		
		
		
		// set
		
		if (res) {
			request.setAttribute("msg", "제목 : " + po_name + "에 해당하는 게시글 작성에 성공하였습니다.");
			request.setAttribute("url", "/comm/list?co_id="+co_id);
		} else {
			request.setAttribute("msg", "게시글 작성에 실패하였습니다.");
			request.setAttribute("url", "/comm/list?co_id="+co_id);
		}
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

}
