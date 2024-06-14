package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx01 {

	public static void main(String[] args) throws Exception {
		Date date = new Date();
		//날짜 >> 문자열
		SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd");
		String dateStr1 = format1.format(date);
		System.out.println(dateStr1);
		
		SimpleDateFormat format2 = new SimpleDateFormat( "yyyy-MM-dd  HH:mm:ss");
		String dateStr2 = format2.format(date);
		System.out.println(dateStr2);
		
		SimpleDateFormat format3= new SimpleDateFormat( "yyyy년 MM월 dd일 HH시 mm분 ss촌");
		String dateStr3 = format3.format(date);
		System.out.println(dateStr3);
		
		//문자열  = > 날짜
		//포멧이 안 맞는 경우 예외가 발생할 수 있다.
		//W : 월에 몇번째 주, w : 년의 몇번째 주 E : 요일
		//K, k  0 부터 시작하는 시간, S밀리초
		String dateStr4 = "2024-06-14 09:22";
		SimpleDateFormat format4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date4= format4.parse(dateStr4); //예외처리 요구됨
		
		System.out.println(date4);
	}

}
