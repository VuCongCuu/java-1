package buoi8.bvn;

import java.util.Scanner;

public class SinhVienDao {
	public String maSV;
	public String tenSV;
	public String gioiTinh;
	public int maKhoa;
	public SinhVienDao() {
		super();
	}
	
	public SinhVienDao(String maSV, String tenSV, String gioiTinh, int maKhoa) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.gioiTinh = gioiTinh;
		this.maKhoa = maKhoa;
	}

	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(int maKhoa) {
		this.maKhoa = maKhoa;
	}
	Scanner sc= new Scanner(System.in);
	public  void sinhvienNhap() {
		System.out.println("Ma Sinh vien:");
		this.maSV=sc.nextLine();
		System.out.println("Ten Sinh Vien");
		this.tenSV=sc.nextLine();
		System.out.println("Gioi tinh");
		this.gioiTinh=sc.nextLine();
		System.out.println("Ma khoa");
		this.maKhoa=sc.nextInt();
	}
}
