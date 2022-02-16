package buoi5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Book {
	private String title;
	private Author author;
	private double price;
	private Date publishDate;
	private String category;
	private String code;
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public Book() {
		this.author=new Author();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category.toUpperCase();
	}
	public void nhapBook(){
		System.out.println("Nhap Book:");
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap ten sach");
		this.title =sc.nextLine();
		System.out.println("Ma sach");
		this.code=sc.nextLine();
		this.author.nhaptt();
		do {
		System.out.println("Ngay phat hanh(dd/MM/yyyy):");
		try {
			this.publishDate=sdf.parse(sc.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} while(this.publishDate == null);
		while(true) {
			System.out.println("Nhap gia :");
			this.price=sc.nextInt();
			if(this.price>0) {
				break;
			}
		}
		sc.nextLine();
		while(true){
			System.out.println("Nhap the loai(VH,TT,DL,KH,NT) :");
			this.category=sc.nextLine();
			if(this.checkCategory()) {
				break;
			}
		}
	}
	private boolean checkCategory() {
		String[] catogories= {"VH","TT","DL","KH","NT"};
		for(String cate : catogories) {
			if(cate.equals(this.category)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "Book [title=" + title 
				+",code = "+code 
				+ ", author=" + author.toString() 
				+ ", price=" + price 
				+ ", publishDate=" + sdf.format(this.publishDate)
				+ ", category=" + category + "]";
	}
	
}
