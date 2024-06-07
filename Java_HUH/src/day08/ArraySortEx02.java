package day08;
import java.util.Arrays;
public class ArraySortEx02 {
	//버블 정렬을 이용하여 문자열을 정렬하는 예제
	public static void main(String[] args) {
		String[] arr = new String[] {"apple", "a", "zoo", "banana"};
		//문자열 1.compareTo(문자열2) : 문자열 1과 문자열 2를 알파벳 순으로 배치했을 때 위치를 정수로 알려줌
		//같은 번지에 있는 문자들끼리 순서대로 비교
		//apple 과 a를 비교하면
		//apple의 a와 a 의 a를 비교 같으면 다음 문자를 비교
		//apple의 p와 a의 다음을 비교하려는데 다음이 없어서 a가 앞으로
		//같으면 0, 문자열1이 앞이면 음수, 문자열 1이 뒤이면 양수
		for(int i = 0 ; i < arr.length - 1 ; i++) {
			for(int j = 0 ; j < arr.length - 1 ; j++) {
				if(arr[j].compareTo(arr[j+1]) > 0) {
					String tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}