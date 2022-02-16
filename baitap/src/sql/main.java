package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
	public static void main(String[] args) throws SQLException {
		String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=congcuu";
		String username="sa";
		String password="123456";
		Connection con= DriverManager.getConnection(url, username, password);
		String sql="create table KhachHang(tuoi int,name varchar(50))";
		
			Statement st= con.createStatement();
		boolean res= st.execute(sql);
//			System.out.println(res);
			System.out.println("thanh cong");
			st.close();
			con.close();
		
	} 
}
