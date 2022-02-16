package buoi3;

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
import java.util.Scanner;

public class ReadWriteObj {
	public static void main(String[] args) {
		File objFile= new File("bookbok.txt");
		// ghi file
		//b1 tao stream ket noi file//b3 dong stream
		try (				
				ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(objFile));
				){
			//b2 ghifile
			
			List<book> dsbook= new ArrayList<book>();
			book b= new book();
			b.nhap();
			dsbook.add(b);
			oos.writeObject(dsbook);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		//docfile
	}
		System.out.println("ghi file thanh cong");
		try(
				ObjectInputStream ois= new ObjectInputStream(new FileInputStream(objFile));
				) {		
					Object obj= ois.readObject();
				if(obj instanceof ArrayList) {
					List<book> listds=(ArrayList<book>)obj;
					for(book b: listds) {
						System.out.println(b);
					}
				}
				
		} catch (IOException | ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
}
class book implements Serializable{
	Scanner sc= new Scanner(System.in);
	private int id;
	private String name;
	private transient int price;
	public book() {
		super();
	}
	public book(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public void nhap() {
		System.out.println("id");
		this.id=sc.nextInt();
		sc.nextLine();
		System.out.println("name");
		this.name=sc.nextLine();
		System.out.println("gia");
		this.price=sc.nextInt();
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	
}