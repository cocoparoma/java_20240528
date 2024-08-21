package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.dto.CommListDTO;
import kr.kh.app.model.vo.CommVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;

// 커뮤니티 상황판
@WebServlet("/comm")
public class Comm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 리스트 가져오기
		// 리스트에다가 카운터까지 가져오기
		List<CommListDTO> coList = postService.getCommDTOList();
		System.out.println(coList);		
		

		// jsp에 전달 ("colist" 라는 이름으로 colist를 전달)
		request.setAttribute("coList", coList);
		
		
		request.getRequestDispatcher("/WEB-INF/views/comm/comm.jsp").forward(request, response);
	}


	

}
