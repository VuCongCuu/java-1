package ghifile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quanly {
	private static File f= new File("congcuufc.txt");
	private static List<Book> dsBook= new ArrayList<Book>();
	
	public static boolean addBook(Book book) {
		boolean res=false;
		if(book!=null) {
			dsBook.add(book);
			res=true;
		}
		
		return res;
		
	}
	public static List<Book> readFromFile(){
		List<Book> listDS= new ArrayList<Book>();
		try {
			FileReader fre= new FileReader(f);
			BufferedReader br= new BufferedReader(fre);
			String line="";
			while(true) {
				line=br.readLine();
				if(line==null) {
					break;
				}
				String txt[]= line.split(",");
				String id= txt[0];
				String name= txt[1];
				String author=txt[2];
				int price= Integer.parseInt(txt[3]);
				listDS.add(new Book(id, name, author, price));

			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listDS;
	}
	public static  void hienthi() {
		for(Book a:dsBook) {
			System.out.println(a);
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			menu();
			int choose= sc.nextInt();
			
			switch(choose) {
			case 1:
				System.out.println("1:them 1 cuon sach");
				Book sach= new Book();
				sach.nhap();
				try {
					FileWriter fw= new FileWriter(f,true);
					BufferedWriter bw= new BufferedWriter(fw);
					bw.write(sach.hienthi());
					bw.newLine();
					bw.close();
					fw.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				if(sach!=null) {
				System.out.println("Them file thanh cong");
				}
				break;
			case 2:
				System.out.println("2:hien thi du lieu tu file");
				try {
					FileReader fr= new FileReader(f);
					BufferedReader br= new BufferedReader(fr);
					String line="";
					while(true) {
						line=br.readLine();
						if(line==null) {
							break;
						}
						System.out.println(line);
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println("--------ghi file--------");
				List<Book> ds= readFromFile();
				if(ds!=null) {
					System.out.println("ghi thanh cong");
				}
				System.out.println("doc file");
				for(Book a:ds) {
					System.out.println(a.toString());
				}
				break;
				
			case 4:
				
				break;
//				System.out.println("doc");
//				for(Book a:ds) {
//					
//				}
			}
			if(choose==5) {
				break;
			}
		}
	}
	public static void menu(){
		System.out.println("1:them 1 cuon sach");
        System.out.println("2:ghi file");
        System.out.println("3:hien thi thu vien");
        System.out.println("4:hien thi thu vien tu file");
        System.out.println("5:thoat");
	}
}

