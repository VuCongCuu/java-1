package buoi5;

import java.util.Scanner;

public class BookShelf {
	private String maKe;
	private int viTri;
	private Book[] dsBook;
	private int index;

	public BookShelf() {
		this.dsBook = new Book[50];
		index = 0;
	}

	public String getMaKe() {
		return maKe;
	}

	public void setMaKe(String maKe) {
		this.maKe = maKe;
	}

	public int getViTri() {
		return viTri;
	}

	public void setViTri(int viTri) {
		this.viTri = viTri;
	}

	public Book[] getDsBook() {
		return dsBook;
	}

	public void setDsBook(Book[] dsBook) {
		this.dsBook = dsBook;
	}

	public void showDsBook() {
		for (Book b : this.dsBook) {
			if (b != null) {
				System.out.println(b.toString());
			}
		}
	}

	public void nhapBookShelf() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ke sach");
		System.out.println("Ma ke:");
		this.maKe = sc.nextLine();
		while (true) {
			System.out.println("Vi tri ke:");
			this.viTri = sc.nextInt();
			if (this.viTri > 0) {
				break;
			}
		}
		String confirm = "";
		sc.nextLine();
		while (true) {
			System.out.println("ban co muon tiep tuc hay khong:");
			confirm = sc.nextLine();
			if ("n".equals(confirm)) {
				break;
			}
			if (this.index == this.dsBook.length) {
				System.out.println("ke khong con cho trong");
				break;
			}
			Book book = new Book();
			book.nhapBook();
			this.dsBook[this.index++] = book;
		}
	}

	public boolean addBookToShelf(Book book) {
		if (book == null) {
			return false;
		}
		if (this.index == this.dsBook.length) {
			return false;
		}
		this.dsBook[this.index] = book;
		this.index++;
		return true;
	}

	public int addListBookToShelf(Book[] listBook) {
		if (listBook == null)
			return -1;
		if (this.index == this.dsBook.length) {
			return 0;
		}
		int i = 0;
		for (Book book : listBook) {
			if (this.index < this.dsBook.length) {
				this.dsBook[this.index++] = book;
				i++;
			}
		}

		return i;
	}

	public String toString() {
		return "Ke sach" + this.maKe + ", vi tri " + this.viTri + ",sl sach dang co:" + (this.index - 1);

	}

	public void xuatKeSach() {
		//in thong tin ke sach
		System.out.println(this);
		//in ra thong tin sach trong ke
		this.showDsBook();
	}
	//tim sach theo ma sach:quyen sach neeu tim thay
	public Book findBookByCode(String maSach) {
		if(maSach==null || maSach.length()==0) {
			return null;
		}
		for(int i=0;i<this.index;i++) {
			if(maSach.equalsIgnoreCase(this.dsBook[i].getCode())) {
				return this.dsBook[i];
			}
		}
		return null;
	}
	
}
