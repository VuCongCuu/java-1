package buoi8;

import java.util.Date;
import java.util.Scanner;

import buoi7.Nguoi;

public abstract class GiangVien extends Nguoi {

	private String maGV;
	private String emailGV;
	public static final int luongBH = 800000;
	public static final int luongCB = 1000000;
	public static final int luong1Gio = 100000;

	public GiangVien(String hoTen, String diaChi, String sdt, String email, Date ngaySinh, char gioiTinh, String maGV,
			String emailGV) {
		super(hoTen, diaChi, sdt, emailGV, ngaySinh, gioiTinh);
		this.maGV = maGV;
		this.emailGV = emailGV;
	}

	public GiangVien() {
		super();
	}

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getEmailGV() {
		return emailGV;
	}

	public void setEmailGV(String emailGV) {
		this.emailGV = emailGV;
	}

	@Override
	public void nhapTT() {
		// TODO Auto-generated method stub
		super.nhapTT();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma gv:");
		this.maGV = sc.nextLine();
		System.out.println("Nhap email gv:");
		this.emailGV = sc.nextLine();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "MaGV: " + this.maGV + "emailGV: " + this.emailGV + "Luong: " + this.tinhLuong();
	}

	// tao ra rangf buoc adstract
	public abstract float tinhLuong();

}
