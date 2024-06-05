package day07;
import java.util.Arrays;
public class ArrayEx02 {
	public static void main(String[] args) {
		int max_code_number = 3;
		int max = 9; int min = 1; int[] random_code =  new int[max_code_number]; int OnOff = 0;
		for(int i  =0 ; i < random_code.length ; i++) {
			int random = (int)(Math.random() * (max - min +1) + min) ;
			for(int j=0 ; j < random_code.length ; j++){
				if(random_code[j] == random) {//중복일 경우
					OnOff = 1;
					break;
				}
			}
			if (OnOff == 1) {
				i -- ;
				OnOff = 0;
			} else {
				random_code[i] = random;
			}

		}
		System.out.println(Arrays.toString(random_code));
	}

}
