package baitap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class b5 {
	private static File file= new File("tailieu\\congcuu.txt");
	private static List<person> dsPerson;
	private static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
//	public static List<person> array(){
//		List<person> list= new ArrayList<person>();		
//			try {
//				FileReader fr= new FileReader(file);
//				BufferedReader br= new BufferedReader(fr);
//				String linee="";
//				while(true) {
//					linee=br.readLine();
//					String txt[]=linee.split(",");
//					String name= txt[0];
//					Date age= sdf.parse(txt[1]);
//					String address= txt[2];
//					int nam= Integer.parseInt(txt[3]);
//					
//					list.add(new person(name, age, address, nam));
//					if(linee==null) {
//						break;
//					}
//				}
//				br.close();
//				fr.close();
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		
//		return list;
//	}
	public static List<person> addList(){
		List<person> ds= new ArrayList<person>();
		try {
			FileReader fr= new FileReader(file);
			BufferedReader br= new BufferedReader(fr);
			String line="";
			while(true) {
				line=br.readLine();
				String txt[]=line.split(",");
				String name= txt[0];
				Date age= sdf.parse(txt[1]);
				String address= txt[2];
				int nam= Integer.parseInt(txt[3]);				
				ds.add(new person(name, age, address, nam));
				if(line==null) {
					break;
				}
				
			}			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			menu();
			int choose= sc.nextInt();
			switch (choose) {
				case 1:
					System.out.println("Ghi file");
					person ng= new person();
					ng.nhap();
					try {
						FileWriter fw= new FileWriter(file, true);
						BufferedWriter bw= new BufferedWriter(fw);
						bw.write(ng.ghifile());
						bw.newLine();
						bw.close();
						fw.close();
						System.out.println("Ghi file thanh cong");
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				
					break;
				case 2:
						System.out.println("Doc file");		
						try {
							FileReader fr= new FileReader(file);
							BufferedReader br= new BufferedReader(fr);
							String line="";
							while(true) {
								line= br.readLine();
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
					System.out.println("Ghi file vao ArrayList");
					dsPerson= addList();
					
					break;
				case 4:
					if(dsPerson!=null) {
						for(person a : dsPerson) {
							System.out.println(a);
						}						
					} else {
						System.out.println("Chua co person nao duoc ghi");
					}
					break;
			}
			if(choose==5) {
				break;
			}
			
		}
		
	}
	public static void menu() {
		System.out.println("1.Ghi file");
		System.out.println("2.Doc file");
		System.out.println("3.Luu file vao ArrayList");
		System.out.println("4.Doc file tu list");	
		System.out.println("5.Thoat");
		System.out.println("Nhap lua chon");
	}
}


class person implements Serializable {
	private String Name;
	private Date Age;
	private String Address;
	private int Yead;
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	public person(String name, Date age, String address, int yead) {
		super();
		Name = name;
		Age = age;
		Address = address;
		Yead = yead;
	}
	public person() {
		super();
	}
	public void nhap() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Name:");
		this.Name= sc.nextLine();
		sc.nextLine();
		System.out.println("Age:");
		try {
			this.Age= sdf.parse(sc.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Addres:");
		this.Address= sc.nextLine();
		sc.nextLine();
		System.out.println("Yead");
		this.Yead=sc.nextInt();		
	}
	@Override
	public String toString() {
		return "person [Name=" + Name + ", Age=" + sdf.format(Age) + ", Address=" + Address + ", Yead=" + Yead + "]";
	}
	
	public String ghifile() {
		return Name + "," + sdf.format(Age) + "," + Address + "," + Yead;
	}
	
	
	
	
}
