package baitap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class b1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		File danhbaFile= new File("danhbafile.txt");
		if(!danhbaFile.exists()) {
			//new khong phai file thi tao ra file moi
			try {
				danhbaFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(true) {
			try {
				menu();
				int choose= sc.nextInt();
				switch(choose) {
				case 1:
					FileWriter fw= new FileWriter(danhbaFile,true);
					PrintWriter pw= new PrintWriter(fw);
					DanhBaa danhba= new DanhBaa();
					System.out.println(" Thêm 1 danh bạ");
					danhba.nhapTT();
					pw.println(danhba.toString());
					pw.close();	
					break;
				case 2:
					System.out.println("2. Hiển thị danh bạ");
					FileReader fr= new FileReader(danhbaFile);
					Scanner doc= new Scanner(fr);
					while(doc.hasNext()) {
						System.out.println(doc.nextLine());
					}	
					doc.close();
					break;
				case 3:
					 System.out.println("3. Lưu danh sách danh bạ");
	                    // danh ba to arraylist
	                    FileReader fr1 = new FileReader(danhbaFile);
	                    Scanner docc = new Scanner(fr1);
	                    ArrayList<DanhBaa> danhBaList = new ArrayList<DanhBaa>();
	                    while (docc.hasNextLine()) {
	                    	 String[] arr= docc.nextLine().split(" : ");
	                    	 DanhBaa db= new DanhBaa(arr[0], arr[1]);
	                    	 danhBaList.add(db);
	                    }
	                    
                    docc.close();
//	                    // duyet list
	                    System.out.println("danh sach danh ba trong arlisst");
	                    for (DanhBaa danhBa2 : danhBaList) {
	                        System.out.println(danhBa2.toString());
	                    }
	                    break;
				case 4:
					System.out.println("4. Tìm danh bạ theo sđt");
					System.out.println("Nhap sdt");
					sc.nextLine();
					Boolean check=false;
					String sd= sc.nextLine();
					FileReader fr2= new FileReader(danhbaFile);
					Scanner doccv= new Scanner(fr2);
					while(doccv.hasNextLine()) {
						String[] a= doccv.nextLine().split(" : ");
						DanhBaa b= new DanhBaa(a[0], a[1]);
						if(b.getSdt().equals(sd)) {
							System.out.println(b.toString());
							check=true;
						}
					}
					if(check==false) {
						System.out.println("khong ton tai");
					}
				case 5:
					System.out.println("5. xoa file");
					System.out.println(danhbaFile.delete()==true?"xoa thanh cong":"xoa khong thanh cong");
					break;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("nua chon khong hop le");
			}
		}
		
	}
	public static void menu() {
		  System.out.println("---------MAIN MENU---------");
	        System.out.println("1. Thêm 1 danh bạ");
	        System.out.println("2. Hiển thị danh bạ");
	        System.out.println("3. Lưu danh sách danh bạ");
	        System.out.println("4. Tìm danh bạ theo sđt");
	        System.out.println("5. Xóa file danh bạ");
	        System.out.println("6. Thoát");
	}
}
class DanhBaa implements Serializable{
	private String  name; 
	private String  sdt;	
	Scanner sc= new Scanner(System.in);
	public DanhBaa() {
		super();
	}	
	public DanhBaa(String name, String sdt) {
		super();
		this.name = name;
		this.sdt = sdt;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	} 
	public void nhapTT() {
		System.out.println("Name :");
		this.name=sc.nextLine();
		while(true) {
			String sdtl;
			System.out.println("SDT:");
			sdtl=sc.nextLine();
			if(sdtl.length()!=10) {
				System.out.println("SDT 10 ky tu");
			} else if(!sdtl.startsWith("0")) {
				System.out.println("SDT bat dau bang 0");
			} else {
				try {
					long sdtL= Long.parseLong(sdtl);
					setSdt(sdtl);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("SDT 10 ky tu so");
				}
				
			}
			if(getSdt()!= null) {
				break;
			}
		}
		
	}
	@Override
	public String toString() {
		return name + " : " + sdt;
	}
	
	
}