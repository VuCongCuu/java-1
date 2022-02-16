package buoi5;

import java.util.Scanner;

public class QuanLyLopHoc {
		private String nameLopHoc;
		private String maLopHoc="";
		private int soLuongHocSinh;
		public QuanLyLopHoc() {
			super();
		}
		public String getNameLopHoc() {
			return nameLopHoc;
		}
		public void setNameLopHoc(String nameLopHoc) {
			this.nameLopHoc = nameLopHoc;
		}
		public String getMaLopHoc() {
			return maLopHoc;
		}
		public void setMaLopHoc(String maLopHoc) {
			this.maLopHoc = maLopHoc;
		}
		public int getSoLuongHocSinh() {
			return soLuongHocSinh;
		}
		public void setSoLuongHocSinh(int soLuongHocSinh) {
			this.soLuongHocSinh = soLuongHocSinh;
		}
		public void nhapTT() {
			System.out.println("***Nhap thong tin lop hoc*****");
			Scanner sc=new Scanner(System.in);
			System.out.println("Ten lop : ");
			nameLopHoc=sc.nextLine();
			while(true) {
				System.out.println("Ma lop hoc:");
				maLopHoc=sc.nextLine();
				if(maLopHoc.length()<=4 && maLopHoc.length()>0) {
					break;
				}
			}
			while(true) {
				System.out.println("So luong hoc sinh:");
				soLuongHocSinh=sc.nextInt();
				if(soLuongHocSinh>0) {
					break;
				}
			}
			
		}
		@Override
		public String toString() {
			return "QuanLyLopHoc [nameLopHoc=" + nameLopHoc + ", maLopHoc=" + maLopHoc + ", soLuongHocSinh="
					+ soLuongHocSinh + "]";
		}
		
		
}
