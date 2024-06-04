package day06;
import java.util.Arrays;
import java.util.Scanner;
public class ArrayEx07_solo_test_ver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = 0, max = 100, min = 1;
		int num = 0, count = 0;
		int recordCount = 0;
		int [] record = new int[5];
		do {
			System.out.println("menu");
			System.out.println("1.play game");
			System.out.println("2.look at the score");
			System.out.println("3.end");
			System.out.print("plz enter the number : ");
			menu = sc.nextInt();

			switch(menu) {
			case 1:
				int random = (int)(Math.random() * (max - min + 1) +min); 
				do {
					System.out.print("plz enter the number : ");
					num = sc.nextInt();
					count ++;
					if(num >random) {
						System.out.println("down");
					} else if(num < random) {
						System.out.println("up");
					} else {
						System.out.println("You are Correct");
						System.out.println("your score is : " + count);
					}
				}while( random != num);
				if(recordCount < record.length) {
					record[recordCount] = count;
					recordCount ++;
				} else if (record[recordCount - 1] > count) {
					record[recordCount - 1] = count;
				}

				Arrays.sort(record, 0 , recordCount );
				System.out.println(Arrays.toString(record));
				break;

			case 2:
				if(recordCount == 0) {
					System.out.println("No information recorded");
					break;
				}
				System.out.println("check record");
				for(int i = 0 ; i < recordCount; i ++) {
					System.out.println((i + 1) + ". score : "+ record[i]);
				}
				break;
			case 3:
				System.out.println("end");
				break;

			default :
				System.out.println("wrong");
			}
		} while(menu != 3);





















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

