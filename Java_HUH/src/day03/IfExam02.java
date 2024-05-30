package day03;
import java.util.Scanner;
public class IfExam02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("지금은 몇월 인가요? : ");
		int season = sc.nextInt();
		System.out.println(
				(season==3 || season==4||season==5) ? "봄"
				: (season==6 || season==7||season==8) ? "여름"
				: (season==9 || season==10||season==11) ? "가을"
				: (season==12 || season==1||season==2) ? "겨울"
				: "잘못된 월");
		if (5>=season && season>=3) {System.out.print("봄");} 
		else if (8>=season && season>=6) {System.out.print("여름");}
		else if (11>=season && season>=9) {System.out.print("가을");}
		else if (season==12 || season==1||season==2) {System.out.print("겨울");}
		else {System.out.print("잘못된 월");}
	}
}
