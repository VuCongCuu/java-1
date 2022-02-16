package buoi9.designpattern.dao;

import java.util.List;

// khai bao cac hanh vi rang buoc giua bang customer va doi tuong Customerss

import buoi9.designpattern.obj.Customer;
import buoi9.designpattern.utils.ResponseObject;
public interface CustomerDao {
	// insert
	public ResponseObject insertCustomer(Customer customer);
	// update
	public ResponseObject updateCustomer (Customer customer, int id);
	// delete
	public ResponseObject deteteCustomer (int id);
	// getList
	public List<Customer> getList();
}
