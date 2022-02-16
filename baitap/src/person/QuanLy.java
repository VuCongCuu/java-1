package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class QuanLy {
	private static List<Person> danhsach;
	private static File file= new File("D:\\T2104E\\baitap\\tailieu\\Nguoi.txt");
	private static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	
	public static List<Person> addList(){
		List<Person> ds= new ArrayList<Person>();
		try {
			FileReader fr= new FileReader(file);
			BufferedReader br= new BufferedReader(fr);
			String line="";
			while(true) {
				line=br.readLine();
				String txt[]=line.split(",");
				String name = txt[0];
				Date age= sdf.parse(txt[1]);
				String address= txt[2];
				ds.add(new Person(name, age, address));
				if(line==null) {
					break;
				}
				
			}			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc= new Scanner(System.in);
		while(true) {
			try {
				menu();
				System.out.println("Nhap lua chon");
				int choose= sc.nextInt();
				switch(choose) {
					case 1:
						System.out.println("Them vao file");
						Person ng= new Person();
						ng.nhap();
						FileWriter fw = new FileWriter(file,true);
						BufferedWriter bw= new BufferedWriter(fw);
						bw.write(ng.ghifile());
						bw.newLine();
						bw.close();
						fw.close();
						System.out.println("Ghi File thanh cong");
						break;
					case 2:
						System.out.println("Doc file");
						FileReader fr= new FileReader(file);
						BufferedReader br= new BufferedReader(fr);
						String line="";
						while(true) {
							line=br.readLine();
							if(line==null) {
								break;
							}
							System.out.println(line);
						}
						br.close();
						fr.close();
						break;
					case 3:
						System.out.println("3.Them vao list");
						danhsach= addList();
						System.out.println("them thanh cong");
						break;
					case 4:
						System.out.println("4.Doc list");
						if(danhsach!=null) {
							for(Person a:danhsach) {
								System.out.println(a.toString());
							}							
						} else {
							System.out.println("Chua co ban nao dk them vao list");
						}
						
						break;
					case 5:
						System.out.println("them vao file");
						try {
							FileOutputStream fos= new FileOutputStream(file);
							ObjectOutputStream oos= new ObjectOutputStream(fos);
							oos.writeObject(danhsach);
							oos.close();
							fos.close();
							System.out.println("Them file thanh cong");
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						
						break;
					case 6:
						System.out.println("Doc file");
						FileInputStream fis= new FileInputStream(file);
						ObjectInputStream ois=new ObjectInputStream(fis);
						Object obj= ois.readObject();
						if(obj instanceof ArrayList) {
							List<Person> ds= (ArrayList<Person>)obj;
							for(Person a:ds ) {
								System.out.println(a);
							}
							
						}
						break;
				}
				if(choose==7) {
					break;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Nhap cho dung(1-5)");
				sc.nextLine();
			}
		}
	}
	
	public static void menu() {
		System.out.println("1.Them vao file");
		System.out.println("2.Doc  file");
		System.out.println("3.Them vao list");
		System.out.println("4.Doc list");
		System.out.println("5.Thoat");
	}

}
