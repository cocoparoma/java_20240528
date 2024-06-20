package day17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectStreamEx01 {

	public static void main(String[] args) {
		String filename = "src/day17/objectStream.txt";
		List<Point> points = Arrays.asList(
				new Point(1, 10 , 1),
				new Point(3, 3 , 2),
				new Point(5, 5 , 3),
				new Point(10, 5 , 4)
				);
		try(FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream oos = new ObjectOutputStream(fos) ) {
			
			for (Point tmp : points) {
				oos.writeObject(tmp);
			}
						
		} catch (Exception e) {
			System.out.println("예외");
		}
		
		List<Point> points2 = new ArrayList<Point>();
		
		try(FileInputStream fis = new FileInputStream(filename);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			Point tmp;
			do {
				tmp = (Point)ois.readObject();
				if(tmp != null) {
					points2.add(tmp);
				}
			} while (tmp != null);
			
		} catch (Exception e) {
			System.out.println("예외");
		}
		System.out.println(points2);
	}

}
