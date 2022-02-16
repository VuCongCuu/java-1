import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import buoi8.DBVConnection;

public class Tiki {
	public  boolean tableTiki() {
		boolean res=false;
		Statement st=null;
		//khoa
		Connection conn=DBVConnection.getConnection();
		if(conn==null) {
			return false;
		}
		//tao lenh
		try {
			String sql="create table tiki(id int primary key,name nvarchar(50),price float,sl int )";
			st=conn.createStatement();
			//thuc thi lenh
			Boolean a= st.execute(sql);
			res=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("da co bang tiki");
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		return res;
	}
	public boolean addTiki(int id,String name,float price,int sl) {
		Boolean res=false;
		Connection conn= DBVConnection.getConnection();
		Statement st= null;
		try {
			String sql="insert into tiki values("+id+",'"+name+"',"+price+","+sl+")";
			st=conn.createStatement();
			int a=st.executeUpdate(sql);
			System.out.println("Them: " +(a>0?"thanh cong":"khong thah cong"));
		} catch (Exception e) {
			// TODO: handle exception
		
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return res;
	}
	public boolean dropTable(){
		boolean res= false;
		Connection conn= DBVConnection.getConnection();
		if(conn==null) {
			return false;
		}
		Statement st=null;
		try {
			String sql="DROP TABLE tiki";
			st=conn.createStatement();
			boolean a= st.execute(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("khong co bang tiki");
		} finally {
			DBVConnection.closeConnetion(conn);
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return res;
	}
	//u du lieu cot theo id
	public boolean UpdateTable_ID(String name,int id) {
		boolean res= false;
		Connection conn= DBVConnection.getConnection();
		PreparedStatement ps= null;
		try {
			String sql="UPDATE tiki SET Name=? WHERE id=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			int a= ps.executeUpdate();
			System.out.println("update : " +(a>0?"thanh cong":"that bai"));
			if(a>0) {
				res=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBVConnection.closeConnetion(conn);
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return res;
	}
	public static void menu() {
		System.out.println("1.Tao bang");
		System.out.println("2.Them du lieu");
		System.out.println("3.delete");
		System.out.println("4.updata");
		System.out.println("5.thoat");
		
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			Tiki tiki= new Tiki();
			menu();
			System.out.println("Nhap nua chon");
			int choose=sc.nextInt();
			switch(choose) {
			case 1:
				System.out.println(tiki.tableTiki()==true?"thanh  cong":"khong thanh cong"); 
				break;
			case 2:
				System.out.println("Nhap id:");
				int id= sc.nextInt();
				sc.nextLine();
				System.out.println("Nhap name:");
				String name= sc.nextLine();
				System.out.println("Nhap gia:");
				float price= sc.nextFloat();
				System.out.println("Nhap sl:");
				int sl= sc.nextInt();
				tiki.addTiki(id, name, price, sl);
				break;
			case 3:
				System.out.println(tiki.dropTable()==true?"xoa thanh cong":"xoa khong thanh cong");
				break;
			case 4:
				sc.nextLine();
				System.out.println("Nhap name");
				String name1= sc.nextLine();
				System.out.println("nhap id");
				int id1=sc.nextInt();
				tiki.UpdateTable_ID(name1, id1);
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			}
			if(choose==5) {
				break;
			}
		}
	}
}
