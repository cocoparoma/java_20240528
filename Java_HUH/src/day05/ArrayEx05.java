package day05;
import java.util.Scanner;
public class ArrayEx05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max = 10, min = 1;
		int random[] = new int[3];
		int answer;
		boolean ox = false;

		for(int i = 0 ; i<random.length ;i++) {
			random[i] = (int)(Math.random()*(max - min + 1) +min);
			System.out.print (random[i] + " ");
		}

		System.out.println("렌덤한 숫자 3개를 맞춰보세요.(0 = 종료)");
//		answer = sc.nextInt();
//		for(int tmp : random) {
//			//System.out.print(tmp);
//			if(tmp == answer) {
//				ox = true;
//			}
//		}
//		if (ox == true) {
//			System.out.print(answer + "는 정답입니다.");
//		} else {
//			System.out.print(answer + "는 오답입니다.");
//		}







		for(int k = 1;k < 100;k++) {
			answer=100;
			ox = false;
			answer = sc.nextInt();
			for(int i = 0 ; i<random.length ;i++) {
				if(answer==random[i]) {
					System.out.println(answer + "은 있습니다.");
					ox = true;
					break;
				}
			}
			if(answer==0)
			{
				System.out.println("finish");
				break;
			}
			if(ox != true) {
				System.out.println(answer + "은 없습니다."); 
			}
			
		}

	}

}
