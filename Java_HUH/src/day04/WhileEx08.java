package day04;
import java.util.Scanner;
public class WhileEx08 {
	public static void main(String[] args) {
		/* 두 정수 8과 12의 최대 공약수를 구하는 코드를 작성하세요.
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 최대 공약수 : 공약수 중 가장 큰 공약수
		 * 8 : 1, 2, 4, 8
		 * 12: 1, 2, 3, 4, 6, 12
		 * 8과 12의 공약수 : 1, 2, 4
		 * 8과 12의 최대 공약수 : 4
		 * 반복횟수 : i는 1부터 8까지 1씩 증가
		 * 규칙성 : 
		 * 		i가 8과 12의 약수이면 i를 gcd에 저장 
		 * 		=> i가 8의 약수이고 i가 12의 약수이면 i를 gcd에 저장
		 * 		=> 8을 i로 나누었을 때 나머지가 0과 같고 12를 i로 나누었을 때 나머지가 0과 같다면 i를 gcd에 저장
		 * 반복문 종료 후 : gcd를 출력
		 * */	
		Scanner sc = new Scanner(System.in);
		int Max_num =0;
		int temp = 0;
		System.out.println("두 숫자를 입력해 주세요.");
		int scores[] = new int[2];
		for (int i = 0 ; i < 2 ; i++) {
			System.out.print("숫자 "+ (i +1)+" : ");
			scores[i] = sc.nextInt();
		}
		int i = 1;
		if (scores[0] < scores[1]) {
			temp = scores[0];
			scores[0] = scores[1];
			scores[1] = temp;
		}
		while(i <= scores[0]) {
			if(scores[0]%i == 0&& scores[1]%i ==0) {
				Max_num = i ;
			}
			i++;
		}
		System.out.println(scores[0] + "과 " + scores[1]  + "의 최대 공약수는 "+ Max_num + "입니다.");
	}
}