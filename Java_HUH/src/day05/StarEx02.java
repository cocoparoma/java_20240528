package day05;

public class StarEx02 {

	public static void main(String[] args) {
		int starrepeat = 0;
		for(int i = 1;  i<6 ;i++)
		{
			for(int j = 0;  j<i ;j++)
			{
				System.out.print("*");
				starrepeat++;
			}
			System.out.println("");
		}
		System.out.println("반복횟수 : "+ starrepeat);
	}
}
