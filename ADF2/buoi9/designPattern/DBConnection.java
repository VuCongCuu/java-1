package buoi9.designPattern;

import java.sql.Connection;
import java.sql.DriverManager;

import buoi9.designPattern.utils.Contants;

public class DBConnection {
	// buoc 1 tao ra 1  dooi tuong duy nhat
	private static DBConnection instance;
	// ngan can sử dụng toan new ở ngoài lớp
	private DBConnection() {
		
	}
	// b3 ham tra ve ddooi tuong duy nhat cua class
	public static DBConnection getInstance() {
		if(instance==null)
			instance= new DBConnection();
		return instance;
	}
	public static Connection getConnection(){
		Connection conn= null;
		try {
			conn=DriverManager.getConnection(Contants.url, Contants.username, Contants.password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection(Connection connection) {
		if(connection!=null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
