package day05;

public class LabelEx01 {

	public static void main(String[] args) {
		int i, j ;
		for(i=1;i<=5;i++) {
			for(j=1;j<=5; j++){
				System.out.println(i*j +" ");
			}
			System.out.println();
		}
		// --- --- --- --- ---
		for(i=1;i<=5;i++) {
			for(j=1;j<=5; j++){
				System.out.println(i*j +" ");
				if(j==3) {
					break;
				}
			}
			System.out.println();
		}
		// --- --- --- --- ---
		A : for(i=1;i<=5;i++) {
			for(j=1;j<=5; j++){
				System.out.println(i*j +" ");
				if(j==3) {
					break A;
				}
			}
			System.out.println();
		}

	}

}
