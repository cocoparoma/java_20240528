package day24;

public class Ex07 {

	public static void main(String[] args) {
		/**
		 * 원인 : for문 옆 ;
		 * 해결 방안 : 세미콜론에 의해 for문은 i 를 11까지 증가시켜주고 끝난다  고로 그냥 11을 sum에 집어넣은 꼴 콜론을 삭제해주자
		 */
		int i;
		int sum = 0;
		for(i = 1; i<= 10 ;  i++) {
				sum += i;
			
		}
		System.out.println("sum : " + sum);
		
		
	}

}
