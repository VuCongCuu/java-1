package buoi3.bvn1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;




public class QuanLyDanhBa {

	private static Set<DanhBa> listDanhBa= new TreeSet<DanhBa>(new Comparator<DanhBa>() {
		@Override
		public int compare(DanhBa o1, DanhBa o2) {
			// TODO Auto-generated method stub
			int checksdt=o1.getSdt().compareTo(o2.getSdt());
			if(checksdt==0) return 0;
			int checkName=o1.getName().compareTo(o2.getName());
			if(checkName==0) return 1;
			return checkName;
		}
		
	});

	public static DanhBa timDanhBa(String b) {
		if(b== null) return null;
		for(DanhBa danhba:listDanhBa) {
			if(danhba.getSdt().equals(b))
				return danhba;
		}
		return null;
	}
	 
	 public static void main(String[] args) {
		 File dbF= new File("danhba1.txt");
			if(!dbF.exists()) {
				try {
					dbF.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		 Scanner sc= new Scanner(System.in);
		
		while(true) {
			DanhBa a = new DanhBa();
			System.out.println("1.them danh ba");
			System.out.println("2.tim danh ba theo so");
			System.out.println("3.Hiem thi list danh ba");
			System.out.println("4.xoa danh ba theo sdt");
			System.out.println("5.Them Vao File");
			System.out.println("6.Doc file");
			System.out.println("7.Thoat");
			int choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
				case 1: 
					System.out.println("--------them danh ba-----------");
					a.nhap();
					System.out.println(listDanhBa.add(a)?"Them thanh cong":"SDT da co trong danh ba");
					
					break;
				case 2:	
					System.out.println("--------tim danh ba theo so----------");
					System.out.println("Nhap sdt:");
					DanhBa sd= timDanhBa(sc.nextLine());
					if(sd!=null) {
						System.out.println(sd.toString());
					} else {
						System.out.println("Khong ton tai");
					}
					break;
				case 3:
					System.out.println("------Hiem thi list danh ba---------");
					if(listDanhBa.size()!=0) {
						for(DanhBa danhba:listDanhBa) {
						System.out.println(danhba.toString());
						}
					} else {
						System.out.println("Chua co dang ba nao duoc luu");
					}
					break;
				case 4:
					System.out.println("Nhap sdt:");
					DanhBa ssd= timDanhBa(sc.nextLine());
					if(ssd!=null) {
						System.out.println(listDanhBa.remove(ssd)==true?"xoa thanh cong":"Khong thanh cong");
						
					} else {
						System.out.println("Khong ton tai");
					}
				
					break;
				case 5:				
				try (
						ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(dbF));
						){
					List<DanhBa> dsbook= new ArrayList<DanhBa>(listDanhBa);
					oos.writeObject(dsbook);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
							
					System.out.println("ghi file thanh cong");
					break;
				case 6:
					System.out.println("-----Doc file-----");
					List<DanhBa> list= new ArrayList<DanhBa>(listDanhBa);
					try(
							ObjectInputStream ois= new ObjectInputStream(new FileInputStream(dbF));
							
							) {
						Object obj= ois.readObject();
												
						if(obj instanceof ArrayList) {
							List<DanhBa> listds=(ArrayList<DanhBa>)obj;
							for(DanhBa b: list) {
								System.out.println(b);
							}
						}
						
					} catch (IOException | ClassNotFoundException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
					break;
			}
			if(choose==7) {
				break;
			}			
		}
	}

}
class DanhBa implements Serializable {
private String name;
private String sdt;
Scanner sc=new Scanner(System.in);
	public DanhBa() {
		super();
	}
	public DanhBa(String name, String sdt) {
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
	public void nhap() {
		System.out.println("Nhap ten:");
		this.name= sc.nextLine();
		while(true) {
			System.out.println("Nhap SDT:");
			String sdtm=sc.nextLine();
			if(sdtm.length()!=10) {
				System.out.println("So dien thoai phai co 10 ky tu");
			} else if(!sdtm.startsWith("0")) {
				System.out.println("sdt bat dau bang 0");
			} else {
				try {
					long sdt_l= Long.parseLong(sdtm);
					setSdt(sdtm);				
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("sdt phai la 10 ky tu so");
				}
			}
			if(getSdt()!=null) break;
		}
	}
	@Override
	public String toString() {
		return "DanhBa [ Name=" + name + " | SDT=" + sdt + "]";
	}
	
}

