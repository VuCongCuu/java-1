package buoi1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GhiFile {
	public static void main(String[] args) {
		try {
			File myObj= new File("filename.txt");
			String  a="Anh Yeu Em";
			FileWriter fw= new FileWriter(myObj);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(a);
			bw.close();
			fw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
