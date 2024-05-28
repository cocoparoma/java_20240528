package day01;
public class HelloWorld {
	//한줄 주석
	/*
	 * 여러줄 주석
	 * notion 블로그를 깃 허브 와 연결하여 블로그쓰면서 복습하기?
	 */
	/**
	 * 메서스 설명을 위한 주석
	 */
	//프로그램을 실행하기 위해서 실행지점 (main)이 필요하다
	//어디서든, 동적사용, 리턴값 없음, 메인
	public static void main(String[] args) {
		//콘솔에 문구 출력 기능
		System.out.println("Hello World!");
		char char_a = 'a'; //문자 하나 저장, 2바이트, 유니코드 사용(\u0041), '\\' 문자임, \n 줄바꿈
		char char_ss = '\\';
		char char_uc = '\u0041';
		System.out.println(char_a);
		System.out.println(char_ss);
		System.out.println(char_uc);
	}
}