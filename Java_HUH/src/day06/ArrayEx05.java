package day06;

public class ArrayEx05 {

	public static void main(String[] args) {
		int Prime = 0;
		int arr[] = new int[101];
		arr[1] = 1;
		for(int i = 2;i < arr.length; i++) {
//			System.out.println(i);
			for(int j = 1;j < arr.length; j++) {
//				System.out.println(j);
				if(i%(double)j == 0) {
					Prime++;
//					System.out.println(decimal);
				}
				if(j == 100){
					Prime = 0;
				}
				if(Prime==3) {
					arr[i]= 1;
					Prime = 0;
					break;
				}
			}
		}
		for(int i = 1;i < arr.length; i++) {
			if(arr[i] == 0)			{
				System.out.print(i + "  ");
			}
		}

//		//continue use
//		for() {
//			for(int j = 2*i ; j M ar) {
//				
//			}
//		}
		
		
		
		
		
		
		
		
		
	}

}
