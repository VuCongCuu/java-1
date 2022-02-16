package buoi5;

import java.util.Scanner;

public class MangInt {
	public static void main(String[] args) {
		int[] soTuNhien;
		soTuNhien=new int[10];
		System.out.println("---Nhap----");
		int index=0;
		while(true){
			System.out.println("Nhap so thu "+(index+1)+":" );
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			soTuNhien[index++]=n;
			if(index==soTuNhien.length) {
				break;
			}
			sc.nextLine();
			System.out.println("ban co muon tiep tuc khong:");
			String confirm=sc.nextLine();
			if("n".equals(confirm)) {
				break;
			}
		}
			for(int a : soTuNhien) {
				System.out.print(a+" ");
			}
			
		}
	}

