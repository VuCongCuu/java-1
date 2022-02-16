package buoi8;

import java.util.Date;
import java.util.Scanner;

public class GiangVienPartTime extends GiangVien {
	private int soGio;

	public GiangVienPartTime() {
		super();
	}

	public GiangVienPartTime(String hoTen, String diaChi, String sdt, String email, Date ngaySinh, char gioiTinh,
			String maGV, String emailGV, int soGio) {
		super(hoTen, diaChi, sdt, email, ngaySinh, gioiTinh, maGV, emailGV);
		this.soGio = soGio;
	}

	public int getSoGio() {
		return soGio;
	}

	public void setSoGio(int soGio) {
		this.soGio = soGio;
	}

	@Override
	public void nhapTT() { 
		// TODO Auto-generated method stub
		super.nhapTT();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so gio:");
		this.soGio = sc.nextInt();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GiangVienPartTime"+super.toString() + ",so gio" + this.soGio;
	}

	@Override
	public float tinhLuong() {
		// TODO Auto-generated method stub
		return this.soGio * GiangVien.luong1Gio;
	}

}
