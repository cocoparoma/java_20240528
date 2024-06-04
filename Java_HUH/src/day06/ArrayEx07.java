package day06;
import java.util.*;
public class ArrayEx07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max =100 , min =1;
		int TF = 0;
		int answer = 0;
		int menu = 0;
		int random = (int)(Math.random() * (max - min + 1) +min); 
		int total = 0;
		int number = 1;
		int[] arr_score_borad = new int[5];
		for(;;) {
			System.out.println("---------------------------------");
			System.out.println("              메뉴");
			System.out.println("          1. 플레이");
			System.out.println("          2. 기록 확인");
			System.out.println("          3. 종료");
			System.out.println("---------------------------------");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			if(menu == 1) {
				System.out.println("---------------------------------");
				System.out.println("게임 플레이 선택");
				System.out.println("1~100 까지 숫자 렌덤 선택 됨");
				System.out.println("정답을 맞춰주세요!");
				System.out.println("---------------------------------");
				for(int i = 0;; i ++) {//1플레이 완성
					if(TF == 0) {
						System.out.print("정답 : ");
						answer = sc.nextInt();
						TF++;
						if (random == answer) {
							TF ++ ;
						}
					} else if(TF == 2) {
						System.out.println("!!! --- 정답입니다 --- !!!");
						random = (int)(Math.random() * (max - min + 1) +min); //렌덤 값 수정
						arr_score_borad[number] = i; //결과값저장
						number++;//수정사항 6넘어가면 err
						total ++;
						System.out.println(" --- 메인 매뉴로 돌아갑니다. ---");
						System.out.println("---------------------------------");
						System.out.print("0을 입력하시면 돌아갑니다. : ");
						TF = sc.nextInt();
						if(TF == 0) {
							break;
						}
					} else if(TF== 1){
						if(random > answer) {
							System.out.print("    ↑↑↑up↑↑↑");
						}
						if(random < answer) {
							System.out.print("↓↓↓down↓↓↓");
						}
						TF --;
					} else {
						System.out.println("오류");
						System.out.println("메인매뉴로 복귀");
						TF = 0;
						break;
					}
				}
			}
			if(menu == 2) {//기록 5개
				for(;;) {
					System.out.println("---------------------------------");
					System.out.println("   정답을 맟춘 횟수 : " + total);
					System.out.println("             순위표");
					for(int i =0 ; i < arr_score_borad.length ; i++) {
						Arrays.sort(arr_score_borad);
						System.out.println("    " + (i + 1) + "등 : " + arr_score_borad[i] + "번");
					}
					System.out.println("---------------------------------");
					System.out.print("0을 입력하시면 돌아갑니다. : ");
					
					TF = sc.nextInt();
					if(TF == 0) {
						break;
					}
				}
			}
			if(menu == 3) {
				System.out.println("---------------------------------");
				System.out.println("   프로그렘을 종료합니다.");
				System.out.println("---------------------------------");
				break;
			}
		}
	}
}
