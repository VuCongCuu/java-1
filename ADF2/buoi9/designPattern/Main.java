package buoi9.designPattern;

import java.util.List;
import java.util.Scanner;

import buoi9.designPattern.daoInterface.CustomerDao;
import buoi9.designPattern.daoInterface.impl.CustomerDaoImpl;
import buoi9.designPattern.obj.Customer;
import buoi9.designPattern.utils.Contants;
import buoi9.designPattern.utils.ResponseObject;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			int choose ;
			CustomerDao cusDao = new CustomerDaoImpl();
			menu();
			System.out.println("nhap lua chon");
			choose=sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Them moi 1 customer");
				Customer cu = new Customer();
				cu.nhap();
				ResponseObject result = cusDao.insertCustomer(cu);
				if (result.getResCode() == Contants.RES_SUCCESS) {
					System.out.println("Them moi thanh cong.");
				} else {
					System.out.println("That bai: "+ result.getResDesc());
				}
				break;
			case 2:
				// update
				System.out.println("update");
				Customer cuu = new Customer();
				cuu.nhap();
				System.out.println("Nhap ID update");
				int idu=sc.nextInt();
				ResponseObject result1 = cusDao.upDateCutomer(cuu,idu);
				if (result1.getResCode() == Contants.RES_SUCCESS) {
					System.out.println("Update thanh cong.");
				} else {
					System.out.println("That bai: "+ result1.getResDesc());
				}
				break;
			case 3:
				// delete
				System.out.println("delete");
				System.out.println("Nhap ID update");
				int idd=sc.nextInt();
				ResponseObject result2=cusDao.deleteCutomer(idd);
				if (result2.getResCode() == Contants.RES_SUCCESS) {
					System.out.println("delete thanh cong.");
				} else {
					System.out.println("That bai: "+ result2.getResDesc());
				}	
				break;
			case 4:
				System.out.println("Ds customer: ");
				List<Customer> list = cusDao.getList();
				for (Customer cus : list) {
					System.out.println(cus);
				}
				break;
			case 5:	
				System.exit(5);
			}
			if(choose==5) {
				break;
			}
			
		}

	}
	public static void menu() {
		System.out.println("1.Them moi 1 customer");
		System.out.println("2.Update moi 1 customer");
		System.out.println("3.Delete 1 customer");
		System.out.println("4.Hien thi danh sach customer");
		System.out.println("5.thoat");
	}
}
