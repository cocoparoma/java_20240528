package day24;

import java.io.FileWriter;

public class Ex17 {

	public static void main(String[] args) {
		/**
		 * 
		 */
		// try( ) <-안에 넣으면 우리가 닫아줄 필요가 없음
		try(FileWriter fw = new FileWriter("src/day24/ex17.txt", true);) {//true 이어쓰기
			fw.write('a');
			fw.write('b');
			fw.write('c');
			fw.flush();
		} catch (Exception e) {
		}
		
		

	}

}
