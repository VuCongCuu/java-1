package buoi2.bvn3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class QuanLyBai3 {
	private static Set<Student> dsSinhVien = new TreeSet<Student>(new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			int checkmaSV = o1.getMaSV().compareTo(o2.getMaSV());
			if (checkmaSV == 0)
				return 0;
			int checkTen = o1.getName().compareTo(o2.getName());
			if (checkTen == 0)
				return checkmaSV;
			int checkAddRess = o1.getAddRess().compareTo(o2.getAddRess());
			if (checkAddRess == 0)
				return 1;
			int checkage = o1.getAge().compareTo(o2.getAge());
			if (checkage == 0)
				return 2;
			return checkTen;
		}
	});
	public static Student checkMa(String name, String masv) {
		if (masv == null || name == null)
			return null;
		for (Student sv : dsSinhVien) {
			if (sv.getMaSV().equals(masv) && sv.getName().equals(name)) {
				return sv;
			}
		}
		return null;
	}

	public static List<Student> checkTuoi(Integer tuoii) {
		if (tuoii == null)
			return null;
		List<Student> sut = new ArrayList<Student>();
		for (Student f : dsSinhVien) {
			if (f.getAge().equals(tuoii)) {
				sut.add(f);
			}
		}
		return sut;
	}
	private static Set<Student> checkTen = new TreeSet<Student>(new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			int checkmaSV = o1.getMaSV().compareTo(o2.getMaSV());
			if (checkmaSV == 0)
				return 0;
			int checkTen = o1.getName().compareTo(o2.getName());
			if (checkTen == 0)
				return 0;
			int checkAddRess = o1.getAddRess().compareTo(o2.getAddRess());
			if (checkAddRess == 0)
				return 1;
			int checkage = o1.getAge().compareTo(o2.getAge());
			if (checkage == 0)
				return 2;
			return checkmaSV;
		}

	});

	public static void choose() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\t1.Thêm sinh viên vào danh sách Sinh viên");
			System.out.println("\t2.Sắp xếp danh sách Sinh viên theo thứ tự tăng dần tên và mã ngành học");
			System.out.println("\t3.Hiển thị tên sinh viên không trùng nhau ");
			System.out.println("\t4.Hiển thị các sinh viên tìm kiếm theo tên hoặc ngành học");
			System.out.println("\t5.Xóa sinh viên khi nhập vào tên và mã ngành học");
			System.out.println("\t6.Hiển thị số lượng sinh viên theo từng độ tuổi và thông tin sắp xếp theo độ tuổi");
			System.out.println("\t7.Thoat");
			System.out.println("nhap lua chon");
			Student sv = new Student();
			int c = sc.nextInt();
			switch (c) {
					case 1:
						System.out.println("-----Thêm sinh viên vào danh sách Sinh viên------");
						sv.nhapTT();
						System.out.println(dsSinhVien.add(sv) ? "them thanh cong" : "Them khong thanh cong");
						System.out.println(checkTen.add(sv) ? "true" : "false");
						break;
					case 2:
						System.out.println("----Sắp xếp danh sách Sinh viên theo thứ tự tăng dần tên và mã ngành học-----");
						for (Student a : dsSinhVien)
							System.out.println(a.toString());
						break;
		
					case 3:
						System.out.println("-----Hiển thị tên sinh viên không trùng nhau------- ");
						for (Student b : checkTen) {
							System.out.println(b.toString());
						}
						break;
					case 4:
						System.out.println("-----Hiển thị các sinh viên tìm kiếm theo tên hoặc ngành học------");
						System.out.println("Nhap ten: ");
						String na = sc.nextLine();
						System.out.println("Nhap ma SV: ");
						String ma = sc.nextLine();
						Student s = checkMa(na, ma);
						if (s != null) {
							System.out.println(s.toString());
						}
						break;
					case 5:
						System.out.println("----Xóa sinh viên khi nhập vào tên và mã ngành học-----");
						System.out.println("-----Hiển thị các sinh viên tìm kiếm theo tên hoặc ngành học------");
						System.out.println("Nhap ten: ");
						String nam = sc.nextLine();
						System.out.println("Nhap ma SV: ");
						String mas = sc.nextLine();
						Student st = checkMa(nam, mas);
						if (st != null) {
							System.out.println(dsSinhVien.remove(st) == true ? "Xoa thanh cong" : "Khong tim thay");
							System.out.println(checkTen.remove(st) == true ? "true" : "false");
		
						}
						break;
					case 6:
						System.out.println(
								"---Hiển thị số lượng sinh viên theo từng độ tuổi và thông tin sắp xếp theo độ tuổi---");
						System.out.println("Nhap tuoi: ");
						int tu = sc.nextInt();
						List<Student> sv1 = checkTuoi(Integer.valueOf(tu));
						if (sv1 != null) {
							for (Student g : sv1) {
								System.err.println(g);
							}
						}
		
						break;
					case 7:
						System.exit(7);
						break;
			}
			if (c == 7) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		QuanLyBai3 ql = new QuanLyBai3();
		System.out.println("******Chương trình danh sách Sinh viên*******\n");
		ql.choose();
	}

}
