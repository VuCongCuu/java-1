package buoi8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import buoi7.Nguoi;
import buoi7.SinhVien;

public class Buoi8Main {
	public static void main(String[] args) {
//		Nguoi ng1= new Nguoi();
//		Nguoi ng2= new SinhVien();
//		//giangvien abstract
//		Nguoi ng3 = new GiangVienFullTime();
//		Nguoi ng4 = new GiangVienPartTime();
//		GiangVien gv1=new GiangVienFullTime();
//		GiangVien gv2=new GiangVienPartTime();
//		ArrayList<Nguoi> ds= new ArrayList<Nguoi>();
//		
		QuanLyNhanSu fpt =new QuanLyNhanSu();
		fpt.themNhanSu(new Nguoi("cuu","123","1234","a@com",new Date(),'1'));
		fpt.themNhanSu(new SinhVien("Duc","123","1234","a@com",new Date(),'1',"321","456"));
		fpt.themNhanSu(new GiangVienFullTime("lan","123","1234","a@com",new Date(),'1',"01","a@com",3f,2f));
		fpt.themNhanSu(new GiangVienPartTime("long","123","1234","a@com",new Date(),'2',"02","a@com" ,10));
		fpt.themNhanSu(new GiangVienPartTime("duc","123","1","a@com",new Date(),'3',"02","a@com" ,10));
		fpt.showNhanSu(3);
		fpt.showNhanSu(1);
		fpt.showNhanSu(2);
		
		String magv="02312";
		fpt.capNhatGiangVien(magv);
		int update=fpt.capNhatGiangVien(magv);
		if(update == 1) {
			System.out.println("thanh cong");
		} else {
			System.out.println("that bai");
		}
		fpt.showNhanSu(1);
		Collections.sort(fpt.getDsNhanSu());
		fpt.showNhanSu(1);
	}

}
