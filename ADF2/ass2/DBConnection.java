package ass2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ass2.util.Contants;

public class DBConnection {
	private static DBConnection instance;
	
	private DBConnection() {
		
	}

	public static DBConnection getInstance() {
		if(instance==null) 
			instance= new DBConnection();
		
		return instance;
	}

	public static Connection getConnection() {
		Connection conn=null;
				try {
					conn=DriverManager.getConnection(Contants.url,Contants.username,Contants.password);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		return conn;
	}
	public static void closeConnection(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
