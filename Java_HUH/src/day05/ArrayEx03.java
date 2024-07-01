package day05;
import java.util.Scanner;
public class ArrayEx03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("You can select Max numbr : ");
		int max = sc.nextInt();
		int min = 1;
		System.out.print("choose random number : ");
		int k = sc.nextInt();
		int random[] = new int[k];
		//출력
		for(int i = 0 ; i < random.length ; i++) {
			random[i] = (int)(Math.random()*(max - min +1) + min);
			System.out.print(random[i]);
			if(i == random.length-1) {
				break;
			}
			System.out.print(", ");
		}
	}

}
