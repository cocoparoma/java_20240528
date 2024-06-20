package day17;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ByteStreamEx02 {

	public static void main(String[] args) {
		//Reader 문자 단위 스트림 중 최상위 스트림
		//FileReader : 파일에서 문자 단위로 쓰는 스트림
		//InputStreamWriter : 바이트 단위로 쓴 자료를 문자로 변환해주는 보조 스트림
		//BufferedWriter : 문자로 쓸때 배열을 제고앟여 한번에 읽게함
		try (FileOutputStream fos = new FileOutputStream("src/day17/byteStream3.txt")) {
			for (char ch = 'a';  ch <= 'z'; ch++) {
				fos.write(ch);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없거나 생성할 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}

	}

}
