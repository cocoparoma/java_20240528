package db.community.controller;

import java.util.List;
import java.util.Scanner;


import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;
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




}
