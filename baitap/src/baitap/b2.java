package baitap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.Scanner;

public class b2 {
	public static void main(String[] args) {
		File file= new File("anhduc.txt");
		book b= new book();
		b.nhap();
		try {
			FileWriter fw= new FileWriter(file,true);
			BufferedWriter bw= new BufferedWriter(fw);
			bw.write(b.toString());
			bw.newLine();
			bw.close();
			fw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("them thanh cong");
		//doc file
		try {
			FileReader fr= new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
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
	}
}
class book implements Serializable{
	Scanner sc= new Scanner(System.in);
	private int id;
	private String name;
	private transient int price;
	public book() {
		super();
	}
	public book(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public void nhap() {
		System.out.println("id");
		this.id=sc.nextInt();
		sc.nextLine();
		System.out.println("name");
		this.name=sc.nextLine();
		System.out.println("gia");
		this.price=sc.nextInt();
	}
	@Override
	public String toString() {
		return  id + ", name=" + name + ", price=" + price + "]";
	}	
}
