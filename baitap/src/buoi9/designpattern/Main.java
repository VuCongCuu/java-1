package buoi9.designpattern;

import java.util.List;

import buoi9.designpattern.dao.CustomerDao;
import buoi9.designpattern.dao.impl.CustomerDaoImpl;
import buoi9.designpattern.obj.Customer;
import buoi9.designpattern.utils.Contants;
import buoi9.designpattern.utils.ResponseObject;

public class Main {

	public static void main(String[] args) {
		int choose = 1;
		CustomerDao cusDao = new CustomerDaoImpl();
		switch (choose) {
		case 1:
			System.out.println("Them moi 1 customer");
			Customer cu = new Customer(2, "Dung");
			ResponseObject result = cusDao.insertCustomer(cu);
			if (result.getResCode() == Contants.RES_SUCCESS) {
				System.out.println("Them moi thanh cong.");
			} else {
				System.out.println("That bai: "+ result.getResDesc());
			}
			break;
		case 2:
			// update
			break;
		case 3:
			// delete
			break;
		case 4:
			System.out.println("Ds customer: ");
			List<Customer> list = cusDao.getList();
			for (Customer cus : list) {
				System.out.println(cus);
			}
			break;
		default:
			break;
		}
	}

}
