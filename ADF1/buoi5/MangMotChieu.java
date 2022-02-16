package buoi5;

import java.util.Scanner;

public class MangMotChieu {
	public static void main(String[] args) {
		float[] points;
		points =new float[10];
		
		
		String[] danhSachLop = {"t2104","t2103","t2102"};
		
		for(int i=0;i<danhSachLop.length;i++) {
			System.out.print(danhSachLop[i]+" ");
		}
		System.out.println();
		//foreach
		for(String lop : danhSachLop) {
			System.out.print(lop +" ");
		}
		System.out.println();
		System.out.println("Nhap danh sach diem : ");
		Scanner sc=new Scanner(System.in);
		int index = 0;
		while(true) {			
			System.out.println("Nhap diem" +(index+1) +":");
			float dd=sc.nextFloat();
			points[index++]=dd;
			if(index==points.length) {
				break;
			}
			sc.nextLine();
			System.out.println("Ban co muon nhap tiep theo hay khong: ");
			String confirm=sc.nextLine();
			if("n".equals(confirm)) {
				break;
			}
		}
		System.out.println("Hien thi danh sach sau khi nhap:");
		for(float a : points) {
			System.out.print("diem :"+a+" ");
		}
	}
}
