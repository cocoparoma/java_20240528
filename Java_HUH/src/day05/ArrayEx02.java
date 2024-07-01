package day05;
import java.util.Scanner;
public class ArrayEx02 {
	public static void main(String[] args) {
		//배열의 길이 변수명.length;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 3명의 성적을 차례대로 입력해 주세요");
		int scores[] = new int[3];
		for (int i = 0 ; i < 3 ; i++) {
			System.out.print("학생 ["+ (i+1) + "]의 성적 : ");
			scores[i] = sc.nextInt();
			sum += scores[i];
		}
		System.out.print("각 학생의 성적은 : ");
		for (int i = 0 ; i < 3 ; i++) {
			System.out.print(scores[i]);
			if(i == 2) {
				System.out.println("");
				break;
			}
			System.out.print(", ");
		}
		System.out.println("학생들의 총점은 : " + sum + "입니다. ");
		System.out.println("학생들의 평균은 : " + (double)(sum/(double)scores.length) + "입니다.");

	}

}