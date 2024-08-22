package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.UserVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/comm/update")
public class CommUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get
		String co_id = request.getParameter("co_id");
		String po_id = request.getParameter("po_id");
		CommVO comm = postService.getComm(co_id);
		PostVO post = postService.getPost(po_id);
		
		
		
		
		// test
		
		
		

		// fn
		
		// set
		request.setAttribute("co", comm);
		request.setAttribute("po", post);
		request.getRequestDispatcher("/WEB-INF/views/comm/update.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get
		String co_id = request.getParameter("co_id");
		String po_id = request.getParameter("po_id");
		
		
		CommVO comm = postService.getComm(co_id);
		PostVO post_oid = postService.getPost(po_id);
		
		
		String po_name = request.getParameter("name");
		String po_content = request.getParameter("content");
		

		UserVO user = (UserVO)request.getSession().getAttribute("user");// get user

		
		// test
		if (true) {
			
		}
		
		
		
		// fn
		
		try {
		boolean res = false;
		
		
		// 로그인 안되있으면 
		if (user == null) {
			System.out.println("user null err");
			throw new RuntimeException();
		}
		
		// ! 이름이 같지 않으면
		if (!post_oid.getPo_me_id().equals(user.getMe_id())) {
			System.out.println("user did not match err");
			throw new RuntimeException();
		}
		
		

		
		PostVO post_new = null;
		
		post_new = new PostVO( post_oid.getPo_id() ,po_name, po_content);
		
		res = postService.modifyPost(post_new);



		
		
		
		// set
		
		if (res) {
			request.setAttribute("msg", "제목 : " + po_name + "에 해당하는 게시글 수정에 성공하였습니다.");
			request.setAttribute("url", "/comm/detail?co_id="+co_id+"&po_id="+po_id);
		} else {
			request.setAttribute("msg", "게시글 수정에 실패하였습니다.");
			request.setAttribute("url", "/comm/detail?co_id="+co_id+"&po_id="+po_id);
		}
		
		

			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "게시글 수정에 오류로 인해 실패하였습니다.");
			request.setAttribute("url", "/comm/detail?co_id="+co_id+"&po_id="+po_id);
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		}
		
		
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

}
