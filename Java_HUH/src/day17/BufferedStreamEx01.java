package day17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedStreamEx01 {

	public static void main(String[] args) {

String FileName = "src/day17/charStream";
try(BufferedReader br = new BufferedReader(new FileReader(FileName))){
	String str;
//	do {
//		str = br.readLine();
//		System.out.println(str);
//	} while (str!=null);
	
	while ((str = br.readLine()) != null) {
		System.out.println(str);
	}
	
	
	
	
	
	
	
}catch (FileNotFoundException e) {
	System.out.println("파일을 찾거나 생성할 수 없습니다.");
} catch (IOException e1) {
	System.out.println("예외 발생");
	e1.printStackTrace();
}

	}

}
