package day05;

public class ArrayCopyEx01 {

	public static void main(String[] args) {
		int [] arr1 = new int[] {5,4,3,2,1};
		
		int [] arr2 = new int[arr1.length	];
		for(int i =0; i<arr1.length  ; i++){
			arr2[arr1.length-i-1] = arr1[i];
			System.out.print(arr2[arr1.length-i-1]);
		}
		System.out.println("");
		for(int i =0; i<arr2.length  ; i++) {
			System.out.print(arr2[i]);
		}
		
		int [] arr3 = new int[arr1.length];
		System.arraycopy(arr1, 1, arr3, 0 ,arr1.length-1);
		
		System.out.println("");
		for(int i =0; i<arr3.length  ; i++) {
			System.out.print(arr3[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
