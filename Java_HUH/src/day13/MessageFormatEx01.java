package day13;

import java.text.MessageFormat;

public class MessageFormatEx01 {

	public static void main(String[] args) {
		String format1 = "({0}, {1})";
		int x = 1, y = 10;
		String result1 = MessageFormat.format(format1, x, y);

		int grade = 1, classNum = 2, num = 3;
		String name = "홍길동";
		String format2 = "{0}학년 {1}반 {2}번 이름 : {3}";
		String result2 = MessageFormat.format(format2, grade, classNum, num, name);
		System.out.println(result2);

	}

}
