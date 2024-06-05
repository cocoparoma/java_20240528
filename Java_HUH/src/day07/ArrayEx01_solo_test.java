package day07;
import java.util.*;
public class ArrayEx01_solo_test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int population = 3; 	int sum = 0; double avg = 0; int subject_num =3;
		String[] subject_type = new String[]  {"국어", "영어","수학"};
		int[][] student = new int[population][subject_num];
		double [] subject_avg = new double[subject_num];
		for(int i = 0; i < student.length ; i ++) {
			clearScreen();
			for(int j = 0; j < student.length ; j ++) {
				System.out.print("학생 " + (i+1) + "의 "+subject_type[j]+ " 점수를 입력해 주세요 : ");
				student[i][j] = sc.nextInt();		}		}
		for(int i = 0 ; i< student.length; i++) {
			sum = 0;
			for(int j = 0 ; j< student.length; j++) {
				sum += student[i][j];
				subject_avg[i] += student[j][i];		}
		}clearScreen();
		for(int i = 0; i < student.length;i++) {
			System.out.println("학생 "+ (i+1)+"은 각" + Arrays.toString(student[i])+ "점으로  총점은" + sum +"점 이고 평균은 "+ avg + "점 입니다.");
		}
		for(int i = 0; i < student.length;i++) {
			System.out.println(subject_type[i]+"평균 : "+ (subject_avg[i]/student.length));
		}
	}
	public static void clearScreen() {
		for (int powercleaner = 0; powercleaner < 80; powercleaner++)
			System.out.println("");
	}
}
