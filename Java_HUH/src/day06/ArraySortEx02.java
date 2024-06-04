package day06;
import java.util.*;
public class ArraySortEx02 {

	public static void main(String[] args) {
		int [] arr = new int[] {1,2,5,3,7,9,6,8,4};
		int tmp = 0;
		
		Arrays.sort(arr);
		
		for(int temp : arr) {
			System.out.print(temp + " ");
		}
		
		
		Integer [] arr2 = {1,2,5,3,7,9,6,8,4};
		Arrays.sort(arr2, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr2));
		
	}

}
