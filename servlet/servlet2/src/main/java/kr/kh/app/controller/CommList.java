package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/comm/list")
public class CommList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//커뮤니티 아이디 받아오기
		String co_id = request.getParameter("co_id");
		String type = request.getParameter("type");
		String q = request.getParameter("q");//text임
		
		//페이지네이션 해야함 도전하셈
		
		
		
		CommVO comm = postService.getComm(co_id);
		System.out.println(comm); // 커뮤니티 정보까지 받아왔음
		System.out.println(type); //검색타입
		System.out.println(q); // 검색할 문자열
		
		
		// 들어갈 내용 co_id, type, q, startPage, endPage, limit개수, nowPage까지
//		List<PostVO> list = postService.getPostList();
		
		
		
		request.setAttribute("co", comm);
		request.getRequestDispatcher("/WEB-INF/views/comm/list.jsp").forward(request, response);
	}


}
