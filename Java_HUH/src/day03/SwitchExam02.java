package day03;
import java.util.Scanner;
public class SwitchExam02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("plz enter your month : ");
		int season = sc.nextInt();

		switch (season) {
		case 3,4,5 : 
			System.out.println("spring");
		break;
		case 6,7,8 : 
			System.out.println("summer");
		break;
		case 9,10,11 : 
			System.out.println("fall");
		break;
		case 12,1,2 : 
			System.out.println("winter");
		break;
		default :
			System.out.println("ERROR");
		}

	}

}
