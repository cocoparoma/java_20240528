package day5;
import java.util.Scanner;
public class LCMEx01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1을 입력해 주세요");
		int su1 = sc.nextInt();
		System.out.print("정수 2을 입력해 주세요");
		int su2 = sc.nextInt();
		int temp = 0;
		int tempsu1 = 1;
		int tempsu2 = 1;
		int runtime_su1su2 = 0;//반복횟수

		if (su1 < su2) {
			temp = su1;
			su1 = su2;
			su2 = temp;
		}//수 변경

//		for(int i = 1;; i++) {
//			tempsu1 = su1 * i;
//			System.out.println("i : "+ i);
//			for(int j = 1;; j++) {
//				System.out.println("j : "+ j);
//				tempsu2 = su2 * j;
//				runtime_su1su2++;
//				if(tempsu1 == tempsu2) {
//					System.out.println("최소공배수는 : " + tempsu1);
//					System.out.println("반복횟수 : " + runtime_su1su2);
//					break;
//				}
//			}
//			if(tempsu1 == tempsu2) {
//				break;
//			}
//		}//문제가 많음
		
		
//		for(int i = 1 ; ; i++) {
//			runtime_su1su2++;
//			if (i%su1 == 00&& i%su2 ==0) {
//				System.out.println(su1 + "과" + su2 + "의 최소 공배수 : " + i);
//				System.out.println("반복횟수 : " + runtime_su1su2);
//				break;
//			}
//		}
		
		
		for (int i = su1 ; ; i += su1) {
			runtime_su1su2++;
			if(i%su2 == 0) {
				System.out.println(su1 + "과" + su2 + "의 최소 공배수 : " + i);
				System.out.println("반복횟수 : " + runtime_su1su2);
				break;
			}
		}



	}

}
