package buoi9.designPattern.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baimau {
	public static void main(String[] args) {
		List<Book> dsBook= new ArrayList<Book>();		
		Scanner sc= new Scanner(System.in);
		File file= new File("book1.dat");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(true) {
		menu();
		System.out.println("chon");
		int choose= sc.nextInt();
		Book book= new Book();
			switch(choose) {
			case 1:
				System.out.println("them 1 cuon sach");
				book.addbook();
				dsBook.add(book);
				break;
			case 2:
				try(
						ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(file));
						) {
					oos.writeObject(dsBook);
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("3:hien thi thu vien");
				for(Book a :dsBook) {
					System.out.println(a);
				}
				break;
			case 4:
				
				break;
			}
			if(choose==4) {
				break;
			}
		}
		
	}
	public static void menu(){
		System.out.println("1:them 1 cuon sach");
        System.out.println("2:ghi file");
        System.out.println("3:hien thi thu vien");
        System.out.println("4:thoat");
	}
}

class Book implements Serializable{
	private String bookID;
	private String bookName;
	private String author;
	private int price;
	public Book() {
		super();
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
	public void addbook() {
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
		return "Book [bookID=" + bookID + ", bookName=" + bookName + ", author=" + author + ", price=" + price + "]";
	}
	
}
