package day05;
public class StarEx01 {
	public static void main(String[] args) {
		int starrepeat = 0;
		for(int i = 0;  i<5 ;i++)
		{
			for(int j = 0;  j<5 ;j++)
			{
				System.out.print("*");
				starrepeat++;
			}
			System.out.println("");
		}
		System.out.println("반복횟수 : "+ starrepeat);
	}
}