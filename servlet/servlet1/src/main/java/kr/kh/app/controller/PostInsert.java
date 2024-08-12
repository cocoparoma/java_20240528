package kr.kh.app.controller;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/post/insert")
public class PostInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String coIdStr = request.getParameter("co_id");
		
		try {
			int coId = Integer.parseInt(coIdStr);
			request.setAttribute("co_id", coId);
			request.getRequestDispatcher("/WEB-INF/views/post/insert.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "잘못된 커뮤니티 입니다.");
			request.setAttribute("url", "/community");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String coIdStr = request.getParameter("co_id");
		
		try {
			int coId = Integer.parseInt(coIdStr);
			
			//화면에서 제목을 가져옴
			String title = request.getParameter("title");
			//화면에서 내용을 가져옴
			String content = request.getParameter("content");
			//가져온 회원 정보가 있으면 아이디를 가져옴
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			
			if (user == null) {
				throw new RuntimeException();
			}
			String id = user.getMe_id();
			
			//가져온 커뮤니티 ,번호 , 내용을 이용해서 게시글 객체를 생성			
			PostVO post = new PostVO(coId, title, content, id);
			
			if (postService.insertPost(post)) {
				
				
				request.setAttribute("msg", "게시글 등록 성공");
				request.setAttribute("url", "/post/list?co_id="+coId);
				
			} else {
				throw new RuntimeException();
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "게시글 등록 실패");
			request.setAttribute("url", "/post/list?co_id="+coIdStr);

		}		
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
