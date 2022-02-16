package buoi5;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class LopHoc {
	private String maLop = "";
	private int namHoc;
	private String phongHoc;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public LopHoc() {
		super();
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public int getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(int namHoc) {
		this.namHoc = namHoc;
	}

	public String getPhongHoc() {
		return phongHoc;
	}

	public void setPhongHoc(String phongHoc) {
		this.phongHoc = phongHoc;
	}

	public void nhapttlop() {
		Scanner sc = new Scanner(System.in);
		System.out.println("----Nhap thong tin lop hoc--- ");
		while (true) {
			System.out.println("Nhap ma lop hoc : ");
			this.maLop = sc.nextLine();
			if (this.maLop.length() > 0 && this.maLop.length() <= 4) {
				break;
			}
		}

		while (true) {
			System.out.println("Nhap nam hoc :");
			this.namHoc = sc.nextInt();
			if (this.namHoc > 0) {
				break;
			}
		}
		sc.nextLine();
		System.out.println("Nhap phong hoc");
		this.phongHoc=sc.nextLine();
	}

	@Override
	public String toString() {
		return "LopHoc [maLop=" + maLop + ", namHoc=" + namHoc + ", phongHoc=" + phongHoc + "]";
	}
	

}
