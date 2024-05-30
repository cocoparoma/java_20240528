package day03;
import java.util.Scanner;
public class IfEx01 {
	public static void main(String[] args) {
		//if문을 이용한 홀짝 판별 예제
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해 주세요 : ");
		int num = sc.nextInt();
		
		//if문 2개 연결하기
		if(num%2 == 1) {
			System.out.println("홀수입니다.");
		}
		if(num%2 != 1) {
			System.out.println("짝수입니다.");
		}
		
		//if-else문으로만들어보기 //else 뒤 조건을 추가해도 됨 else if(num%2 != 1)
//		if(num%2 == 1){
//			System.out.println("홀수입니다.");
//		} else{
//			System.out.println("짝수입니다.");
//		}
		
		//삼항연산자 연결해서 만들어 보기
//		String str = (num%2 == 1) ? "str 은 홀수 입니다." : "str 은 짝수 입니다.";
//		System.out.println(str);
		
	}

}
