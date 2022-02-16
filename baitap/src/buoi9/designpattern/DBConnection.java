package buoi9.designpattern;
// singleton

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import buoi9.designpattern.utils.Contants;

public class DBConnection {
	// b1: tao ra 1 doi tuong/ instance duy nhat cua class
	private static DBConnection instance;
	// b2: ngan can su dung toan new o ngoai lop: tao constructor private
	private DBConnection() {
	}
	// b3: ham tr ve doi tuong/ instance duy nhat cua class -> public
	public static synchronized DBConnection getInstance() {
		if (instance == null) {
			// load cau hinh
			instance = new DBConnection();
		}
		return instance;
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(Contants.url, Contants.username, Contants.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
