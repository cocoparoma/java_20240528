package day18.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SchedulerService extends MemberService {
	Scanner sc = new Scanner(System.in);
	String file = "src/day18/homework/Schedule.txt";
	ArrayList<Schedule> slist = new ArrayList<Schedule>();
	Map<String, ArrayList<Schedule>> map = new HashMap<String, ArrayList<Schedule>>();
	public String MAPID = "";
	
	
	
	
	public void init() {
		while (true) {
			MAPID = login();
			if (MAPID != "") break;
		}
		map.put(MAPID,slist);
		
		while (true) {
			System.out.println("[1]일정 추가\n[2]일정 수정\n[3]일정 삭제\n[4]일정 확인\n[5]돌아가기\n>>");
			
			String M = sc.nextLine();
			
			if (M.equals("1")) addSchedule();
			else if(M.equals("2")) updateSchedule();
			else if(M.equals("3")) deleteSchedule();
			else if(M.equals("4")) checkSchedule();
			else if(M.equals("5")) break;
			else System.out.println("잘못된 입력입니다.");
		}
		
	}

	private String login() {
		System.out.print("아이디를 입력해 주세요.\n>>");
		String idString = sc.nextLine();
		if (list.stream().filter(p->p.getId().equals(idString)).count() != 0) {
			return idString;
		}
		System.out.println("없는 아이디입니다.");
		return "";
	}

	private void addSchedule() {
		System.out.print("날짜 (yyyy-MM-dd hh:mm)\n>>");
		String date = sc.nextLine();
		System.out.print("일정\n>>");
		String todo = sc.nextLine();
		System.out.print("상세\n>>");
		String detail = sc.nextLine();
		slist.add(new Schedule(date, todo, detail));
	}
	
	
	private void updateSchedule() {
		// TODO Auto-generated method stub
		
	}
	private void deleteSchedule() {
		// TODO Auto-generated method stub
		
	}

	private void checkSchedule() {
		// TODO Auto-generated method stub
		
	}


}
