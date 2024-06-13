package day12;

public class InterFaceInheritanceEx01 {

	public static void main(String[] args) {
		
	}

}
interface interfacePA{
	void print();
	void test1();
}
interface interfacePB{
	void print();
	void test1();
}
//print()  메소드가 겹치는데 상속을 받으면 어차피 구현부가 없어어 하나로 합치면 되기 때문에
//다중 상속이 가능(인터페이스는)
interface interfacePC extends interfacePA, interfacePB{
	
	
}

class classA{
	void print() {}
	void test1() {}
}

class classB{
	void print() {}
	void test2() {}
}

class classC extends classA {

}