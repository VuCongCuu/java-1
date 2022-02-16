package chuabaitap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sach {
	public static void main(String[] args) {
		File filel= new File("sach.txt");
		try (
				ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(filel));
				){
			List<Book> listDs= new ArrayList<Book>();
			Book sach= new Book();
			sach.nhap();
			listDs.add(sach);
			oos.writeObject(listDs);
				
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("them thanh cong");
	}
	
}
class Book implements Serializable{
	private int id;
	private String name;
	Scanner sc= new Scanner(System.in);
	public Book() {
		super();
	}
	public Book(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public void nhap() {
		System.out.println("id");
		this.id=sc.nextInt();
		sc.nextLine();
		System.out.println("name");
		this.name=sc.nextLine();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
	
}
