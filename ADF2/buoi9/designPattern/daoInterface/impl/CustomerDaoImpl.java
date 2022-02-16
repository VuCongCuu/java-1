package buoi9.designPattern.daoInterface.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import buoi9.designPattern.DBConnection;
import buoi9.designPattern.daoInterface.CustomerDao;
import buoi9.designPattern.obj.Customer;
import buoi9.designPattern.utils.Contants;
import buoi9.designPattern.utils.ResponseObject;

public class CustomerDaoImpl implements CustomerDao {
	@Override
	public  boolean tableCustomer() {
		Boolean result = false;
		// validate tham so input
		
		// b1: tao ket noi
		Connection conn = DBConnection.getInstance().getConnection();
		if (conn == null) {
			return false;
		}
		// b2: thuc thi sql
		String sql = "create table customer (id int identity primary key,name nvarchar(50) not null)";
		Statement ps = null;
		try {
			ps=conn.createStatement();
			boolean a= ps.execute(sql);
			System.out.println(a==true?"tao bang thanh cong":"that bai");
			// b3: xu ly ket qua
			result=true;
		
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// b4: dong ket noi
		DBConnection.getInstance().closeConnection(conn);
		return result;

	}
	@Override
	public ResponseObject insertCustomer(Customer customer) {
		ResponseObject result = null;
		// validate tham so input
		if (customer == null || customer.getName().equals("")) {
			result = new ResponseObject(Contants.RES_NOT_VALIDATE, "Tham so khong dung");
			return result;
		}
		// b1: tao ket noi
		Connection conn = DBConnection.getInstance().getConnection();
		if (conn == null) {
			result = new ResponseObject(Contants.RES_NOT_CONNECT, "Ket noi DB khong thanh cong");
			return result;
		}
		// b2: thuc thi sql
		String sql = "insert into customer (name) values (?)";
		PreparedStatement ps = null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, customer.getName());
			int isExe = ps.executeUpdate();
			// b3: xu ly ket qua
			if (isExe > 0) {
				result = new ResponseObject(Contants.RES_SUCCESS, "Success");
			} else {
				result = new ResponseObject(Contants.RES_FAIL, "Fail");
			}
		}catch(Exception e) {
			result = new ResponseObject(Contants.RES_FAIL, e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// b4: dong ket noi
		DBConnection.getInstance().closeConnection(conn);
		return result;

	}

	@Override
	public ResponseObject upDateCutomer(Customer customer, int id) {
		ResponseObject result = null;
		// validate tham so input
		if (customer == null || customer.getName().equals("") || id <= 0) {
			result = new ResponseObject(Contants.RES_NOT_VALIDATE, "Tham so khong dung");
			return result;
		}
		// b1: tao ket noi
		Connection conn = DBConnection.getInstance().getConnection();
		if (conn == null) {
			result = new ResponseObject(Contants.RES_NOT_CONNECT, "Ket noi DB khong thanh cong");
			return result;
		}
		// b2: thuc thi sql
		String sql = "update customer set name = ? where id = ?";
		PreparedStatement ps = null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, customer.getName());
			ps.setInt(2, id);
			int isExe = ps.executeUpdate();
			// b3: xu ly ket qua
			if (isExe > 0) {
				result = new ResponseObject(Contants.RES_SUCCESS, "Success");
			} else {
				result = new ResponseObject(Contants.RES_FAIL, "Fail");
			}
		}catch(Exception e) {
			result = new ResponseObject(Contants.RES_FAIL, e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// b4: dong ket noi
		DBConnection.getInstance().closeConnection(conn);
		return result;

	}

	@Override
	public ResponseObject deleteCutomer(int id) {
		ResponseObject result = null;
		// validate tham so input
		if (id <= 0) {
			result = new ResponseObject(Contants.RES_NOT_VALIDATE, "Tham so khong dung");
			return result;
		}
		// b1: tao ket noi
		Connection conn = DBConnection.getInstance().getConnection();
		if (conn == null) {
			result = new ResponseObject(Contants.RES_NOT_CONNECT, "Ket noi DB khong thanh cong");
			return result;
		}
		// b2: thuc thi sql
		String sql = "delete from customer where id = ?";
		PreparedStatement ps = null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int isExe = ps.executeUpdate();
			// b3: xu ly ket qua
			if (isExe > 0) {
				result = new ResponseObject(Contants.RES_SUCCESS, "Success");
			} else {
				result = new ResponseObject(Contants.RES_FAIL, "Fail");
			}
		}catch(Exception e) {
			result = new ResponseObject(Contants.RES_FAIL, e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// b4: dong ket noi
		DBConnection.getInstance().closeConnection(conn);
		return result;

	}

	@Override
	public List<Customer> getList() {
		
		List<Customer> result = new ArrayList<Customer>();
		// b1: tao ket noi
		Connection conn = DBConnection.getInstance().getConnection();
		if (conn == null) {
			return result;
		}
		// b2: thuc thi sql
		String sql = "select * from customer";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// b3: xu ly ket qua
			while (rs.next()) {
				Customer cu = new Customer();
				cu.setId(rs.getInt("id"));
				cu.setName(rs.getString("name"));
				result.add(cu);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// b4: dong ket noi
		DBConnection.getInstance().closeConnection(conn);
		return result;

	}

}
