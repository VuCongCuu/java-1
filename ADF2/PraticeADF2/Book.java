package PraticeADF2;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private float price;

    // ------------- construct ------------------

    public Book(String bookId, String bookName, String author, float price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    public Book() {
    }

    // --------- set , get -----------------

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void nhapTT(Scanner sc) {
        System.out.println("Nhap thong tin sach");
        System.out.print("Nhap id sach: ");
        this.bookId = sc.nextLine();

        System.out.print("Nhap Ten sach: ");
        this.bookName = sc.nextLine();

        System.out.print("Nhap ten tac gia: ");
        this.author = sc.nextLine();

        System.out.print("Nhap gia sach: ");

        try {
            this.price = sc.nextFloat();
            sc.nextLine();
            if (this.price < 0) {
                System.out.println("gia sach khong duoc la so am");
                System.out.println("Gia sach mac dinh la: 0");
            }
        } catch (Exception e) {
            sc.nextLine();
            this.price = 0;
            System.out.println("Gia sach khong duoc chua ky tu");
            System.out.println("Gia sach mac dinh la: 0");

        }
    }

    @Override
    public String toString() {
        return "book [author=" + author + ", bookId=" + bookId + ", bookName=" + bookName + ", price=" + price + "]";
    }

}
