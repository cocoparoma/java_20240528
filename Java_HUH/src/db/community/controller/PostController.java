package db.community.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import db.community.model.vo.CommentVO;
import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;
import db.community.pagination.Criteria;
import db.community.pagination.PageMaker;
import db.community.service.PostService;
import db.community.service.PostServiceImp;

public class PostController {
	
	
	private PostService postService = new PostServiceImp();
	private Scanner scan;
	
	
	
	public PostController(Scanner scan) {
		this.scan = scan;
	}



	public void insertCommunity() {
		System.out.print("커뮤니티 생성\n>>");
		String coName = scan.nextLine();
		
		if (postService.insertCommunity(coName)) {
			System.out.println("커뮤니티 생성 완료");
		} else {
			System.out.println("커뮤니티 생성 실패");
		}
		
	}



	public void updateCommunity() {
		System.out.print("커뮤니티 업데이트\n수정하려는 커뮤니티 명\n>>");
		String oldCoName = scan.nextLine();
		System.out.println(oldCoName);
		System.out.print("새로운 커뮤니티 명\n>>");
		String newCoName = scan.nextLine();
		System.out.println(newCoName);
		
		if (postService.updateCommunity(oldCoName, newCoName)) {
			PrintController.printBar();
			System.out.println("커뮤니티 수정 완료");
		} else {
			PrintController.printBar();
			System.out.println("커뮤니티 수정 실패");
		}
		
		
	}



	public void deleteCommunity() {
		System.out.print("삭제하려는 커뮤니티 명\n>>");
		String coName = scan.nextLine();
		System.out.println(coName);
		if (postService.deleteCommunity(coName)) {
			PrintController.printBar();
			System.out.println("커뮤니티 삭제 완료");
		} else {
			PrintController.printBar();
			System.out.println("커뮤니티 삭제 실패");
		}
		
		
	
		
		
	}



	public void insertPost(String meid) {
		//커뮤니티 출력 (기본키, 이름)
		
		//서비스에게 커뮤니티 리스트 요청
		List<CommunityVO> list = postService.getCommunityList();
		for (CommunityVO community : list) {
			System.out.println(community);
		}
		
		//커뮤니티 번호를 입력
		String co_id = scan.nextLine();
		int coid;
		try {
			coid = Integer.parseInt(co_id);
		} catch (Exception e) {
			System.out.println("숫자가 아닙니다.");
			return;
		}
		//제목 입력
		String title = scan.nextLine();
		//내용입력
		String content = scan.nextLine();
		
		//커뮤니티 번호, 제목, 내용, 작성자를 통해 게시글 vo를 작성
		PostVO post = new PostVO(coid,title,content,meid);
		if (postService.insertPost(post)) {
			PrintController.printBar();
			System.out.println("포스트 완료");
		} else {
			PrintController.printBar();
			System.out.println("포스트 실패");
		}
		
	}



	public void printCommunityList() {
		List<CommunityVO> list =postService.getCommunityList();
		
		for (CommunityVO community : list) {
			System.out.println(community);
		}
		
		
	}



	public void printPostList(Criteria cri) {
		List<PostVO> list = null;
		
		try {
		
			list = postService.getPostList(cri);
			
		} catch (Exception e) {
			PrintController.printBar();
			System.out.println("없는 커뮤니티 입니다.");
			e.printStackTrace();
			return;
		}
		
		if (list.size() == 0) {
			System.out.println("게시글이 없습니다.");
			return;
		}
		
		for(PostVO post : list){
			System.out.println(post);
		}
		
	}



	public PostVO printPostDetail() {

		System.out.println("번호 : ");
		String co_id = scan.nextLine();
		int co_idint = 0;
		try {
			co_idint = Integer.parseInt(co_id);
			
			// 서비스에게 조회수 증가 요청
			postService.updatePostView(co_idint);
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			return null;
		}
		
		if (co_id.length() == 0 || co_id == null) {
			return null;
		}
		
		PostVO post = postService.getPost(co_idint);
		
		if (post != null) {
			post.print();
			System.out.print("넘어가기 : enter\n>>");
			String y = scan.nextLine();
		} else {
			System.out.println("없는 게시글");
		}
		
		return post;
	}



	public PageMaker getPageMaker(Criteria cri, int maxValue) {
		int totalCount = postService.selectPostListTotalCount(cri);
		return new PageMaker(maxValue, maxValue, cri);
	}



	public boolean deletePost(int po_id) {
		
		return postService.deletePost(po_id);
	}



	public boolean updatePost(int po_id) {
		System.out.print("수정할 제목\n>>");
		String title = scan.nextLine();
		
		System.out.print("수정할 내용\n>>");
		String content = scan.nextLine();
		
		PostVO post = new PostVO(po_id, title, content);
		
		return postService.updatePost(post);
	}



	public void insertComment(PostVO post, String id) {
		if (post == null || id.length() ==0 || id == null) {
			System.out.println("댓글을 추가할 수 없습니다.");
			return;
		}
		
		System.out.print("댓글\n>>");
		String comment = scan.nextLine();
		
		if (comment.length() == 0 || comment ==null) {
			return;
		}
		
		CommentVO co = new CommentVO(post.getPo_id(),id, comment);
		
		if (postService.insertComment(co)) {
			System.out.println("댓글 입력 완료");
		} else {
			System.out.println("댓글 입력 실패");
		}
		
	}



	public void printCommentList(PostVO post) {
		if (post == null) {
			return;
		}
		List<CommentVO> list = null;
		try {
			list = postService.getCommentList(post.getPo_id());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록되지 않았거나, 삭제된 게시글 입니다.");
		}
		
		if (list.size() == 0) {
			System.out.println("댓글이 없습니다.");
			return;
		}
		System.out.println("댓글 목록");
		for (CommentVO co : list){
		 	System.out.println(co);
		}
		System.out.print("plz press the Enter\n>>");
		scan.nextLine();
		PrintController.printBar();
	}




}
