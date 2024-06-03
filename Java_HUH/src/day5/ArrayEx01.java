package day5;
public class ArrayEx01 {
	public static void main(String[] args) {
		//지역변수는 자동으로 초기화 되지 않음
		int score1, score2, score3 ,score4, score5;
		//배열은 자동으로 초기화 됨(참조형 즉 주소를 저장함)
		int[] scores1 = new int[5];
		int scores2[] = new int[5];
		//번지는 0, 1, 2, 3, 4로 0부터 시작한다
		int scores3[] = new int[] {1,2,3,4,5};
		
		for(int i = 0 ; i < 5 ; i++) {
			scores1[i] = i+1;
			System.out.println(scores1[i]);
		}

	}
}