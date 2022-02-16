package Assignment2_Variable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection_Assignment2 {
	private static DBconnection_Assignment2 instance;
	
	private DBconnection_Assignment2() {
		
	}
	public synchronized static DBconnection_Assignment2 getInstance() {
		if(instance == null) {
			Constrain.loadConfig();
			instance = new DBconnection_Assignment2();
		}
		return instance;
	}
	//Method Connection
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(Constrain.url, Constrain.userDB, Constrain.passwordDB);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Connection Successful");
		return con;
	}
	//Method Close Connection
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
