package day13.homework;

import java.util.Comparator;

public class PhoneEx01 {
	
	public static void main(String[] args) {
	
	
	
	
	
	}

}



//DecimalFormat 으로 3,4,4 형식으로 받아주고
//StringTokenizer 으로 토큰식으로 끊어서 저장해주자
//MessageFormat 으로 출력해주면 오케이
class Contact implements Comparator<Contact>{
	String nameString, phoneString;

	public Contact(String nameString, String phoneString) {
		this.nameString = nameString;
		this.phoneString = phoneString;
	}

	@Override
	public String toString() {
		return "Contact [nameString=" + nameString + ", phoneString=" + phoneString + "]";
	}

	@Override
	public int compare(Contact o1, Contact o2) {
		
		
		return 0;
	}

}