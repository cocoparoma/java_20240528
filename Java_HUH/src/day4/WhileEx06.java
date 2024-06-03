package day4;

public class WhileEx06 {

	public static void main(String[] args) {
		/* 12의 약수를 출력하는 코드를 작성하세요.
		 * 약수는 나누어서 나머지가 0이 되게 하는 수 
		 * 12의 약수 : 1, 2, 3, 4, 6, 12
		 * 반복횟수 : i는 1부터 12까지 1씩 증가
		 * 규칙성 : i가 12의 약수이면 i를 출력
		 * 		 =>12를 i로 나누었을 때 나머지가 0과 같다면 i를 출력
		 * 반복문 종료 후 : 없음
		 * */
//		System.out.print("12의 약수는 : ");
//			for(int i = 1; i <= 12; i++) {
//				if(12%i == 0) {
//					System.out.print(i + " ");
//				}
//			}
		int i = 1;
		System.out.print("12의 약수는 : ");
		while(i <= 12) {
			if(12%i == 0) {
				System.out.print(i);
				if(i!=12) {
					System.out.print(", ");
				}
			}
			i++;
		}
	}

}
