package buoi9.designPattern.daoInterface;
// định nghĩa các hành vi ràng buộc giữa bang customer va dôi tượng Customerss; 

import java.util.List;

import buoi9.designPattern.obj.Customer;
import buoi9.designPattern.utils.ResponseObject;

public interface CustomerDao {
	//insert
	public ResponseObject insertCustomer( Customer customer);
	//update
	public ResponseObject upDateCutomer(Customer customer,int id);
	//delete
	public ResponseObject deleteCutomer(int id);
	//getList
	public List<Customer> getList();
	public boolean tableCustomer();
	
	
}
