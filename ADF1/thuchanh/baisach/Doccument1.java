package thuchanh.baisach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Doccument1 implements Comparable<Doccument1> {
	private String maTaiLieu;
	private String tenTaiLieu;
	private String tenNSB;
	private int soBanPhatHanh;
	private SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	//------contructor----------------
	public Doccument1() {
		super();
	}
	public Doccument1(String maTaiLieu, String tenTaiLieu, String tenNSB, int soBanPhatHanh) {
		super();
		this.maTaiLieu = maTaiLieu;
		this.tenTaiLieu = tenTaiLieu;
		this.tenNSB = tenNSB;
		this.soBanPhatHanh = soBanPhatHanh;
	}
	// ---------------set,get-----------------
	public String getMaTaiLieu() {
		return maTaiLieu;
	}
	public void setMaTaiLieu(String maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}
	public String getTenTaiLieu() {
		return tenTaiLieu;
	}
	public void setTenTaiLieu(String tenTaiLieu) {
		this.tenTaiLieu = tenTaiLieu;
	}
	public String getTenNSB() {
		return tenNSB;
	}
	public void setTenNSB(String tenNSB) {
		this.tenNSB = tenNSB;
	}
	public int getSoBanPhatHanh() {
		return soBanPhatHanh;
	}
	public void setSoBanPhatHanh(int soBanPhatHanh) {
		this.soBanPhatHanh = soBanPhatHanh;
	}
	// ------------mo rong---------------
	Scanner sc=new Scanner(System.in);
	public void nhapTT() {
		System.out.println("Ma tai lieu:");
		this.maTaiLieu=sc.nextLine();
		System.out.println("Ten tai lieu:");
		this.tenTaiLieu=sc.nextLine();
		System.out.println("Ten nha suat ban:");
		this.tenNSB=sc.nextLine();
		System.out.println("Ma tai lieu:");
		this.soBanPhatHanh=sc.nextInt();

		}
	// check ngay
	public Date checkngay(String yeucau) {
		Date ngay = new Date();
		while(true) {
			System.out.println("Nhap ngay (dd/MM/yyyy) :");
			try {
				ngay=sdf.parse(sc.nextLine());
				return ngay;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("nhap sai dinh dang");
			}
		}
	}
	
	//--------------tostring--------------
	@Override
	public String toString() {
		return "Doccument1 [maTaiLieu=" + maTaiLieu + ", tenTaiLieu=" + tenTaiLieu + ", tenNSB=" + tenNSB
				+ ", soBanPhatHanh=" + soBanPhatHanh +", Gia: "+this.gia()+ "]";
	}	
	public abstract int gia();
	@Override
	public int compareTo(Doccument1 o) {
		// TODO Auto-generated method stub
		int sosanh=Integer.valueOf(this.soBanPhatHanh).compareTo(o.soBanPhatHanh);
		return sosanh;
	}
	
}
