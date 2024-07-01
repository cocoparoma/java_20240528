package account;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//스위치 문을 쓰면 삭제수정검색도 메소드하나로 가능함 검색기능 넣고 삭제 후에 마지막에 추가기능을 이어서 작성하면  case 3개 + 디폴트 하나로 더 줄일수 있음
//메소드 하나에 삭제수정검색이 됨
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6612087841849757977L;
	Scanner sc = new Scanner(System.in);
	List<Account_Book> account_Book_List = new ArrayList<Account_Book>();
	List<String> acBook_Type_List = new ArrayList<String>();
	String file = "src/account/account_Book_List.txt";

	public void init() {
		load(file);
		while (true) {

			System.out.print("메뉴\n1. 내역 입력\n2. 내역 수정\n3.내역 삭제\n4.내역 조회\n5.종료\n메뉴선택 : ");

            String M = sc.nextLine();

            if (M.equals("1")) account_Insert();
            else if(M.equals("2")) account_Update();
            else if(M.equals("3")) account_Delete();
            else if(M.equals("4")) account_Log();
            else if(M.equals("5")) break;
            else if(M.equals("show")) showAll();
            else System.out.println("잘못된 입력입니다.");
            
		}
		save(file);

	}

	private void account_Input(int a) {
		Account_Book ABtmp = new Account_Book();
		switch (a) {
		case 1:
			System.out.print(" - 날짜(형식 : 19990118)\n>>");
			int Book_Date = Integer.parseInt(sc.nextLine());
			ABtmp.setAccount_Book_Date(Book_Date);
		case 2:
			System.out.print(" - 수입(1)/지출(2)\n>>");
			int Book_Income = Integer.parseInt(sc.nextLine());
			ABtmp.setAccount_Book_Income(Book_Income);
		case 3:
			System.out.print(" - 분류<목록 추가>\n>>");
			System.out.println(acBook_Type_List);
			String Book_Type = sc.nextLine();
			if (acBook_Type_List.stream().filter(p -> p.equals(Book_Type)).count() == 0)
				acBook_Type_List.add(Book_Type);
			ABtmp.setAccount_Book_Type(Book_Type);
		case 4:
			System.out.print(" - 금액\n>>");
			int Book_Coin = Integer.parseInt(sc.nextLine());
			ABtmp.setAccount_Book_Coin(Book_Coin);
		case 5:
			System.out.print(" - 내용\n>>");
			String Book_Detail = sc.nextLine();
			ABtmp.setAccount_Book_Detail(Book_Detail);
		case 6:
			account_Book_List.add(ABtmp);
		default:

		}

	}

	private Account_Book account_Finder(String keyword) {
		Account_Book atmp = new Account_Book();
		List<Account_Book> tmpList = new ArrayList<Account_Book>();
		try {
			for (int i = 0; i < account_Book_List.size(); i++) {
				if (account_Book_List.get(i).getAccount_Book_Date() == Integer.parseInt(keyword) ) {
					tmpList.add(account_Book_List.get(i));
					System.out.println((i + 1) + ". " + tmpList.get(i));
				} 

			}
		} catch (Exception e) {
			
			for (int i = 0; i < account_Book_List.size(); i++) {
				
					tmpList.add(account_Book_List.get(i));
					System.out.println((i + 1) + ". " + tmpList.get(i));

			}
		}
		if (tmpList.size() == 0) {
			System.out.println("해당하는 정보가 없습니다.");
			return null;
		}

		System.out.println("찾으시는 번호를 입력해 주세요");
		int tmpNum = toInt(sc.nextLine()) - 1;
		if (tmpNum < 0) {
			return null;
		}

		return tmpList.get(tmpNum);
	}

	private void account_Insert() {
		System.out.println("일정을 추가합니다");
		account_Input(1);
		System.out.println(" - 추가 완료 - ");
	}

	private void account_Update() {
		System.out.println("수정하고싶은 날짜를 입력하세요 (형식 : 19990118)\n>>");
		String key = sc.nextLine();
		
		account_Book_List.remove(account_Finder(key));
		account_Input(1);
		System.out.println(" - 수정 완료 - ");
	}

	private void account_Delete() {
		System.out.println("삭제하고싶은 날짜를 입력하세요 (형식 : 19990118)\n>>");
		String key = sc.nextLine();
		if (acBook_Type_List.stream().filter(p -> p.equals(account_Finder(key).getAccount_Book_Type())).count() == 0)
			acBook_Type_List.remove(account_Finder(key).getAccount_Book_Type());
		account_Book_List.remove(account_Finder(key));
		System.out.println(" - 삭제 완료 - ");
	}

	private void account_Log() {
		System.out.println("검색하고싶은 날짜를 입력하세요 (형식 : 19990118)\n>>");
		String key = sc.nextLine();
		System.out.println(account_Finder(key));
	}

	private void showAll() {// 디버깅용
		Account_Book ABtmp = new Account_Book();
		System.out.println(account_Book_List);
	}

	public void save(String file) {
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(account_Book_List);
			oos.writeObject(acBook_Type_List);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void load(String file) {
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {
			account_Book_List = (List<Account_Book>) ois.readObject();
			acBook_Type_List = (List<String>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static int toInt(String in) {
        try {
            Integer.parseInt(in);
        } catch (Exception e) {
         System.out.println("잘못된 입력입니다.");
            return -31;
        }
        return Integer.parseInt(in);
    }

}
