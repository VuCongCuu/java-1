//package buoi3.bvn1;
//
//import java.io.Serializable;
//import java.util.Scanner;
//
//public class DanhBa implements Serializable {
// private String name;
// private String sdt;
// Scanner sc=new Scanner(System.in);
//	public DanhBa() {
//		super();
//	}
//	public DanhBa(String name, String sdt) {
//		super();
//		this.name = name;
//		this.sdt = sdt;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getSdt() {
//		return sdt;
//	}
//	public void setSdt(String sdt) {
//		this.sdt = sdt;
//	}
//	public void nhap() {
//		System.out.println("Nhap ten:");
//		this.name= sc.nextLine();
//		while(true) {
//			System.out.println("Nhap SDT:");
//			String sdtm=sc.nextLine();
//			if(sdtm.length()!=10) {
//				System.out.println("So dien thoai phai co 10 ky tu");
//			} else if(!sdtm.startsWith("0")) {
//				System.out.println("sdt bat dau bang 0");
//			} else {
//				try {
//					long sdt_l= Long.parseLong(sdtm);
//					setSdt(sdtm);				
//				} catch (Exception e) {
//					// TODO: handle exception
//					System.out.println("sdt phai la 10 ky tu so");
//				}
//			}
//			if(getSdt()!=null) break;
//		}
//	}
//	@Override
//	public String toString() {
//		return "DanhBa [ Name=" + name + " | SDT=" + sdt + "]";
//	}
//	
//}
