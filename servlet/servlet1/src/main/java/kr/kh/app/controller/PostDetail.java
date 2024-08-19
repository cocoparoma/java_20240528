package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

@WebServlet("/post/detail")
public class PostDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 번호를 가져옴 // id = po_id 이거 수정 해야할듯 햇갈림
		String idStr = request.getParameter("po_id");
		try {
			int id = Integer.parseInt(idStr);
			System.out.println(id);

			postService.updatePostView(id);

			// 서비스에게 가져온 게시글 번호에 맞는 게시글 정보를 가져오라고 시킴
			PostVO post = postService.getPost(id);
			System.out.println(post);
			// 게시글 화면에 전송
			
			
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			RecommendVO recommend = postService.getRecommend(id, user);
			
			List<FileVO> fileList = postService.getFileList(id);
			request.setAttribute("fileList", fileList);
			
			
			
			request.setAttribute("post", post);
			request.setAttribute("re", recommend);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/views/post/detail.jsp").forward(request, response);
	}


}
