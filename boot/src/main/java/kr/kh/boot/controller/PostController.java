package kr.kh.boot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.boot.model.vo.CommunityVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.pagination.PageMaker;
import kr.kh.boot.pagination.PostCriteria;
import kr.kh.boot.service.PostService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PostController {
	
	private PostService postService;
	
	@GetMapping("/post/list/{co_id}")
	public String postList(@PathVariable int co_id, Model mo, PostCriteria cri) {
		cri.setCo_id(co_id);
		cri.setPerPageNum(4);
		//커뮤니티 번호에 맞는 게시글 목록을 가져와서 화면에 전달
		List<PostVO> list = postService.getPostList(cri);
		//커뮤니티 목록을 가져와서 화면에 전달
		List<CommunityVO> community_List = postService.getCommunityList();
		//현재 페이지 정보를 이용해서 페이지메이커를 가져와서 화면에 전달
		PageMaker pm = postService.getPageMaker(cri);
		
		mo.addAttribute("pm", pm);
		mo.addAttribute("list", list);
		mo.addAttribute("colist", community_List);
		return "post/list";
	}
	
	@GetMapping("/post/detail/{po_id}")
	public String postDetail(@PathVariable int po_id, Model mo) {
		//먼저 조회수를 늘려줌 (없음 말고 식)
		postService.addPostViewPoint(po_id);
		
		//조회수가 이미 늘어난 포스트 받아오고
		PostVO post = postService.getPostById(po_id);
		
		//포스트 화면으로 넘겨줌
		mo.addAttribute("post", post);
		return "post/detail";
	}
}
