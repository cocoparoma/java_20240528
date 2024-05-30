package day03;
public class SwitchEx01 {
	public static void main(String[] args) {
		int su = 3;
		switch(su % 2) {
		case 0 : 
			System.out.println(su + "는 짝수");
			break;
		default : 
			System.out.println(su + "는 홀수");
		}

	}

}
