package buoi1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NgoaiLeDemo {
public static void main(String[] args) {
	File file= new File("tailieu\\ngoaile.txt");
	try {
		Scanner sc=new Scanner(file);
		while(sc.hasNextLine()) {
			String line =sc.nextLine();
			System.out.println(line);
		}
		sc.close();
		System.out.println("ketthuc");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		System.out.println("vao finally");
	}
	
	
	
}
}
