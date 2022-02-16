package buoi8;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	//insert
	public boolean insertBook(int id,String name,float price) {
			boolean res= false;
			Statement statement=null;
			//b1:tao ket noi
			Connection connection=DBVConnection.getConnection();
			if(connection==null) return false; 
			//b2 tao lenh
			try {
				String sql="insert into book(id,name,price) values ("+id+",'"+name+"',"+price+")";
				statement= connection.createStatement();
				//b2.2 thuc thi lenh
				int kq=statement.executeUpdate(sql);
				//b3 xu ly
				System.out.println("thuc thi lenh create"+ (kq!=0?"Thanh cong":"khong thanh cong"));
				if(kq>0) {
					res=true;
				}
				//b4:giai phong ket noi	
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if(statement!=null)
					try {
						statement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(connection!=null)
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			return res;
		}
	//update
		public ResponseObject updateBook(int id,String name,float price ) {
			ResponseObject result= null;
			//ket noi
			Connection connection=DBVConnection.getConnection();
			if(connection==null) {
				 return new ResponseObject(-1,"Connect fail");
			} 
			CallableStatement cs=null;
			try {
				String sql="exec dbo.pr_update_book ?,?,?,?,?";
				cs=connection.prepareCall(sql);
				//truywn tham so vao lenh
				cs.setInt(1, id);
				cs.setString(2, name);
				cs.setFloat(3, price);
				cs.registerOutParameter(4, Types.INTEGER);
				cs.registerOutParameter(5, Types.VARCHAR);
				///thuc thi lenh
				cs.executeUpdate();
				//b3 xu ly ket qua
				int err_code=cs.getInt(4);
				String err_desc=cs.getString(5);
				result=new ResponseObject(err_code, err_desc);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				result=new ResponseObject(0, e.getMessage());
			} finally {
				if(cs!=null) {
					try {
						cs.close();
					} catch (SQLException e) {
						// TODO Auto-generated2 catch block
						e.printStackTrace();
					}
				}
				if(connection!=null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return result;
		}
	//delete
		public boolean deletebook(int id) {
			boolean result= false;
			//ket noi
			Connection connection=DBVConnection.getConnection();
			if(connection==null) return false;
			PreparedStatement preparedStatement=null;
			try {
				String sql="delete from book where id=?";
				preparedStatement=connection.prepareStatement(sql);
				//truyen tham so vao lenh-> set 
				preparedStatement.setInt(1, id);
				//thuc thi
				int num=preparedStatement.executeUpdate();
				System.out.println(num!=0?"xoa thanh cong":"xoa that bai");
				if(num>0)
				result=true;
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if(preparedStatement!=null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(connection!=null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return result;
		}
	//select
		public List<Book> getList(){
			List<Book> result = new ArrayList<Book>();
			// b1
				Connection conn =DBVConnection.getConnection();
				if (conn == null) {
					return result;
				}
				// PreparedStatement: thuc thi lenh sql tá»›i DB, nhÆ°ng cÃ³ há»— trá»£ cÆ¡ cháº¿ truyá»n tham sá»‘ vÃ o lá»‡nh truy váº¥n.
				PreparedStatement ps = null;
				try {
					// b2, b3
					String sql = "select id, name, price from book";
					ps = conn.prepareStatement(sql);
					// truyen tham so vao lenh: -> set
					// thuc thi lenh
					ResultSet rs = ps.executeQuery();
					// ResultSet Ä‘áº¡i diá»‡n cho táº­p dá»¯ liá»‡u dáº¡ng báº£ng tráº£ vá» tá»« cÃ¢u lá»‡nh query
					// duyet tung hang
					while(rs.next()) {
						// lay du lieu cac cot trong hang
						int id = rs.getInt(1);
						String name = rs.getString("name");
						float price = rs.getFloat("price");
						Book b = new Book(id, name, price);
						result.add(b);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					if (ps != null) {
						try {
							ps.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			
			
			return result;
		}

		
		
		
		
		
//		public List<Book> getList(){
//			List<Book> result= new ArrayList<Book>();
//			Connection connection=DBVConnection.getConnection();
//			if(connection==null) return result;
//			PreparedStatement preparedStatement=null;
//			try {
//				String sql="select id, name,price from book";
//				preparedStatement=connection.prepareStatement(sql);
//				//truyen tham so vao lenh-> set 
//	
//				//thuc thi
//				ResultSet rs=preparedStatement.executeQuery();
//				// resultSet dai dien cho du lieu tra ve
//				while(rs.next()) {
//					//lay du lieu cac cot trong hang;
//					int id=rs.getInt(1);
//					String name=rs.getString("name");
//					float price =rs.getFloat("price");
//					Book book= new Book(id, name, price);
//					result.add(book); 
//				}
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//			} finally {
//				if(preparedStatement!=null) {
//					try {
//						preparedStatement.close();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				if(connection!=null) {
//					try {
//						connection.close();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			return result;
//		}
	//insertBatch
}
