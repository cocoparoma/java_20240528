package day08;

import java.util.Arrays;

public class ArraySortEx01 {

	public static void main(String[] args) {
		//정수형 배열을 버블 정렬을 이용하여 정렬하는 예제
		//버블정렬 시간 복잡도는 0(n) = n의 2제곱  (식 : nlogn / n은 실수)
		int[] arr = new int [] {1,5,2,3,7,6,4,8};

		for(int i = 0 ; i < arr.length - 1 ; i++) {
			for(int j = 0 ; j < arr.length - 1 ; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
