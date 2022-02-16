package buoi5;

import java.util.Scanner;

public class MangLopHoc {
	public static void main(String[] args) {
			String[] classRoom;
			classRoom=new String[10];
			int index=0;
			System.out.println("---Nhap Lop----");
			while(true) {
				Scanner sc=new Scanner(System.in);
				System.out.println("Ten lop:");
				String dd= sc.nextLine();
				classRoom[index++]=dd;
				if(index==classRoom.length) {
					break;
				}
				System.out.println("Ban co muon tiem tuc khong ( n:thoat)");
				String confirm=sc.nextLine();
				if("n".equals(confirm)) {
					break;
				}
			}
			for(String a : classRoom) {
				System.out.println("lop:" + a);
			}
	}
}
