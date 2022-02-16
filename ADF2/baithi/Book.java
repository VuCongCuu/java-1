package baithi;

import java.util.Scanner;

public class Book {
	private String bookID;
    private String name;
    private String tacGia;
    private int price;

    public Book() {
        super();
    }

    public Book(String bookID, String name, String tacGia, int price) {
        super();
        this.bookID = bookID;
        this.name = name;
        this.tacGia = tacGia;
        this.price = price;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void NhapTT() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap id sach: ");
        this.bookID = sc.nextLine();
        System.out.println("nhap ten sach: ");
        this.name = sc.nextLine();
        System.out.println("nhap ten tac gia sach: ");
        this.tacGia = sc.nextLine();
        System.out.println("nhap gia sach: ");
        this.price = sc.nextInt();
    }

    @Override
    public String toString() {
        return "Book [bookID=" + bookID + ", name=" + name + ", tacGia=" + tacGia + ", price=" + price + "]";
    }


}
