package ghifile;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
	private String bookID;
	private String bookName;
	private String author;
	private int price;
	public Book() {
		super();
	}
	
	public Book(String bookID, String bookName, String author, int price) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	Scanner sc= new Scanner(System.in);
	public void nhap() {
		System.out.println("Nhap ID:");
		this.bookID=sc.nextLine();
		System.out.println("Nhap ten Sach:");
		this.bookName=sc.nextLine();
		System.out.println("Nhap ten tac gia:");
		this.author=sc.nextLine();
		while(true) {			
			try {
				System.out.println("Nhap gia sach:");
				this.price=sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Nhap ky tu so");
				sc.nextLine();
			}
			if(getPrice()!=null) {
				break;
			}
		}		
	}


	@Override
	public String toString() {
		return "Book [ ID :" + bookID + " | BookName=" + bookName + " | Author=" + author + " | Price=" + price + "]";
	}

	public String hienthi() {
		return bookID + "," + bookName + "," + author + "," + price ;
	}
	
	
}
