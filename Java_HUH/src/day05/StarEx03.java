package day05;
public class StarEx03 {
	public static void main(String[] args) {
		int i , j ;
		int starrepeat = 0;
		for(i = 1 ; i <= 5 ; i++) {
			for(j = 5 ; j >= 1 ; j--){
				if(i >= j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
				starrepeat++;
			}
			System.out.println("");
		}
		System.out.println("Number of repetitions : "+ starrepeat);
	}
}
