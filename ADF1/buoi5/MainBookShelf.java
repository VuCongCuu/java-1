package buoi5;

import java.util.Scanner;

public class MainBookShelf {
	public static void main(String[] args) {
		BookShelf shelf =new BookShelf();
		System.out.println("---Quan ly ke sach");
		String confirm="";
		Scanner sc=new Scanner(System.in);
		do {
			//mo dau
			System.out.println("1.nhap thong tin ke sach");
			System.out.println("2.hien thi thong tin ke sach");
			System.out.println("3.them 1 quen sach vao ke");
			System.out.println("4.them mot tap sach vao ke");
			System.out.println("5.Tim sach tu ke sach");
			System.out.println("6.Thoat");
			System.out.println("Nhap lua chon : ");
			int choose=sc.nextInt();
			switch(choose) {
			case 1:
				System.out.println("1.nhap thong tin ke sach");
				shelf.nhapBookShelf();
				break;
			case 2:
				System.out.println("2.hien thi thong tin ke sach");
				shelf.xuatKeSach();
				break;
			case 3:
				System.out.println("3.them 1 quen sach vao ke");
				Book newBook=new Book();
				newBook.nhapBook();
				if(shelf.addBookToShelf(newBook)) {
					System.out.println("Them 1 cuon sach thanh cong");
				} else {
					System.out.println("Them 1 cuon sach khong thanh cong");
				}
				
				break;
			case 4:
				System.out.println("4.them mot tap sach vao ke");
				MainBookShelf.MainCase4(shelf);
				break;
			case 5:
				System.out.println("5.Tim sach tu ke sach");
				MainCase5(shelf);
				break;
			case 6:
				System.out.println("6.Thoat");
				break;
			default :
				System.out.println("khong hop le");
				break;
			
			}
			if(choose==6) {
				break;
			}
			System.out.println("ban co muon tiep tuc khong:");
			confirm=sc.nextLine();
		} while(!"n".equalsIgnoreCase(confirm));
		
	}
	public static void MainCase4(BookShelf shelf) {
		Scanner sc=new Scanner(System.in);
		int soluong=0;
		do {
		System.out.println("Ban muon tao bao nhieu quyen sach:");
		 soluong=sc.nextInt();
		} while(soluong<=0);
		Book[] inputBooks = new Book[soluong];
		for(int i=0;i<soluong;i++) {
			Book book=new Book();
			book.nhapBook();
			inputBooks[i]=book;
		}
		int slbookadded=shelf.addListBookToShelf(inputBooks);
		System.out.println("Co" +slbookadded+"da them vao ke thanh cong");
		
	}
	public void test() {
		System.out.println("test");
	}
	public static void MainCase5(BookShelf shelf) {
		Scanner sc=new Scanner(System.in);
		//nhap ma sach can tim
		System.out.println("Nhap ma sach can tim");
		String maSach=sc.nextLine();
		//tim quyen sach trong ke
		Book result =shelf.findBookByCode(maSach);
		if(result==null) {
			System.out.println("Ma sach" + maSach+" khong tim thay");
		} else {
			System.out.println("Sach can tim" +result);
		}
	}
}
