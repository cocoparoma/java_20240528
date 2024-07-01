package day24;

import program.program;

public class Ex15 {

	public static void main(String[] args) {
		TestProgram tp = new TestProgram();
		tp.run();
	}

}
/**
 * 추상매소드 추가 안해서
 * 가로 열린 친구들 말고 안열린친구들로만
 */

class TestProgram implements program{

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runMenu(int menu) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		System.out.println("running");
	}
	
}