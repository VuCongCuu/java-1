package buoi8;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBVConnection {
	private static String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=QuanLyDiemSV";
	private static String username="sa";
	private static String password="123456";
	
	
	public static Connection getConnection() {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeConnetion(Connection connection) {
		if(connection!=null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
