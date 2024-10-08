package teamPlayClient.controller;

import java.util.Scanner;

public class PrintClientController {

	public static void printMainMenu() {
		printBar();
		System.out.println("1. Login\n2. Join");
		System.out.println("\n0. or exit. 종료");
		printBar();
		printRequestAnswer();
	}
	
	public static void printBar() {
		System.out.println("*--------------------*");
	}
	
	public static void printRequestAnswer() {
		System.out.print(">>");
	}

	public static void printAfterLoginMenu(String border, String category) {
		printBar();
		if (border.length() == 0) {
			System.out.println("1. 보드 선택 : 미선택");
		} else {
			System.out.println("1. 보드 선택 : " + border);
		}
		
		if (category.length() == 0) {
			System.out.println("2. 카테고리 선택 : 미선택");
		} else {
			System.out.println("2. 카테고리 선택 : " + category);
		}
		System.out.println("3. 게시글 보기");
		System.out.println("4. 게시글 선택\n5. 게시글 작성\n6. 게시글 삭제");
		System.out.println("7. 게시글 수정\n8. 댓글 작성\n9. 댓글 삭제");
		System.out.println("\n0. or exit. 종료");
		printBar();
		printRequestAnswer();
	}

	public static void printExit() {
		printBar();
		System.out.println("---[Exit program]---");
		printBar();
	}

	public static void printWrongMSG() {
		printBar();
		System.out.println("---[Wrong input]---");
		printBar();
		
	}

	public static void printLoginSuccess() {
		printBar();
		System.out.println("---[Login Success!]---");
		printBar();
		
	}

	public static void zeroToNext(Scanner scan) {
		for(;;) {
			System.out.println("0. or exit. to next");
			String M = scan.nextLine();
			if (M.equals("0") || M.equals("exit")) {
				break;
			}
		}
		
	}
}
