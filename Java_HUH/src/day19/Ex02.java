package day19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex02 {

	public static void main(String[] args) throws Exception {
		System.out.print("주민등록번호를 입력하시오 991010-1234567 \n>>");
		Scanner sc = new Scanner(System.in);
		String rRNumber = sc.nextLine();
		
		if(rRNumber.length() != 14) {
			System.out.println("잘못된 주민등록 번호입니다.");
			System.exit(0);
		}
		
		StringTokenizer st = new StringTokenizer(rRNumber, "-");
		String token1 = st.nextToken();
		String token2 = st.nextToken();
		
		char yn = token2.charAt(0);
		String ox = yn + "";
		String twoW = "00";
		
		if(ox.equals("1")||ox.equals("2")) twoW = "19";
		else if (ox.equals("3")||ox.equals("4")) twoW =" 20";
		else System.out.println("잘못된 주민등록번호 입니다.");
		
		String result = twoW + token1;
		convert0(result);
	}
	public static void convert0(String result) {
		StringBuffer cocoa = new StringBuffer();
		cocoa.append(result);
		cocoa.insert(4, '-');
		cocoa.insert(7, '-');
		String coString = cocoa.toString();
		System.out.println(coString);
	}
	
	public static void convert2(String result) throws ParseException {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		Date date = format1.parse(result);
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format2.format(date));
	}
	

}
