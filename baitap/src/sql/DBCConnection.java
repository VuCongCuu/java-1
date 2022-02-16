package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCConnection {
	private static String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=congcuu";
	private static String username="sa";
	private static String password="123456";
	
	public static Connection getConnection() {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	public static void closeConnection(Connection connection) {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
