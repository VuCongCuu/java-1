package ghifile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main(String[] args) {
		String rootPath="D:\\T2104E\\tailieu";
		String pt= System.getProperty("user.dir");
		File sky= new File("sach.txt");
		System.out.println("Ton tai?: " + sky.exists());
		try(
				ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(sky));
				) {
				Book sach= new Book("1","1","1", 1);
				List<Book> listbook= new ArrayList<Book>();
				listbook.add(sach);
				oos.writeObject(listbook);
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("them thanh cong");

	}
}
