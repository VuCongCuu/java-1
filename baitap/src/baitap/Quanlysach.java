package baitap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quanlysach {
	private static File file= new File("demo.txt");
	private static List<sach> danhsach= new ArrayList<sach>();
	
	public boolean addDs(sach sach) {
		boolean res= false;
		if(sach!=null) {
			danhsach.add(sach);
			res= true;
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			menu();
			System.out.println("Nhap lua chon");
			int choose = sc.nextInt();
			switch(choose) {
			case 1 :
				System.out.println("1:them 1 cuon sach vao file");
					sach s= new 
				break;
			case 2 :
							
				break;
			case 3 :
				
				break;
			case 4 :
				
				break;
			}
			
			if(choose==5) {
				break;
			}
		}
	}
	
	public static void menu() {
		System.out.println("1:them 1 cuon sach");
        System.out.println("2:ghi file");
        System.out.println("3:hien thi thu vien");
        System.out.println("4:hien thi thu vien tu file");
        System.out.println("5:thoat");
	}
}
