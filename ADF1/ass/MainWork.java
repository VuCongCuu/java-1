package ass;

import java.util.Scanner;

public class MainWork {
	public static void main(String[] args) {
		QuanLy quanLY = new QuanLy();
		int choose;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("1. Crud Nhom hang");
			System.out.println("\t\t2. Crud San pham");
			System.out.print("3. Crud Don hang");
			System.out.println("\t\t4. Bao cao");
			System.out.print("5. Thoat");

			System.out.print("\n\nNhap lua chon: ");
			try {
				choose = sc.nextInt();

				switch (choose) {
						case 1:
							quanLY.choose_1();
							break;
						case 2:
							quanLY.choose_2();
		
							break;
						case 3:
							quanLY.choose_3();
		
							break;
						case 4:
							quanLY.choose_4();
		
							break;
						case 5:
							System.exit(5);
		
						default:
							System.out.println("P/s: Phai lua chon khong hop ly(1-5)");
						}
		
						if (choose == 5)
							break;

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Phai nhap 1 so");
				sc.nextLine();
			}

		}
	}
}
