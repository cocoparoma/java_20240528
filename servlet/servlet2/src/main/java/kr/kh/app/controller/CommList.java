package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.pagination.PostCriteria;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/comm/list")
public class CommList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImp();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// -- 값 받아오는 구역
		//커뮤니티 아이디 받아오기
		String co_id = request.getParameter("co_id");
		//검색 타입
		String type = request.getParameter("type");
		//검색어 cri에서는 search 로 들어감
		String q = request.getParameter("q");//text임
		//현제 페이지 처음에 정보가 없으면 1로 들어감 cri 세팅에 그리 되어있음
		String page = request.getParameter("page");
		//커뮤니티 정보 (커뮤니티 id, name)
		CommVO comm = postService.getComm(co_id);
		
		
		
		
		
		
		// -- 값 처리
		// 기본 정보 수정
		if (type == null) {
			type = "all";
		}
		
		
		
		
		
		
		
		// 페이지네이션 해야함 도전하셈
		// Criteria = 기준이라는 뜻임, PostCriteria 즉 지금 현제 보여주고있는 페이지를 기준으로  삼아주기위한
		// 페이지의 정보를 저장해서 기록해 줌
		// 들어갈 내용 co_id, type, q, startPage, endPage, limit개수, nowPage까지
		// 마지막 숫자가 perPageNum : 화면에 보여줄 페이지 개수임 10개 기본값인데 5개로 설정 바꾸면서 들어감
		// cri만 찍으면 안나오는데 가지고 있는 정보로는 pageStart, PerPageNum 등 가지고 있음
		// pageStart, PerPageNum 등등 정보는 jsp에서 가져와야 하는지 확인해보셈
		Criteria cri = new PostCriteria(co_id, page, q, type, 10);
		//cri에 데이터가 많으니까 해당 정보를 주면서 list를 가져오자
		List<PostVO> list = postService.getPostList(cri);
		
		// 페이지 메이커
		// pm안에 cri가 있어서 pm 보내면 안에 있음
		//우리가 챙겨야할 것 totalCount(db에서 가져오기), displayPageNum(마음가는대로 지정) cri = 현제 페이지 정보 다 때려넣으셈
		PageMaker pm = postService.getPageMaker(cri);

		
		
		
		
		
		
		
		
		// -- 값 테스트 구역
		if (true) {
		System.out.println(comm); // 커뮤니티 정보까지 받아왔음
		System.out.println(type); //검색타입
		System.out.println(q); // 검색할 문자열
		System.out.println(page);
		System.out.println(cri);
		System.out.println(cri.getSearch());
		System.out.println(cri.getPageStart());
		System.out.println(cri.getPerPageNum());
		System.out.println(list);
		System.out.println("pm : " + pm);
		}
			
		
		

		
		
		
		// -- 파일 전송 구역
		// 보낼 것 다 보냄 jsp 에서 가서 나머지 처리해주면 됨
		request.setAttribute("list", list);
		request.setAttribute("co", comm);
		request.setAttribute("pm", pm);
		request.getRequestDispatcher("/WEB-INF/views/comm/list.jsp").forward(request, response);
	}


}
