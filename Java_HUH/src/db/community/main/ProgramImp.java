package db.community.main;

import java.util.Scanner;

import db.community.controller.MemberController;
import db.community.controller.PostController;
import db.community.controller.PrintController;
import db.community.model.vo.MemberVO;
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

		}
	} // user done

	private void runUser(String m) {
		
		if (m.equals("1")) postController.insertPost(member.getMe_id());
		else if (m.equals("2"));
		else if (m.equals("3"));
		else;
		
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
