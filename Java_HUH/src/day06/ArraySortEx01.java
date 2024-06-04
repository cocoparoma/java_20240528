package day06;

public class ArraySortEx01 {

	public static void main(String[] args) {
		int [] arr = new int[] {1,2,5,3,7,9,6,8,4};
		int tmp = 0;
		
		for(int i = 0; i < arr.length - 1 ; i ++) {
			for(int j = 0 ; j < arr.length - i - 1;j++) {
				if(arr[j]>arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	for(int temp : arr) {
		System.out.print(temp + "  ");  
	}
		
	}

}
