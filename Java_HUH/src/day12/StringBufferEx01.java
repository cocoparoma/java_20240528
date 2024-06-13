package day12;

public class StringBufferEx01 {

	public static void main(String[] args) {
		//String과 차이는 String은 수정이 아니라 교체, StringBuffer는 수정
		//프로그렘에 따라서 사용하면 좋은 class가 다르니 잘 사용하자
		
		StringBuffer strBu = new StringBuffer("Hello world");

		// append(문자열) : 문자열을 제일 뒤에 추가
		strBu.append("!");
		System.out.println(strBu);

		// insert(시작번지, 문자열) : 시작번지에 문자열 추가
		strBu.insert(0, "\"");
		strBu.append("\"");
		System.out.println(strBu);

		// delete(시작번지, 끝번지) : 시작번지부터 끝번지 전까지 삭제(마지막 포함 안함)
		strBu.delete(7, strBu.length() - 1);
		System.out.println(strBu);

		//StringBuilder는 단일 쓰레드에만 적용
	}

}
