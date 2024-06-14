package day13;

public class ExceptionEx05 {

	public static void main(String[] args) throws Exception {
		test();

	}
	public static void test() throws Exception {
		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			throw new MyException("test", "0으로 나눌 수 없습니다.");
		}

	}
	

}


class MyException extends Exception {

	String who;

	public MyException(String messageString, String who) {
		super(messageString);
		this.who = who;
	}

	@Override
	public String toString() {
		return "MyException [who=" + who + "]";
	}

}