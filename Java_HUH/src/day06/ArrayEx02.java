package day06;

public class ArrayEx02 {

	public static void main(String[] args) {
		int num1;

		//System.out.println(num1); //var = err
		num1 = 10;
		System.out.println(num1); //var = ok need reset

		int[] arr1 = new int[3];
		for(int tmp:arr1){
			System.out.println(tmp);//arr is auto reset
		}
		
		arr1[2]=20;//if arr1[3] = ArrayIndexOutOfBoundsException //err
		for(int tmp:arr1){
			System.out.println(tmp);
		}
	}

}
