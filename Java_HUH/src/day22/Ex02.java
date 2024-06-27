package day22;

public class Ex02 {

	public static void main(String[] args) {
		 /* str = sc.nextLint();
		 *  String [] words = str.split(" "); 
		 *  syso(words.legth):
			 */
			 int sum = 0;
			 String str = "1 23 45 3 9 7 5";
			 String[] words = str.split(" ");
			 for (int i = 0; i < words.length; i++) {
				sum = sum + sintP(words[i]);
			}
			 System.out.println(str+" 문자열의 합");
			 System.out.println("sum : "+ sum);
	}

	public static int sintP (String a){
        int h;
        try {
             h = Integer.parseInt(a);
        } catch (Exception e) {
            System.out.println("숫자를 입력하시오");
            return -1;
        }
        return h;// -1출력될시 오류
    }
	
	public String[] splitString(String str) {
		String[] words = str.split(" ");
		return words;
	}
	
	
	
	
	
	
	
}
