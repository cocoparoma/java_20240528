package day13;

import java.text.DecimalFormat;

public class DecimalFormatEx01 {

	public static void main(String[] args) {
		
		int su1 = 123456789 ; 
		
		DecimalFormat df1 = new DecimalFormat("00000000000");
		System.out.println(df1.format(su1));
		
		DecimalFormat df2 = new DecimalFormat("###,###,###,###");
		System.out.println(df2.format(su1));
		
		DecimalFormat df3 = new DecimalFormat("#.##%");
		System.out.println(df3.format(su1));
		
		DecimalFormat df4 = new DecimalFormat("\u00A4####.##");
		
		System.out.println(df4.format(su1));
		
		double su2 = 12.3456;
		DecimalFormat df5 = new DecimalFormat("#.##");
		System.out.println(df5.format(su2));
	}

}
