package day16;

import lombok.Data;
import lombok.NonNull;

public class LonbokEx01 {

	public static void main(String[] args) {
		Test t = new Test("김지우","2");
		
		Test t2 = new Test("홍길동","1");
		
		Test t3 = new Test("강감찬","");
		
		
	}

}




//@Data //종합선물세트
//@EqualsAndHashCode : 이퀄과  헤쉬코드 메소드를 오버라이딩, 모든 멤버 변수를 가지고 비교
//@Getter, @Setter :  모든 멤버 변수에 대해서 겟셋해줌
//@ToString = toString 오버라이딩
//@AllArgsConstructor // 모든 멤버변수를 필요로 하는 생성자
//@NoArgsConstructor //기본생성자
//@RequiredArgsConstructor : 반드시 필요한 멤버변수들을 매개변수로 갖는 생성자.
@Data
class Test{
	private String nameString;
	@NonNull
	private String numberString;
	@Override
	public String toString() {
		return "Test [nameString=" + nameString + ", numberString=" + numberString + "]";
	}
	public Test(String nameString, String numberString) {
		this.nameString = nameString;
		this.numberString = numberString;
	}
}