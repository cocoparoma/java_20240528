package db.community.main;

import java.util.Scanner;

import javax.naming.directory.SearchControls;

import db.community.controller.MemberController;
import db.community.controller.PostController;
import db.community.controller.PrintController;
import db.community.model.vo.MemberVO;
import db.community.model.vo.PostVO;
import db.community.pagination.Criteria;
import db.community.pagination.PageMaker;
import db.community.pagination.PostCriteria;
import program.program;

public class ProgramImp implements program {

	private Scanner scan = new Scanner(System.in);
	private MemberController memberController = new MemberController(scan);
	private PostController postController = new PostController(scan);
	private MemberVO member = null;

	@Override
	public void run() {

		String M;

		while (true) {
			printMenu();

			M = scan.nextLine();

			try {
				int k = Integer.parseInt(M);
				PrintController.printBar();
				runMenu(k);

				PrintController.printBar();

			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
						
			if (M.equals("3")) {
				break;
			}
		}

	} // run done

	@Override
	public void runMenu(int M) throws Exception {

		switch (M) {
		case 1:
			login();
			break;
		case 2:
			signUp();
			break;
		case 3:
			System.out.println("프로그렘 종료");
			break;
		default:
			PrintController.wrongMenu();
		}

	}// runMenu done

	@Override
	public void printMenu() {
		PrintController.printMainMenu();

	}// printMenu done

	private void login() {
		// 회원 정보를 입력받아 회원 정보와 일치하는 회원의 정보를 가져옴
		member = memberController.login();
		System.out.println(member);

		// 없으면
		if (member == null) {
			PrintController.loginFail();
			return;
		}

		// 관리자 라면
		if (member.getMe_authority().equals("ADMIN")) {
			admin();
			return;
		}

		// 회원이라면
		user();
	}// login done

	private void user() {
		PrintController.printBar();
		System.out.println(member.getMe_id() + "님 환영합니다.");
		PrintController.printBar();

		while (true) {
			PrintController.printUserMenu();
			String M = scan.nextLine();
			
			runUser(M);
			
			if (M.equals("3")) {
				break;
			}
		}
	} // user done

	private void runUser(String m) {
		
		if (m.equals("1")) postController.insertPost(member.getMe_id());
		else if (m.equals("2")) Search();
		else if (m.equals("3"));
		else;
		
	}

	private void Search() {
		
		String search = "";
		
		String M = "0";
		
		postController.printCommunityList();
		PrintController.printBar();
		System.out.print("커뮤니티 번호 선택\n>>");
		String N = scan.nextLine();
		
		int coNum = Integer.parseInt(N);	
		Criteria cri = new PostCriteria(1, "", coNum);
		cri.setPerPageNum(2);
		while(true) {
			System.out.println(cri.getPage() + ": 결과 페이지");
			PageMaker pm = postController.getPageMaker(cri, Integer.MAX_VALUE);
			
			// 컨트롤러가 검색어에 맞는 게시글 리스트를 출력
			postController.printPostList(cri);
			// 메뉴를 출력
			PrintController.printPostMenu();
			
			M = scan.nextLine();
			
			runPostMenu(M, pm);
			
			if (M.equals("5")) {
				break;
			}
			
			
		}
		
	}

	private void runPostMenu(String M, PageMaker pm) {
		if (M.equals("1")) {
			page(pm, -1);
		} else if (M.equals("2")) {
			page(pm, 1);
		} else if (M.equals("3")) {
			
		} else if (M.equals("4")) {
			detail();
		} else if (M.equals("5")) {
			PrintController.prev();
		} else {
			PrintController.wrongMenu();
		}
		
	}

	private void detail() {
		PostVO post = postController.printPostDetail();
		PrintController.printBar();
		
		if (post == null) {
			return;
		}
		
		String M = "0";
		while (true) {
			PrintController.printPostSubMenu(post.getPo_me_id().equals(member.getMe_id()));
			M = scan.nextLine();
			PrintController.printBar();
			
			runPostSubMenu(M, post);
			PrintController.printBar();
			
			// 게시글 삭제시 더 이상 머물 필요가 없어지기에 
			if (post.getPo_id() == 0) {
				break;
			}
			
			if (M.equals("3")) {
				break;
			}
		}
	}

	private void runPostSubMenu(String m, PostVO post) {
		switch (m) {
		case "1":
			postController.printCommentList(post);
			break;
		case "2":
			postController.insertComment(post, member.getMe_id());
			break;
		case "3":
			PrintController.prev();
			break;
		case "4":
			postUpdate(post);
			break;
		case "5":
			postDelete(post);
			break;
		default:
			PrintController.wrongMenu();
			break;
		}
		
	}

	private void postUpdate(PostVO post) {
		if (post == null) {
			return;
		}
		//작성자 확인
		if (!post.getPo_me_id().equals(member.getMe_id())) {
			PrintController.notWriter();
			return;
		}
		if (postController.updatePost(post.getPo_id())) {
			System.out.println("게시글 수정 완료");
			post.setPo_id(0);
		} else {
			System.out.println("게시글 수정 실패");
		}
		
	}

	private void postDelete(PostVO post) {
		
		if (post == null) {
			return;
		}
		//작성자 확인
		if (!post.getPo_me_id().equals(member.getMe_id())) {
			PrintController.notWriter();
			return;
		}
		if (postController.deletePost(post.getPo_id())) {
			System.out.println("게시글 삭제 완료");
			post.setPo_id(0);
		} else {
			System.out.println("게시글 삭제 실패");
		}
		
	}

	private void page(PageMaker pm, int add) {
		int page = pm.getCri().getPage();
		if (add > 0 && pm.isNext()) {
			pm.getCri().setPage( page +1 ) ;
		} else if (add < 0 && pm.isPrev()) {
			pm.getCri().setPage( page - 1 );
		} else if (add>0) {
			System.out.println("마지막 페이지 입니다.");
		} else {
			System.out.println("첫 페이지 입니다.");
		}
		
	}

	private void admin() {
		PrintController.printBar();
		System.out.println("관리자님 환영합니다.");
		PrintController.printBar();
		String M = "0";
		while (true) {
			PrintController.printAdminMenu();

			M = scan.nextLine();
			PrintController.printBar();

			runAdmin(M);

			if (M.equals("5")) {
				break;
			}
		}

	} // admin done

	private void runAdmin(String M) {

		if (M.equals("1"))
			postController.insertCommunity();
		else if (M.equals("2"))
			postController.updateCommunity();
		else if (M.equals("3"))
			postController.deleteCommunity();
		else if (M.equals("4"))
			;

		else if (M.equals("5"))
			PrintController.logout();
		else
			PrintController.wrongMenu();

	}

	private void signUp() {

		if (memberController.signUp()) {
			PrintController.signUpSuccess();
		} else {
			PrintController.SignUpFail();
		}

	}// signUp done

}
