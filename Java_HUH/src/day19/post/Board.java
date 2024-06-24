package day19.post;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
	String file = "src/day19/post/post.txt";
	Scanner sc = new Scanner(System.in);
	List<Post> list = new ArrayList<Post>();

	void init() {
		load(file);
		while (true) {
			save(file);
			
			System.out.print("■게시판■\n[1]등록\n[2]수정\n[3]삭제\n[4]조회\n[5]종료\n>>");

			String M = sc.nextLine();

			 		 if (M.equals("1")) registPost();
			else if (M.equals("2")) editPost();
			else if (M.equals("3")) deletePost();
			else if (M.equals("4")) viewPost();
			else if (M.equals("5")) return;
			else if (M.equals("show")) showAll();//디버깅용입니다.
			else if (M.equals("cls")) clsScreen();
			else System.out.println("올바른 입력이 아닙니다.");
		}
	}//init done
	private void registPost() {
		System.out.print("제목\n>>");
		String titleString = sc.nextLine();//채크
		System.out.print("내용\n>>");
		String postString = sc.nextLine();
		System.out.print("작성자\n>>");
		String nameString = sc.nextLine();
		System.out.print("비밀번호\n>>");
		String passString = sc.nextLine();
		list.add(new Post(titleString, postString, nameString, passString));
	}
	
	private void editPost() {
		System.out.print("검색어(전체검색 엔터)\n>>");
		String editW = sc.nextLine();
		List<Post> tmpList = null;
		if (editW != null) {
			tmpList = list.stream().filter(p->p.getTitle().contains(editW)).toList();
		} else {
			tmpList = list;
		}
		if (list.stream().filter(p->p.getTitle().contains(editW)).count() == 0) return;
		for (int i = 0; i < tmpList.size(); i++) {
			System.out.println("▶" +(i+1) + "번 글 제목 : "+tmpList.get(i).getTitle() + "/ 작성자 : " + tmpList.get(i).getName() +" 조회수 : " +  tmpList.get(i).veiw);
		}
		System.out.print("수정하실 게시글을 입력해 주세요.\n>>");
		try {
			String indexString = sc.nextLine();
			int index = Integer.parseInt(indexString) -1;
			System.out.print("비밀번호를 입력해 주세요.\n>>");
			String passString = sc.nextLine();
			if (!tmpList.get(index).password.equals(passString)) {
				System.out.println("비밀번호가 다릅니다.");
				return;
			}
			System.out.print("수정하실 내용을 입력해 주세요.\n제목\n>>");
			String titleString = sc.nextLine();//채크
			System.out.print("내용\n>>");
			String postString = sc.nextLine();
			tmpList.get(index).update(titleString, postString);
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
		}
	}
	
	private void deletePost() {
		System.out.print("검색어(전체검색 엔터)\n>>");
		String deleteW = sc.nextLine();
		List<Post> tmpList = null;
		if (deleteW != null) {
			tmpList = list.stream().filter(p->p.getTitle().contains(deleteW)).toList();
		} else {
			tmpList = list;
		}
		if (list.stream().filter(p->p.getTitle().contains(deleteW)).count() == 0) return;
		for (int i = 0; i < tmpList.size(); i++) {
			System.out.println("▶" +(i+1) + "번 글 제목 : "+tmpList.get(i).getTitle() + "/ 작성자 : " + tmpList.get(i).getName() +" 조회수 : " +  tmpList.get(i).veiw);
		}
		System.out.print("삭제하실 게시글을 입력해 주세요.\n>>");
		try {
			String indexString = sc.nextLine();
			int index = Integer.parseInt(indexString) -1;
			System.out.print("비밀번호를 입력해 주세요.\n>>");
			String passString = sc.nextLine();
			if (!tmpList.get(index).password.equals(passString)) {
				System.out.println("비밀번호가 다릅니다.");
				return;
			}
			list.remove(tmpList.get(index));
			System.out.println("삭제되었습니다.");
		} catch (Exception e) {
			System.out.println("잘못된 값을 입력하셨습니다.");
		}

	}
	
	private void viewPost() {
		System.out.print("검색어(전체검색 엔터)\n>>");
		String searchW = sc.nextLine();
		List<Post> tmpList = null;
		if (searchW != null) {
			tmpList = list.stream().filter(p->p.getTitle().contains(searchW)).toList();
		} else {
			tmpList = list;
		}
		if (list.stream().filter(p->p.getTitle().contains(searchW)).count() == 0) return;
		for (int i = 0; i < tmpList.size(); i++) {
			System.out.println("▶" + (i + 1) + "번 글 제목 : " + tmpList.get(i).getTitle() + "/ 작성자 : " + tmpList.get(i).getName()
					+ " 조회수 : " + tmpList.get(i).veiw);
		}
		System.out.print("보고싶은 게시글을 입력해 주세요.\n>>");
		String indexString = sc.nextLine();
		try {
			int index = Integer.parseInt(indexString) - 1;
			System.out.println(tmpList.get(index));
			System.out.println("do Enter" + sc.nextLine());
		} catch (Exception e) {
			System.out.println("잘못된 값을 입력하셨습니다.");
		}

	}

	public void save(String file) {
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void load(String file) {
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {
			list = (List<Post>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void showAll() {//디버그용
		System.out.println(list);
	}
	
	public void SortArr() {//게시글 정렬 조회수나 이름순 혹은 다른순으로도 가능한데 구현하지 않음
		list.stream().sorted();
		/*
		 * strStream.sorted(Comparator.naturalOrder()) //기본정렬 strStream.sorted((s1,s2)
		 * -> s1.compareTo(s2)); //람다식도 가능 strStream.sorted(String::compareTo); //위의 문장과
		 * 동일
		 *
		 */
		/////https://aomee0880.tistory.com/158       개쩌는 스트림으로 나열하기
	}
	
	public void clsScreen() {//청소기
		for (int i = 0; i < 80; i++) {
			System.out.println();
		}
		
	}
	
	

}//Board done