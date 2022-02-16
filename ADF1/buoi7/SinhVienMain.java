package buoi7;

import java.util.ArrayList;

public class SinhVienMain {
	public static void main(String[] args) {
		Nguoi ng1 = new Nguoi();
		SinhVien sv1 = new SinhVien();
		Nguoi ng2 = new SinhVien();
		ng2.nhapTT();
		System.out.println(ng2);
		SinhVien sv2 = (SinhVien) ng2;
		sv2.nhapTT();
		System.out.println(sv2);
		System.out.println(sv1);
		System.out.println(ng2);

		
		SinhVien[] dssv=new SinhVien[1000];
		Nguoi[] dsnhansu=new Nguoi[1000];
		dsnhansu[0]=new SinhVien();
		ArrayList list =new ArrayList();
		
	}
}
