package day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStreamEx01 {

	public static void main(String[] args) {
		// 바이트 기반 입출력 스트림 예제
		FileInputStream fis = null;
		FileInputStream fis2 = null;
		try {
			fis = new FileInputStream("src/day17/byteStream.txt");
			/**
			 * 처음 읽을때 1있어서 읽고 두번째 읽을때 읽을게 없어서 리턴값 -1 반환
			 */
			int data = fis.read();
			System.out.println(data);
			data = fis.read();
			System.out.println(data);
			
			fis2 = new FileInputStream("src/day17/byteStream2.txt");
			do {
				data = fis2.read();
				System.out.println((char)data);
			} while (data != -1);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} finally {
			
				try {
					if(fis != null) 	fis.close();
					if(fis2 != null) 	fis2.close();
				} catch (IOException e) {
					System.out.println("파일을 닫을 수 없습니다.");
					e.printStackTrace();
				}
			
		}

	}

}
