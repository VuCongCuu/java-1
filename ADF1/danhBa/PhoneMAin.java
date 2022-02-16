package danhBa;

import java.util.Scanner;

import buoi5.Book;
import buoi5.MainBookShelf;

public class PhoneMAin {
	public static void main(String[] args) {
		PhoneBook dsDanhBa = new PhoneBook();
		dsDanhBa.addPhone(new Phone("1", "0123456789"));
		dsDanhBa.addPhone(new Phone("2", "0123456788"));
		dsDanhBa.addPhone(new Phone("3", "0123456787"));
		dsDanhBa.addPhone(new Phone("4", "0123456786"));
		dsDanhBa.addPhone(new Phone("5", "0123456785"));
		dsDanhBa.showDanhBa();
	
//		dsDanhBa.removePhoneByName("2");
//		dsDanhBa.showDanhBa();
//		System.out.println(dsDanhBa.removePhoneByPhone("0123456789")); 
//		dsDanhBa.showDanhBa();
		System.out.println("---Quan ly ke sach");
		String confirm="";
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("1.Thêm 1 Phone vào danh sách");
			System.out.println("2.Hiển thị danh sách danh bạ");
			System.out.println("3.Cập nhật danh bạ theo tên ( người dùng nhập tên và sđt để cập nhật)");
			System.out.println("4.Xóa phone theo tên ( tên nhập từ bàn phím )");
			System.out.println("5.Xóa phone theo sđt ( stđ nhập từ bàn phím )");
			System.out.println("6.Tìm kiếm theo tên ");
			System.out.println("7.Exit ");
			int chose=sc.nextInt();
			switch(chose) {
				case 1:
					Phone p=new Phone();
					p.nhap();
					dsDanhBa.addPhone(p);
					break;
				case 2:
					dsDanhBa.showDanhBa();
					break;
				case 3:
					sc.nextLine();
					System.out.println("Nhap ten Ban muon sua");
					String name=sc.nextLine();
					System.out.println("Thay doi so dt");
					String sdtm=sc.nextLine();
					dsDanhBa.updatePhone(name, sdtm);
					break;
				default:
					System.out.println("nhap sai lua chon");
				}
			if(chose==7) {
				break;
			}
			System.out.println("ban co muon tiep tuc khong:");
			confirm=sc.nextLine();
		} while(!"n".equalsIgnoreCase(confirm));
		
		
	}
}
