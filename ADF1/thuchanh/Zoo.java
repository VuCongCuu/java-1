package thuchanh;

import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {
	//them chuong
	public void themchuong(ArrayList<chuongtrai> zoo) {
		int leght=zoo.size();
		zoo.add(new chuongtrai());
		zoo.get(leght).nhapTT();
	}
	//xoa chuong
	Scanner sc = new Scanner(System.in);
	public void xoaChuong(ArrayList<chuongtrai> zoo) {
		int count=0;
		for(chuongtrai chuong: zoo) {
			++count;
			System.out.print(++count+"." +chuong.getMaChuong());
			if(count %2==0) {
				System.out.print("\t\t");
			} else {
				System.out.println();
			}
			System.out.println("nhap chuong muon xoa");
			
		int chose= sc.nextInt();
		zoo.remove(chose-1);
			
		}
	}
	//them vat vao chuong
		public void addVat(ArrayList<chuongtrai> zoo) {
			int count=0;
			for(chuongtrai chuong : zoo) {
				++count;
				System.out.print(++count + chuong.getMaChuong());
				if(count %2==0) {
					System.out.print("\t\t");
				} else {
					System.out.println();
				}
			}
			System.out.println("chon chuong can them");
			int chose=sc.nextInt();			
			chuongtrai chuong= zoo.get(chose-1);
			chuong.themVat(chuong.getDsDongVat());
		}
		// -----------xoa vat------------
		public void xoaVat(ArrayList<chuongtrai> zoo) {
			int count=0;
			for(chuongtrai chuong : zoo) {
				System.out.println(++count +"."+chuong.getMaChuong());
				if(count %2==0) {
					System.out.print("\t\t");
				} else {
					System.out.println();
				}
			}
			System.out.println("chuong muon xoa vat");
			int chose=sc.nextInt();
			chuongtrai chuong =zoo.get(chose-1);
			ArrayList<DongVat> dsdongVat=chuong.getDsDongVat();
			while(true) {
				int count1=0;
			for(DongVat vat : dsdongVat) {
				System.out.println("/n/t Dong vat :" + (++count1) + vat.toString());
			}
				System.out.println("chon dong vat can xoa");
				int chose1=sc.nextInt();
				if(chose1>0 && chose1<dsdongVat.size() ) {
					System.out.println("ban da so dong vat" +dsdongVat.get(chose1-1));
					dsdongVat.remove(chose1-1);
				}
				System.out.println("ban co mon xoa tiep khong");
				String check=sc.nextLine();
				if("n".equalsIgnoreCase(check)) {
					break;
				}
			}				
		}
		//hien thi danh sach
		public void showdv(ArrayList<chuongtrai> zoo) {
			for(chuongtrai chuong : zoo) {
				System.out.println(chuong.getMaChuong());
				chuong.KiemtraDongVat(chuong.getDsDongVat());
			}
		}
		
}
