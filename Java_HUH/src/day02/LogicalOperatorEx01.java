package day02;
public class LogicalOperatorEx01 {

	public static void main(String[] args) {
//		논리 연산자 예제
//		성적이 b학점인지 확인하는 예제
		int score = 95;
		boolean is_B ;
		is_B = score >=80 && 90 > score;
		System.out.println(score + "는 B 학점일까요? : "+ is_B);
		
		String your_grade = (score >=80 && 90 > score) ? "B등급입니다" : "B등급이 아닙니다" ;
		System.out.println(your_grade);
		
		//  or 연습하기 ||
		int sub1 = 60, sub2 = 100, sub3 = 30, sub4 = 80;
		String rises_and_falls = (sub1 <40 || sub2 <40 ||sub3 <40 ||sub4 <40) ? "탈락입니다." : "합격입니다." ; 
		System.out.println("당신은 " +rises_and_falls);
		boolean isFail = sub1 <40 || sub2 <40 ||sub3 <40 ||sub4 <40;
		System.out.println("과락이 있습니까? : " + isFail);
		
		// not 연습하기! !
		int age = 20;
		String you_adult = (age >= 20) ? "당신은 성인입니다." : "당신은 미성년자 입니다.";
		System.out.println(you_adult);
		boolean isMinor = !(age >= 19);
		System.out.println("미성년자 입니까? : " +isMinor );
		
		
	}	
}
