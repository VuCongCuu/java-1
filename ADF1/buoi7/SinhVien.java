package buoi7;

import java.util.Date;
import java.util.Scanner;

public class SinhVien extends Nguoi {
	private String maSV;
	private String maLop;
	public SinhVien() {
		super();
	}
	public SinhVien(String hoTen, String diaChi, String sdt, String email, Date ngaySinh, char gioiTinh,String maSV, String maLop) {
		 super(hoTen, diaChi, sdt, email, ngaySinh, gioiTinh);
		this.maSV = maSV;
		this.maLop = maLop;
		 
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public void nhapSV() {
		super.nhapTT();
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhap MSV");
		this.maSV=sc.nextLine();
		System.out.println("Nhap Ma lop");
		this.maLop=sc.nextLine();
	}
	@Override
	public String toString() {
		return "SinhVien [maSV="+super.toString() + maSV + ", maLop=" + maLop + "]";
	}
	@Override
	public void nhapTT() {
		// TODO Auto-generated method stub
		super.nhapTT();
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhap MSV");
		this.maSV=sc.nextLine();
		System.out.println("Nhap Ma lop");
		this.maLop=sc.nextLine();
		
	}
	  
	 
}
