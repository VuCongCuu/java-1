package buoi8;

import java.util.Date;
import java.util.Scanner;

public class GiangVienFullTime extends GiangVien {

	private float hsLuongCapBac;
	private float hsLuongBH;

	public GiangVienFullTime(String hoTen, String diaChi, String sdt, String email, Date ngaySinh, char gioiTinh,
			String maGV, String emailGV, float hsLuongCapBac, float hsLuongBH) {
		super(hoTen, diaChi, sdt, email, ngaySinh, gioiTinh, maGV, emailGV);
		this.hsLuongCapBac = hsLuongCapBac;
		this.hsLuongBH = hsLuongBH;
	}

	public GiangVienFullTime() {

	}

	public float getHsLuongCapBac() {
		return hsLuongCapBac;
	}

	public void setHsLuongCapBac(float hsLuongCapBac) {
		this.hsLuongCapBac = hsLuongCapBac;
	}

	public float getHsLuongBH() {
		return hsLuongBH;
	}

	public void setHsLuongBH(float hsLuongBH) {
		this.hsLuongBH = hsLuongBH;
	}

	@Override
	public void nhapTT() {
		// TODO Auto-generated method stub
		super.nhapTT();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap hs luong cap bac:");
		this.hsLuongCapBac = sc.nextFloat();
		System.out.println("Nhap hs luong bao hiem:");
		this.hsLuongBH = sc.nextFloat();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GvFullTime:" + super.toString() + "HSLuong: " + this.hsLuongCapBac + "HsLuongBH:" + this.hsLuongBH;
	}

	@Override
	public float tinhLuong() {
		// TODO Auto-generated method stub
		return this.hsLuongBH * GiangVien.luongBH + this.hsLuongCapBac * GiangVien.luongCB;
	}

}
