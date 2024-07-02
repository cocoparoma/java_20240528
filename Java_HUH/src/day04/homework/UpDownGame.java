package day04.homework;
import java.util.Scanner;
public class UpDownGame {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int answer = 0;
		int min = 1, max = 100;
		int random = (int)(Math.random() * (max - min + 1) + min);
		System.out.print("1부터 100까지 렌덤한 숫자를 맞춰주세용!");
		for(  int i = 0; i <= 2; i++) {
			System.out.print("정수 입력 : ");
			answer = sc.nextInt();
			if(answer == random) {
			System.out.println("정답입니다~");
			i = i+2;
			}else if(answer > random) {
				System.out.println("down");
				i--;
			} else if(answer < random) {
				System.out.println("up");	
				i--;
			}
		}		
		System.out.println("랜덤한 수 : " + random);
		
	}

}
