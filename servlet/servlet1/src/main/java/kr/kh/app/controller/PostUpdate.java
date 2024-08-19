package kr.kh.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.service.PostService;
import kr.kh.app.service.PostServiceImp;


@WebServlet("/post/update")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10, //10Mb
		maxRequestSize = 1024 * 1024 * 10 * 3,
		fileSizeThreshold = 1024 * 1024
	)
public class PostUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService postService = new PostServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String po_idstr = request.getParameter("po_id");
		System.out.println("insert update menu" + po_idstr);
		
		try {
			
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			int poId = Integer.parseInt(po_idstr);
			
			
			PostVO post = postService.getPost(poId, user);
			
			
			
			
			
			
			
			
			
			if (post != null) {
				
				List<FileVO> fileList = postService.getFileList(poId);
				
				request.setAttribute("fileList", fileList);
				request.setAttribute("post", post);
				request.getRequestDispatcher("/WEB-INF/views/post/update.jsp").forward(request, response);
			} else {
				throw new RuntimeException();
			}
			
			
			
		} catch (Exception e) {

		
			request.setAttribute("msg", "작성자가 아니거나 잘못된 게시글 입니다.");
			request.setAttribute("url", "/post/detail?po_id="+po_idstr);
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
						
		}
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String po_idstr = request.getParameter("po_id");
		
		try {
			
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			int poId = Integer.parseInt(po_idstr);

			
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			
			PostVO post = new PostVO(poId, name, content);	
			
			
			
			// 추가할 파일을 가져옴
			List<Part> fileList = (List<Part>)request.getParts();
			
			String idStr [] = request.getParameterValues("fi_id");
			
	
			
			if (postService.updatePost(post, user, fileList, idStr)){
				request.setAttribute("msg", "게시글 업데이트 성공.");
			} else {
				throw new RuntimeException();
			}

			
		} catch (Exception e) {
			request.setAttribute("msg", "게시글 수정에 실패하였습니다.");
		}
		request.setAttribute("url", "/post/detail?po_id="+po_idstr);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
