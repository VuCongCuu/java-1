package buoi8.bvn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import buoi8.DBVConnection;

public class SinhVien {
	public static boolean taoDMKhoa() {
		Boolean res=false;
		Connection conn= DBVConnection.getConnection();
		if(conn==null) {
			return false;
		}	
		Statement ps=null;		
		try {
			String sql= "create table Khoa( "
					+ "MaKhoa int primary key,"
					+ "TenKhoa nvarchar(50) not null"
					+ ")";
			ps=conn.createStatement();
			boolean a= ps.execute(sql);
				res= true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Da co bang Khoa ");
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
	public static boolean DMSinhVien() {
		Boolean res=false;
		Connection conn= DBVConnection.getConnection();
		if(conn==null) {
			return false;
		}	
		Statement ps=null;		
		try {
			String sql= "create table SinhVien("
					+ " MaSV char(3) not null primary key,"
					+ "TenSV nvarchar(7) not null,"
					+ "GioiTinh nchar(7),"
					+ "MaKhoa int, CONSTRAINT FK_P FOREIGN KEY (MaKhoa) REFERENCES Khoa(MaKhoa)"
					+ ")";
			ps=conn.createStatement();
			boolean a= ps.execute(sql);
			res= true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Da co bang Sinh Vien ");
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
	public static boolean DMMonHoc() {
		Boolean res=false;
		Connection conn= DBVConnection.getConnection();
		if(conn==null) {
			return false;
		}	
		Statement ps=null;		
		try {
			String sql= "create table MonHoc( "
					+ "MaMH char(2) not null primary key,"
					+ "TenMH nvarchar(25) not null,"
					+"SoTiet int"
					+ ")";
			ps=conn.createStatement();
			boolean a= ps.execute(sql);
				res= true;		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Da co bang MonHoc ");
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
	public static boolean KetQua() {
		Boolean res=false;
		Connection conn= DBVConnection.getConnection();
		if(conn==null) {
			return false;
		}	
		Statement ps=null;		
		try {
			String sql= "create table KetQua("
					+ " MaSV char(3) not null,CONSTRAINT FK_masv FOREIGN KEY (Masv) REFERENCES SinhVien(MaSV),"
					+ "MaMH char(2) not null,CONSTRAINT FK_mamh FOREIGN KEY (MaMH) REFERENCES MonHoc(MaMH),"
					+"Diem int"
					+ ")";
			ps=conn.createStatement();
			boolean a= ps.execute(sql);
				res= true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Da co bang KetQua ");
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
	//---------xoa bang------------
	public static boolean xoaKetQua() {
		Boolean res=false;
		Connection conn= DBVConnection.getConnection();
		if(conn==null) {
			return false;
		}	
		Statement ps=null;		
		try {
			String sql= "DROP TABLE KetQua";
			ps=conn.createStatement();
			boolean a= ps.execute(sql);
			res= true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Da co bang KetQua ");
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
	public static boolean xoaMonHoc() {
		Boolean res=false;
		Connection conn= DBVConnection.getConnection();
		if(conn==null) {
			return false;
		}	
		Statement ps=null;		
		try {
			String sql= "DROP TABLE MonHoc";
			ps=conn.createStatement();
			boolean a= ps.execute(sql);
			res= true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Da co bang KetQua ");
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
	public static boolean xoaKhoa() {
		Boolean res=false;
		Connection conn= DBVConnection.getConnection();
		if(conn==null) {
			return false;
		}	
		Statement ps=null;		
		try {
			String sql= "DROP TABLE khoa";
			ps=conn.createStatement();
			boolean a= ps.execute(sql);
			res= true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Da co bang KetQua ");
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
	public static boolean xoaSinhVien() {
		Boolean res=false;
		Connection conn= DBVConnection.getConnection();
		if(conn==null) {
			return false;
		}	
		Statement ps=null;		
		try {
			String sql= "DROP TABLE SinhVien";
			ps=conn.createStatement();
			boolean a= ps.execute(sql);
			res= true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Da co bang KetQua ");
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
//	public static boolean dropTable(String name) {
//		boolean res=false;
//		Connection conn= DBVConnection.getConnection();
//		PreparedStatement ps=null;
//		try {
//			String sql="DROP TABLE ?";
//			ps=conn.prepareStatement(sql);
//			ps.setString(1,name);
//			int num=ps.executeUpdate();
//			System.out.println(num!=0?"xoa thanh cong":"xoa that bai");
//			if(num>0)
//			res=true;
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("khong co bang can xoa ");
//			e.printStackTrace();
//		} finally {
//			DBVConnection.closeConnetion(conn);
//			if(ps!=null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return res;
//	}
	//-------------add-------------
	public static boolean addKhoa(int maKhoa,String tenKhoa) {
		boolean res=false;
			Connection conn=DBVConnection.getConnection();
			Statement ps= null;
			try {
				String sql="insert into khoa values("+maKhoa+",'"+tenKhoa+"')";
				ps=conn.createStatement();
				int a=ps.executeUpdate(sql);
				System.out.println("Add : "+(a>0?"thanh cong":"that bai"));
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
	public static boolean addSinhVien(SinhVienDao sinhvien) {
		boolean res=false;
		Connection conn=DBVConnection.getConnection();
		PreparedStatement ps= null;
		try {
			String sql="insert into sinhvien values(?,?,?,?)";
			ps=conn.prepareStatement(sql);		
			ps.setString(1,sinhvien.getMaSV());
			ps.setString(2,sinhvien.getTenSV());
			ps.setString(3,sinhvien.getGioiTinh());
			ps.setInt(4,sinhvien.getMaKhoa());
			int a=ps.executeUpdate();
			System.out.println("Add : "+(a>0?"thanh cong":"that bai"));
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
	public static boolean addMonHoc(String maMH,String tenMH,int soTiet) {
		boolean res=false;
		Connection conn=DBVConnection.getConnection();
		Statement ps= null;
		try {
			String sql="insert into sinhvien values('"+maMH+"','"+tenMH+"',"+soTiet+")";
			ps=conn.createStatement();
			int a=ps.executeUpdate(sql);
			System.out.println("Add : "+(a>0?"thanh cong":"that bai"));
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
	public static boolean addKetQua(String maSV,String maMH,int diem) {
		boolean res=false;
		Connection conn=DBVConnection.getConnection();
		Statement ps= null;
		try {
			String sql="insert into sinhvien values('"+maSV+"','"+maMH+"',"+diem+")";
			ps=conn.createStatement();
			int a=ps.executeUpdate(sql);
			System.out.println("Add : "+(a>0?"thanh cong":"that bai"));
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
	
	
	Scanner sc= new Scanner(System.in);
	//   ---------------tao ban g------------------------
	public void choose_1(){
		System.out.println("1.tao bang khoa");
		System.out.println("2.tao bang sinh vien");
		System.out.println("3.tao bang mon hoc");
		System.out.println("4.tao bang ket qua");
		System.out.println("5 thoat");
		int choose=sc.nextInt();
		switch(choose) {
		case 1:
			System.out.println("Tao bang Khoa : "+(taoDMKhoa()==true?"Thanh cong":"That bai")); 
			break;
		case 2:
			System.out.println("Tao bang Sinh vien : "+(DMSinhVien()==true?"Thanh cong":"That bai")); 
			break;
		case 3:
			System.out.println("Tao bang Mon hoc : "+(DMMonHoc()==true?"Thanh cong":"That bai")); 
			break;
		case 4:
			System.out.println("Tao bang ket qua : "+(KetQua()==true?"Thanh cong":"That bai")); 
			break;
		case 5:
			break;
		}
	}
	
	public static void main(String[] args) {
		SinhVien sv= new SinhVien();
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("1.tao bang");
			System.out.println("2.add bang");
			System.out.println("3.xoa bang");
			System.out.println("4.tao bang");
			System.out.println("5.thoat");
			int choose= sc.nextInt();
			
			switch(choose) {
			case 1:
				sv.choose_1();				
				break;
			case 2:				
				System.out.println("1.id");
				int b=sc.nextInt();
				sc.nextLine();
				System.out.println("2.name");
				String c=sc.nextLine();
				System.out.println("ADD bang : "+(addKhoa(b, c)==true?"thanh cong":"that bai"));
				
				break;
			case 3:
					System.out.println("1.Xoa bang khoa ");
					System.out.println("2.Xoa bang sinh vien ");
					System.out.println("3.Xoa bang mon hoc ");
					System.out.println("4.Xoa bang ket qua ");
					System.out.println("5.thoat ");
					sc.nextLine();
					int name= sc.nextInt();
					switch(name) {
					 case 1 :
						System.out.println("Xoa bang : "+(xoaKhoa()==true?"thanh cong":"that bai"));
						break;
					case 2:
						System.out.println("Xoa bang : "+(xoaSinhVien()==true?"thanh cong":"that bai"));
						break;
					case 3:
						System.out.println("Xoa bang : "+(xoaMonHoc()==true?"thanh cong":"that bai"));
						break;
					case 4:
						System.out.println("Xoa bang : "+(xoaKetQua()==true?"thanh cong":"that bai"));
						break;
					case 5:
						break;
					}
						
					break;
				case 4:
					SinhVienDao sv1= new SinhVienDao();
					sv1.sinhvienNhap();
					addSinhVien(sv1);
					break;
				case 5:		
					break;
			}
		}
		
	}
}
