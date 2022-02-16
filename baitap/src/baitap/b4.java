package baitap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class b4 {
	public static void main(String[] args) {
		File file= new File("D:\\T2104E\\baitap\\tailieu\\caolan.txt");
		people ng= new people();
		ng.nhap();
		try {
			FileWriter fw= new FileWriter(file,true);
			BufferedWriter bw= new BufferedWriter(fw);
			bw.write(ng.toString());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ghi file thanh cong");
		System.out.println("doc file");
		try {
			FileReader fr= new FileReader(file);
			BufferedReader br= new BufferedReader(fr);
			String lent="";
			while(true) {
				lent= br.readLine();
				if(lent==null) {
					break;
				}
				System.out.println(lent);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
class people implements Serializable {
	private String name;
	private int age;
	public people(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public people() {
		super();
	}
	@Override
	public String toString() {
		return  name + "|" + age ;
	}
	Scanner sc=new Scanner(System.in);
	public void nhap() {
		System.out.println("Name:");
		this.name=sc.nextLine();
		System.out.println("Age");
		this.age=sc.nextInt();
	}
	
	
}
