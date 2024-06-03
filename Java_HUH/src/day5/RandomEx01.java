package day5;
public class RandomEx01 {
	public static void main(String[] args) {
		int min = 1, max = 7;
		//Math.random() 0부터 1미만 까지의 렌덤한 숫자 출력
		//Math.random() = r
		//0 <= r < 1
		//0 <= r * (max - min +1) < (max - min +1)
		// min <= r * (max - min +1)+ min < max - min + 1 + min
		// min <= r * (max - min +1)+ min < max + 1 
		// r * (max - min +1)+ min 는 실수형 >> (int)를취해주면
		//(int)(r * (max - min +1)+ min)
		//해당 값을 int 형에 저장 
		int random = (int)(Math.random()*(max - min +1) + min);
		System.out.println("렌덤 수 : " + random);
	}
}