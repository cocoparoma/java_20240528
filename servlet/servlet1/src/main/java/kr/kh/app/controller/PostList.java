package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.pagination.PostCriteria;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/list")
public class PostList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int coId = 0;
		try {
			coId = Integer.parseInt(request.getParameter("co_id"));
//			System.out.println(coId);
			
			String pageStr = request.getParameter("page");
			
			int page=1;
			if (pageStr != null && pageStr.length() != 0) {
				page = Integer.parseInt(pageStr);
			}
			// 커뮤니티 번호를 주면서 커뮤니티 정보를 가지고 오라고 시킴
			CommunityVO community = postService.getCommunity(coId);
			
			if (community == null) {
				throw new Exception();
			}
			
			Criteria cri = new PostCriteria(page, 2, "", coId);
			
			PageMaker pm = postService.getPageMaker(cri, 2);
			
			request.setAttribute("co", community);
			
			List<PostVO> list = postService.getPostList(cri);
			
			if (list == null) {
				return;
			}
			
			request.setAttribute("list", list);
			request.setAttribute("pm", pm);
					
			request.getRequestDispatcher("/WEB-INF/views/post/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "잘못된 커뮤니티 입니다.");
			request.setAttribute("url", "/community");
			
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			
		}
		
		
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
