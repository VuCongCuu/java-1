package ass2;

import java.util.Scanner;

import ass2.dao.Impl.BankDaoImpl;
public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(true) {
			try {
				System.out.println(" 1. Thực thi CRUD Khách hàng");
				System.out.println(" 2. Thực thi CRUD TaiKhoan");
				System.out.println(" 3. Báo cáo");
				System.out.println(" 4. Thoat");
				System.out.println("Nhap lua chon(1-4):");
				int choos= sc.nextInt();
				switch(choos) {
					case 1 :
						BankDaoImpl.choose_1();
						break;
					case 2 :
						BankDaoImpl.choose_2();
						break;
					case 3 :
						BankDaoImpl.choose_3();
						break;
					case 4 :					
						System.exit(4);
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("P/s:Nhap ky tu so 1->4");
				sc.nextLine();
			}
		}
	}
}
