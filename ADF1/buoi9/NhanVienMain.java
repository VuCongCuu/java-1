package buoi9;

import java.util.ArrayList;
import java.util.Date;

import buoi7.Nguoi;

public class NhanVienMain {
	public static void main(String[] args) {
		NhanVien nv1 = new NhanVien("Cong cuu", "Xuan Dai", "012345", "ad@das", new Date(), '1', "n123", "Van Phong");
		nv1.setType(2);
		nv1.dongPhuc();
		Nguoi nv2 = new NhanVien("Khac duc", "Xuan Dai", "456", "ad@das", new Date(), '1', "n456", "Bao ve");
		((NhanVien)nv2).setType(3);
		((NhanVien) nv2).dongPhuc();
		IWorker nv3= new NhanVien("Nguyen Hue", "HN", "789", "ad@das", new Date(), '0', "n789", "Le tan");
		((NhanVien)nv3).setType(1);
		nv3.doWork();
		((IContent)nv3).dongPhuc();
		ArrayList<Nguoi> listNV= new ArrayList<Nguoi>();
		

	}
}
