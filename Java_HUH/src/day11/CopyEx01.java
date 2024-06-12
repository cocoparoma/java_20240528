package day11;

public class CopyEx01 {

	public static void main(String[] args) {
		//얕은 복사
		//list1 배열 5개에 "주소" 5개 넣어줌
		C[] list1 = new C[5];

		//list1 주소 각 5개에 값을 넣어줌
		for (int i = 0; i < list1.length; i++) {
			list1[i] = new C(2 * i);
		}
		
		C[] list2 = new C[5];
		//주소를 복사한다
		System.arraycopy(list1, 0, list2, 0, list1.length);
		
		print(list1);
		print(list2);
		
		list1[0].num = 100;
		//얕은 복사라 같은값이 나타난다.
		print(list1);
		print(list2);
		
		
		System.out.println("--- --- ---");
		
		//깊은 복사 예제
		//list3 배열 5개에 "주소" 5개 넣어줌
		C[] list3 = new C[5];
		//list3 주소 각 5개에 값을 넣어줌
		for (int i = 0; i < list3.length; i++) {
			list3[i] = new C(2 * i);
		}
		//복사할 배열
		C[] list4 = new C[5];
		//값을 복사한다
		//주소를 공유하지 않는다
		for (int i = 0; i < list4.length; i++) {
			list4[i] = new C(list3[i]) ;
		}
		
		print(list3);
		print(list4);
		
		list3[0].num = 100;
		//주소가 다르고 값을 복사한 것이기 때문에 서로 다른 양상을 보인다.
		print(list3);
		print(list4);
		
	}

	public static void print(C[] list) {
		for (C tmp : list) {
			tmp.print();
		}
		System.out.println();
	}

}

class C {
	public int num;

	public C(int num) {
		this.num = num;
	}

	public void print() {
		System.out.print(num + "   ");
	}
	public C(C c) {
		this.num = c.num;
	}
}