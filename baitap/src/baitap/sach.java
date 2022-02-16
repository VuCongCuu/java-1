package baitap;

import java.io.Serializable;
import java.util.Scanner;

public class sach implements Serializable {
	private String bookID;
	private String bookName;
	private String author;
	private int price;
	public sach(String bookID, String bookName, String author, int price) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}
	public sach() {
		super();
	}
	Scanner sc= new Scanner(System.in);
	public void nhap() {
		System.out.println("Book ID:");
		this.bookID=sc.nextLine();
		System.out.println("Name :");
		this.bookName=sc.nextLine();
		System.out.println("Tac Gia:");
		this.author=sc.nextLine();
		sc.nextLine();
		System.out.println("Gia:");
		this.price=sc.nextInt();		
	}
	@Override
	public String toString() {
		return "sach [bookID=" + bookID + ", bookName=" + bookName + ", author=" + author + ", price=" + price + "]";
	}
	public String hienthi() {
		return  bookID + "," + bookName + "," + author + "," + price;
	}
	
	
	
}
