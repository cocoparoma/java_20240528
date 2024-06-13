package day12;

public class MathEx02 {

	public static void main(String[] args) {
		//3.14를 소수점 두번째 자리에서 올림하는 코드를 작성하시오
		
		// ceil() : 소수점 첫번째 자리에서 올림
		double Pi = Math.PI;
		System.out.println(Pi);
		Pi = Math.ceil(Pi * 10);
		System.out.println(Pi);
		Pi = Pi/10;
		System.out.println("소수점 두번째 자리에서 올림" + Pi);
		
		
	}

}
