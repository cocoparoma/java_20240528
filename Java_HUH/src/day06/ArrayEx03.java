package day06;
public class ArrayEx03 {
	public static void main(String[] args) {
		int arr1[] = new int[9];
		for(int i = 0; i < arr1.length ; i++) {
			arr1[i]=2*(i+1);
			System.out.println("2 x " + (i+1) + " = " + arr1[i]);
		}
		
		int arr2[] = new int[10];
		for (int i = 1 ; i < arr2.length; i ++) {
			arr2[i]=2*i;
			System.out.println("2 x " + i + " = " + arr2[i]);
		}
	}
}