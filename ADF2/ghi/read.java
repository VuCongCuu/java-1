package ghi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class read {
	public static void main(String[] args) throws ClassNotFoundException {
		File filea= new File("congcuu.txt");
		List<book> dsbook= new ArrayList<book>();
		dsbook.add(new book(1,"conan tap1", 2));
		dsbook.add(new book(2,"conan tap2", 2));
		dsbook.add(new book(3,"conan tap3", 2));
		try(
				ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(filea));
				) {
			oos.writeObject(dsbook);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ghi file thanh cong");
		
		try (
				ObjectInputStream ois= new ObjectInputStream(new FileInputStream(filea));
				){
			Object obj= ois.readObject();
			if(obj instanceof ArrayList) {
				List<book> listds= (ArrayList<book>) obj;
				for(book a :listds) {
					System.out.println(a);
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
class book implements Serializable{
	private int id;
	private String name;
	private transient int price;
	public book(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}