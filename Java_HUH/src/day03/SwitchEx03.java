package day03;
import java.util.Scanner;
public class SwitchEx03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("plz enter the Number 1 : ");
		int su1 = sc.nextInt();
		System.out.print("plz enter the Number 2 : ");
		int su2 = sc.nextInt();
		System.out.print("plz enter the operator : ");	
		char ch1 = sc.next().charAt(0);
		switch(ch1) {
		case '+' :
			System.out.println("" + su1 + ch1 + su2+"="+(su1+su2));
			break;
		case '-' :
			System.out.println("" + su1 + ch1 + su2+"="+(su1-su2));
			break;
		case '*' :
			System.out.println("" + su1 + ch1 + su2+"="+(su1*su2));
			break;
		case '/' :
			if(su2 == 0) {break;}
			System.out.println("" + su1 + ch1 + su2+"="+(su1/(double)su2));
			break;
		default:
			System.out.println("Error");
		}

	}
}
