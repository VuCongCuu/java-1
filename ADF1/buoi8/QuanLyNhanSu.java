package buoi8;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import buoi7.Nguoi;
import buoi7.SinhVien;

public class QuanLyNhanSu {
	private ArrayList<Nguoi> dsNhanSu;

	public QuanLyNhanSu(ArrayList<Nguoi> dsNhanSu) {
		super();
		this.dsNhanSu = dsNhanSu;
	}

	public QuanLyNhanSu() {
		this.dsNhanSu = new ArrayList<Nguoi>();
	}

	public ArrayList<Nguoi> getDsNhanSu() {
		return dsNhanSu;
	}

	public void setDsNhanSu(ArrayList<Nguoi> dsNhanSu) {
		this.dsNhanSu = dsNhanSu;
	}

	// them 1 đoi tuong vao danh sach
	public boolean themNhanSu(Nguoi ng) {
		if (ng != null) {
			return this.dsNhanSu.add(ng);
		} 
		return false;
	}

	// tim danh sach theo ten
	public ArrayList<Nguoi> dsTheoTen(String name) {
		ArrayList<Nguoi> result = new ArrayList<Nguoi>();
		if (name == null)
			return result;
		for (Nguoi ng : this.dsNhanSu) {
			if (ng.getHoTen().contains(name)) {
				result.add(ng);
			}
		}
		// ket luan
		return result;

	}

	// cap nhap thong tin giang vien theo ma giang vien
	/*
	 * 0 khong tim thay ma giang vien 1:thanh cong 2:that bai
	 */

	public int capNhatGiangVien(String magv) {
		if (magv == null || magv.length() == 0)
			return -1;
		int index = this.timGiangVienTuMa(magv);
		if (index == -1)
			return 0;
		GiangVien gv = (GiangVien) this.dsNhanSu.get(index);
		System.out.println("Nhap trong tin giang vien");
		gv.nhapTT();
		// cap nhat thong tin
		if (this.dsNhanSu.set(index, gv) != null) {
			return 1;
		}
		return 2;
	}

	// tim giang vien theo ma giang vien
	public int timGiangVienTuMa(String magv) {
		if (magv == null || magv.length() == 0)
			return -1;
		for (int i = 0; i < this.dsNhanSu.size(); i++) {
			Nguoi ng = this.dsNhanSu.get(i);
			if (ng instanceof GiangVien) {
				GiangVien gv = (GiangVien) ng;
				if (magv.equals(gv.getMaGV())) {
					return i;
				}
			}

		}
		return -1;
	}

	public void showNhanSu(int type) {
		if (type == 1) {
			System.out.println("--------Danh sach giang vien");
			for (Nguoi ng : this.dsNhanSu) {
				if (ng instanceof GiangVien)
					System.out.println(ng);

			}
		} else if (type == 2) {
			System.out.println("--------Danh sach sinh vien");
			for (Nguoi ng : this.dsNhanSu) {
				if (ng instanceof SinhVien)
					System.out.println(ng);

			}
		} else {
			System.out.println("--------Danh sach nhan su");
			for (Nguoi ng : this.dsNhanSu) {
				System.out.println(ng);
			}
		}
	}
	
}
