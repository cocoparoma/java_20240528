package day14;

import java.util.Iterator;
import java.util.List;

public class GenericEx01 {

	public static void main(String[] args) {
		Array<String> list1 = new Array<>(10);
		list1.set(0, "안녀엉");
		list1.set(1, "사과");

		list1.print();

//		for(String tmpString : list1.getList()) {
//			if (tmpString != null) {
//				System.out.println(tmpString);
//			}
//		}

		Array<Integer> list2 = new Array<>(10);
		list2.set(0, 1);
		list2.set(1, 10);

		list2.print();

//		for(Integer tmpString : list2.getList()) {
//			if (tmpString != null) {
//				System.out.println(tmpString);
//			}
//		}
		String[] list3 = new String[10];
		list3[0] = "안녕";
		list3[1] = "귤";
		list3[2] = "커피";
		
		Integer[] list4 = new Integer[10];
		list4[0] = 100;
		list4[1] = 1000;
		
		printArray(list3);
		printArray(list4);
	}


	public static <T> void printArray(T[] array) {
		for (T eT : array) {
			if (eT != null) {
				System.out.println(eT);
			}
		}

	}
}

class Array<T> {
	private T[] list;

	public void setList(T[] list) {
		this.list = list;
	}

	public T[] getList() {
		return list;
	}

	@SuppressWarnings("unchecked")
	public Array(int size) {
		list = (T[]) new Object[size];
	}

	public void set(int index, T data) {
		if (index >= list.length) {
			return;
		}
		list[index] = data;
	}

	public T get(int index) {
		if (index >= list.length || index < 0) {
			return null;
		}
		return list[index];
	}

	public void print() {
		for (int i = 0; list.length > i; i++) {
			if (list[i] != null) {
				System.out.println(list[i]);
			}
		}
	}
}

class Test<A, B> {
	private A data1;
	private B data2;
}