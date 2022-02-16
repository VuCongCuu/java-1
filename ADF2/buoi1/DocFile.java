package buoi1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DocFile {
public static void main(String[] args) {
	File file=new File("data.txt");
	Scanner sc = null;
	try {
		sc= new Scanner(file);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
		//giai phong ket noi
		if(sc != null)
		sc.close();
		System.out.println("Vao finally");
	}	
}
}
