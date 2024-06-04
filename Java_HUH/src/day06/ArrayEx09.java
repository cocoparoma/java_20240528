package day06;
import java.util.*;
public class ArrayEx09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = 0 ;
		String answer = "";
		boolean right = false;
		String list[] = {"dog", "cat", "java", "cup", "computer"};
		do {
			clearScreen();
			System.out.println("1. guess the word");
			System.out.println("2. Check answers");
			System.out.println("3. exit");
			System.out.print("Number : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				for(;;) {
					clearScreen();
					System.out.print("Please enter a word : ");
					answer = sc.next();
					for(int i = 0 ; i < list.length ; i++) {
						if(answer.equals(list[i])) {right = true;}
					}
					System.out.println(right);
					if (right) {
						clearScreen();
						System.out.println("You did it!");
						right =false;
						zero_to_skip();
						break;
					}
				}
				break;
			case 2:
				clearScreen();
				System.out.println("Check answers");
				System.out.println(Arrays.toString(list));
				zero_to_skip();
				break;
			case 3:
				clearScreen();
				System.out.println("good bye");
			}
		}while(menu != 3);
	}
	public static void clearScreen() {
		for (int powercleaner = 0; powercleaner < 80; powercleaner++)
			System.out.println("");
	}
	public static void zero_to_skip() {
		Scanner scan = new Scanner(System.in);
		int zero_to_skip = 1;
		for(;;) {
			System.out.print("Press 0 to skip : ");
			zero_to_skip = scan.nextInt();
			if(zero_to_skip==0) {break;}
		}
	}
}
