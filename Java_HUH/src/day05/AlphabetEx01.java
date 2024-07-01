package day05;

public class AlphabetEx01 {

	public static void main(String[] args) {
		int i, j ;
		for(i =1 ; i <=26 ; i++) {
			for(j =0; j < i ; j++) {
				System.out.print((char)('a'+j));
			}
			System.out.println();
		}


	}

}
