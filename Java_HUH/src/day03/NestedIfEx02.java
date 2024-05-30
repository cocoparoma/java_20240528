package day03;
import java.util.Scanner;
public class NestedIfEx02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su1, su2;
		char ch1;
		System.out.print("정수 1을 입력해 주세요 : ");
		su1 = sc.nextInt();
		System.out.print("정수 2을 입력해 주세요 : ");
		su2 = sc.nextInt();
		System.out.print("연산자를 입력해 주세요(+, -, *, /,%) : ");
		ch1 = sc.next().charAt(0);
		//0 
		if((su2 == 0 && ch1=='/') || (su2 == 0 && ch1=='%') ) {
			System.out.println("0으로 나눌 수 없습니다.");
		}else {
			if (ch1=='+') {System.out.println("" + su1 + ch1 + su2 + "="+(su1+su2));}
			else if(ch1=='-') {System.out.println("" + su1 + ch1 + su2 + "="+(su1-su2));}
			else if(ch1=='*') {System.out.println("" + su1 + ch1 + su2 + "="+(su1*su2));}
			else if(ch1=='/') {System.out.println("" + su1 + ch1 + su2 + "="+(su1/(double)su2));}
			else if(ch1=='%') {System.out.println("" + su1 + ch1 + su2 + "="+(su1%(double)su2));}
			else {System.out.println("잘못 입력하셨습니다.");} //예외처리
		}
	}
}