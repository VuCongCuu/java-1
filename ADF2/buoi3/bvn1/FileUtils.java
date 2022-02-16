package buoi3.bvn1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FileUtils {
	public static void writeFile(String pathFile,String line) {
		try {
			FileWriter fileWriter= new FileWriter(pathFile, true);
			BufferedWriter buff= new BufferedWriter(fileWriter);
			buff.newLine();
			buff.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<String> readFile(String pathFile) {
			List<String> listLine= new ArrayList<String>();
			try {
				FileReader fileReader= new FileReader(pathFile);
				BufferedReader bufferedReader= new BufferedReader(fileReader);
				String line= null;
				try {
					while((line=bufferedReader.readLine())!=null){
						listLine.add(line);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listLine;
		
	}
}
