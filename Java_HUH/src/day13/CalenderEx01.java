package day13;

import java.util.Calendar;

public class CalenderEx01 {

	public static void main(String[] args) throws Exception {
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR); // 년도 추출
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year + " - " + month + " - " + day);
		
	}

}
