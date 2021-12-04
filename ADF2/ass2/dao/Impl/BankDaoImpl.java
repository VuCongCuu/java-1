package ass2.dao.Impl;

import ass2.dao.BankDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ass2.DBConnection;
import ass2.Obj.GiaoDich;
import ass2.Obj.KHTK;
import ass2.Obj.KHTKGD;
import ass2.Obj.KhachHang;
import ass2.Obj.NapTien;
import ass2.Obj.NhapSelect;
import ass2.Obj.RutTien;
import ass2.Obj.TaiKhoan;
import ass2.util.Contants;
import ass2.util.ResponseObject;
public class BankDaoImpl implements BankDao {
	private static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	private static Scanner sc= new Scanner(System.in);
	// check
	
	private static boolean checksoTK(String soTK) {
		boolean ress=false;
			BankDao kh= new BankDaoImpl();
			List<TaiKhoan> listtk= kh.getListTK();
			for(TaiKhoan tk :listtk) {
				if(tk.getSoTK().equalsIgnoreCase(soTK)) {
					ress=true;
				}
			}
			
		return ress;
	}
		public static boolean checkmaKH(String maKH) {
			boolean res=false;
			BankDao kh= new BankDaoImpl();
			List<KHTK> listttkh=kh.ttKH();
			for(KHTK  g: listttkh) {
				if(g.getMaKH().equalsIgnoreCase(maKH)) {
					res=true;
				}
			}
			
			return res;
		}
	
	// khach hang
	@Override
	public ResponseObject insertCustomer(KhachHang customer) {
		// TODO Auto-generated method stub
		ResponseObject res=null;
		if(customer==null||customer.getNgaySinh()==null||customer.getMaKH().equals("")||customer.getTenKH().equals("")
				||customer.getCmt().equals("")||customer.getSdt().equals("")||customer.getEmail().equals("")
				|| customer.getGioiTinh().equals("")||customer.getAddress().equals("")||customer.getLoaiKH().equals("")) {
			res= new ResponseObject(Contants.RES_NOT_VALIDATE, "Tham số đầu vào không đúng");
			return res;	
		}
		Connection conn= DBConnection.getInstance().getConnection();
		if(conn==null) {
			res=new ResponseObject(Contants.RES_NOT_CONNECT,"Ket noi DB khong thanh cong");
			return res;
		}
			PreparedStatement ps= null;
			String sql="INSERT INTO KhachHang values(?,?,?,?,?,CONVERT(date,?,103),?,?,?)";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, customer.getMaKH());
				ps.setString(2, customer.getTenKH());
				ps.setString(3, customer.getCmt());
				ps.setString(4, customer.getSdt());
				ps.setString(5, customer.getEmail());			
				ps.setString(6, sdf.format(customer.getNgaySinh()));
				ps.setInt(7,customer.getGioiTinh());
				ps.setString(8, customer.getMaKH());
				ps.setInt(9, customer.getLoaiKH());
				int num=ps.executeUpdate();
				if(num>0) {
					res=new ResponseObject(Contants.RES_SUCCESS,"Them moi thanh cong");				
				} else {
					res=new ResponseObject(Contants.RES_FAIL, "Them khong thanh cong");				
				}
			} catch (Exception e) {
				// TODO: handle exception
				res = new ResponseObject(Contants.RES_FAIL, e.getMessage());
			} finally {
				if(ps!= null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			DBConnection.getInstance().closeConnection(conn);
		return res;
	}

	@Override
	public ResponseObject upDateCutomer(KhachHang customer, String maKH) {
		ResponseObject res=null;
		if(customer==null||customer.getNgaySinh()==null||customer.getMaKH().equals("")||customer.getTenKH().equals("")
				||customer.getCmt().equals("")||customer.getSdt().equals("")||customer.getEmail().equals("")
				|| customer.getGioiTinh().equals("")||customer.getAddress().equals("")||customer.getLoaiKH().equals("")||maKH.equals("")) {
			res= new ResponseObject(Contants.RES_NOT_VALIDATE, "Tham số đầu vào không đúng");
			return res;	
		}
		Connection conn= DBConnection.getInstance().getConnection();
		if(conn==null) {
			res=new ResponseObject(Contants.RES_NOT_CONNECT,"Ket noi DB khong thanh cong");
			return res;
		}
			PreparedStatement ps= null;
			String sql="Update KhachHang set maKH=?,tenKH=?,cmt=?,sdt=?,email=?,ngaysinh=CONVERT(date,?,103),gioitinh=?,addres=?,loaiKH=? where maKH=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, customer.getMaKH());
				ps.setString(2, customer.getTenKH());
				ps.setString(3, customer.getCmt());
				ps.setString(4, customer.getSdt());
				ps.setString(5, customer.getEmail());
				ps.setString(6, sdf.format(customer.getNgaySinh()));
				ps.setInt(7,customer.getGioiTinh());
				ps.setString(8, customer.getMaKH());
				ps.setInt(9, customer.getLoaiKH());
				ps.setString(10, maKH);
				int num=ps.executeUpdate();
				if(num>0) {
					res=new ResponseObject(Contants.RES_SUCCESS,"Update thanh cong");				
				} else {
					res=new ResponseObject(Contants.RES_FAIL, "Update khong thanh cong");				
				}
			} catch (Exception e) {
				// TODO: handle exception
				res = new ResponseObject(Contants.RES_FAIL, e.getMessage());
			} finally {
				if(ps!= null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			DBConnection.getInstance().closeConnection(conn);
		return res;
	}

	@Override       
	public ResponseObject deleteCutomer(String maKH) {
		ResponseObject res=null;
		if(maKH.equals("")) {
			res= new ResponseObject(Contants.RES_NOT_VALIDATE, "Tham số đầu vào không đúng");
			return res;	
		}
		Connection conn= DBConnection.getInstance().getConnection();
		if(conn==null) {
			res=new ResponseObject(Contants.RES_NOT_CONNECT,"Ket noi DB khong thanh cong");
			return res;
		}
			PreparedStatement ps= null;
			String sql="delete from KhachHang where maKH =?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, maKH);
				int num=ps.executeUpdate();
				if(num>0) {
					res=new ResponseObject(Contants.RES_SUCCESS,"xoa thanh cong");				
				} else {
					res=new ResponseObject(Contants.RES_FAIL, "Khach Hang da tao tai khoan khong the xoa");				
				}
			} catch (Exception e) {
				// TODO: handle exception
				res = new ResponseObject(Contants.RES_FAIL, e.getMessage());
			} finally {
				if(ps!= null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			DBConnection.getInstance().closeConnection(conn);
		return res;
	}

	@Override
	public List<KhachHang> getList() {
		// TODO Auto-generated method stub
		List<KhachHang> res=new ArrayList<KhachHang>();
		Connection conn=DBConnection.getInstance().getConnection();
		if(conn==null) {
			return res;
		}
		String sql="select * from KhachHang";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				KhachHang kh= new KhachHang();
				kh.setId(rs.getInt("idKH"));
				kh.setMaKH(rs.getString("maKH"));
				kh.setTenKH(rs.getString("tenKH"));
				kh.setCmt(rs.getString("cmt"));
				kh.setSdt(rs.getString("sdt"));
				kh.setEmail(rs.getString("email"));
				kh.setNgaySinh((Date)rs.getDate("ngaysinh"));			
				kh.setGioiTinh(rs.getInt("gioitinh"));
				kh.setAddress(rs.getString("addres"));
				kh.setLoaiKH(rs.getInt("loaiKH"));
				res.add(kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		DBConnection.getInstance().closeConnection(conn);
		return res;
	}
	
	
	// Tai khoan
	@Override
	public ResponseObject insertTK(TaiKhoan taikhoan) {
		ResponseObject res=null;
		if(taikhoan==null||taikhoan.getIdKH().equals("")||taikhoan.getSoTK().equals("")||taikhoan.getLoaiTK().equals("")||taikhoan.getTrangthai().equals("")||taikhoan.getNgaytao()==null||taikhoan.getSoDuTK()<0||taikhoan.getHanmuc()<0) {
			res= new ResponseObject(Contants.RES_NOT_VALIDATE, "Tham số đầu vào không đúng");
			return res;	
		}
		Connection connn= DBConnection.getInstance().getConnection();
		if(connn==null) {
			res=new ResponseObject(Contants.RES_NOT_CONNECT,"Ket noi DB khong thanh cong");
			return res;
		}
			PreparedStatement ps= null;
			String sql="insert into TaiKhoan values (?,?,?,?,CONVERT(date,?,103),?,?)";
			try {
				ps=connn.prepareStatement(sql);
				ps.setInt(1, taikhoan.getIdKH());
				ps.setString(2, taikhoan.getSoTK());
				ps.setInt(3, taikhoan.getLoaiTK());
				ps.setInt(4, taikhoan.getTrangthai());
				ps.setString(5, sdf.format(taikhoan.getNgaytao()));
				ps.setInt(6, taikhoan.getSoDuTK());			
				ps.setInt(7,taikhoan.getHanmuc());
				
				int num=ps.executeUpdate();
				if(num>0) {
					res=new ResponseObject(Contants.RES_SUCCESS,"Them moi thanh cong");				
				} else {
					res=new ResponseObject(Contants.RES_FAIL, "Them khong thanh cong");				
				}
			} catch (Exception e) {
				// TODO: handle exception
				res = new ResponseObject(Contants.RES_FAIL, e.getMessage());
			} finally {
				if(ps!= null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			DBConnection.getInstance().closeConnection(connn);
		return res;
	}
	@Override
	public ResponseObject upDateTK(int tiennap, String soTK) {
		ResponseObject res=null;
		if(tiennap<0||soTK==null) {
			res= new ResponseObject(Contants.RES_NOT_VALIDATE, "Tham số đầu vào không đúng");
			return res;	
		}
		Connection conn= DBConnection.getInstance().getConnection();
		if(conn==null) {
			res=new ResponseObject(Contants.RES_NOT_CONNECT,"Ket noi DB khong thanh cong");
			return res;
		}
			PreparedStatement ps= null;
			String sql="Update TaiKhoan set soDuTK=? where soTK=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, tiennap);
				ps.setString(2, soTK);
				int num=ps.executeUpdate();
				if(num>0) {
					res=new ResponseObject(Contants.RES_SUCCESS,"Update thanh cong");				
				} else {
					res=new ResponseObject(Contants.RES_FAIL, "Update khong thanh cong");				
				}
			} catch (Exception e) {
				// TODO: handle exception
				res = new ResponseObject(Contants.RES_FAIL, e.getMessage());
			} finally {
				if(ps!= null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			DBConnection.getInstance().closeConnection(conn);
		return res;
	}
	@Override
	public ResponseObject upDateTKvisa(int tienrut,String soTK) {
		ResponseObject res=null;
		Connection conn= DBConnection.getInstance().getConnection();
		if(conn==null) {
			res=new ResponseObject(Contants.RES_NOT_CONNECT,"Ket noi DB khong thanh cong");
			return res;
		}
			PreparedStatement ps= null;
			String sql="Update TaiKhoan set soDuTK=?,hanmuc=? where soTK=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, tienrut);
				ps.setInt(2, tienrut);
				ps.setString(3, soTK);
				int num=ps.executeUpdate();
				if(num>0) {
					res=new ResponseObject(Contants.RES_SUCCESS,"Update thanh cong");				
				} else {
					res=new ResponseObject(Contants.RES_FAIL, "Update khong thanh cong");				
				}
			} catch (Exception e) {
				// TODO: handle exception
				res = new ResponseObject(Contants.RES_FAIL, e.getMessage());
			} finally {
				if(ps!= null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			DBConnection.getInstance().closeConnection(conn);
		return res;
	}
	
	
	@Override
	public List<TaiKhoan> getListTK() {
		List<TaiKhoan> res=new ArrayList<TaiKhoan>();
		Connection connn=DBConnection.getInstance().getConnection();
		if(connn==null) {
			return res;
		}
		String sql="select * from TaiKhoan";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=connn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				TaiKhoan tk= new TaiKhoan();
				tk.setIdTK(rs.getInt("idTK"));
				tk.setIdKH(rs.getInt("idKH"));
				tk.setSoTK(rs.getString("soTK"));
				tk.setLoaiTK(rs.getInt("loaiTK"));
				tk.setTrangthai(rs.getInt("trangthai"));
				tk.setNgaytao((Date) rs.getDate("ngaytao"));
				tk.setSoDuTK(rs.getInt("soDuTK"));
				tk.setHanmuc(rs.getInt("hanmuc"));
				res.add(tk);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		DBConnection.getInstance().closeConnection(connn);
		return res;
	}
	
	@Override
	public List<TaiKhoan> getListTaiKhoan(String sTK) {
		List<TaiKhoan> res=new ArrayList<TaiKhoan>();
		Connection connn=DBConnection.getInstance().getConnection();
		if(connn==null) {
			return res;
		}
		String sql="select * from TaiKhoan WHERE soTK=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=connn.prepareStatement(sql);
			ps.setString(1, sTK);
			rs=ps.executeQuery();
			while(rs.next()) {
				TaiKhoan tk= new TaiKhoan();
				tk.setIdTK(rs.getInt("idTK"));
				tk.setIdKH(rs.getInt("idKH"));
				tk.setSoTK(rs.getString("soTK"));
				tk.setLoaiTK(rs.getInt("loaiTK"));
				tk.setTrangthai(rs.getInt("trangthai"));
				tk.setNgaytao((Date) rs.getDate("ngaytao"));
				tk.setSoDuTK(rs.getInt("soDuTK"));
				tk.setHanmuc(rs.getInt("hanmuc"));
				res.add(tk);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		DBConnection.getInstance().closeConnection(connn);
		return res;
	}
	
	
	
	// Thong tin khach hang
	@Override
	public List<KHTK> ttKH() {
		List<KHTK> res=new ArrayList<KHTK>();
		Connection conn=DBConnection.getInstance().getConnection();
		if(conn==null) {
			return res;
		}
		String sql="SELECT * FROM  KhachHang AS a INNER JOIN TaiKhoan AS b ON b.idKH=a.idKH";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				KHTK ttkh= new KHTK();
				ttkh.setIdKH(rs.getInt("idKH"));
				ttkh.setMaKH(rs.getString("maKH"));
				ttkh.setTenKH(rs.getString("tenKH"));
				ttkh.setCmt(rs.getString("cmt"));
				ttkh.setSdt(rs.getString("sdt"));
				ttkh.setEmail(rs.getString("email"));
				ttkh.setNgaySinh((Date)rs.getDate("ngaysinh"));			
				ttkh.setGioiTinh(rs.getInt("gioitinh"));
				ttkh.setAddress(rs.getString("addres"));
				ttkh.setLoaiKH(rs.getInt("loaiKH"));
				ttkh.setIdTK(rs.getInt("idTK"));
				ttkh.setSoTK(rs.getString("soTK"));
				ttkh.setLoaiTK(rs.getInt("loaiTK"));
				ttkh.setTrangthai(rs.getInt("trangthai"));
				ttkh.setNgaytao((Date) rs.getDate("ngaytao"));
				ttkh.setSoDuTK(rs.getInt("soDuTK"));
				ttkh.setHanmuc(rs.getInt("hanmuc"));
				res.add(ttkh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		DBConnection.getInstance().closeConnection(conn);
		return res;
	}
	@Override
	public List<KHTK> ttKhachHang(String maKH) {
		List<KHTK> res=new ArrayList<KHTK>();
		Connection conn=DBConnection.getInstance().getConnection();
		if(conn==null) {
			return res;
		}
		String sql="SELECT * FROM  KhachHang AS a INNER JOIN TaiKhoan AS b ON b.idKH=a.idKH WHERE maKH=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,maKH);
			rs=ps.executeQuery();
			while(rs.next()) {
				KHTK ttkh= new KHTK();
				ttkh.setIdKH(rs.getInt("idKH"));
				ttkh.setMaKH(rs.getString("maKH"));
				ttkh.setTenKH(rs.getString("tenKH"));
				ttkh.setCmt(rs.getString("cmt"));
				ttkh.setSdt(rs.getString("sdt"));
				ttkh.setEmail(rs.getString("email"));
				ttkh.setNgaySinh((Date)rs.getDate("ngaysinh"));			
				ttkh.setGioiTinh(rs.getInt("gioitinh"));
				ttkh.setAddress(rs.getString("addres"));
				ttkh.setLoaiKH(rs.getInt("loaiKH"));
				ttkh.setIdTK(rs.getInt("idTK"));
				ttkh.setSoTK(rs.getString("soTK"));
				ttkh.setLoaiTK(rs.getInt("loaiTK"));
				ttkh.setTrangthai(rs.getInt("trangthai"));
				ttkh.setNgaytao((Date) rs.getDate("ngaytao"));
				ttkh.setSoDuTK(rs.getInt("soDuTK"));
				ttkh.setHanmuc(rs.getInt("hanmuc"));
				res.add(ttkh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		DBConnection.getInstance().closeConnection(conn);
		return res;
	}
	@Override
	public List<KHTKGD> thongtin(String maKH) {
		List<KHTKGD> res=new ArrayList<KHTKGD>();
		Connection conn=DBConnection.getInstance().getConnection();
		if(conn==null||maKH==null) {
			return res;
		}
		String sql="SELECT * FROM  KhachHang as a  INNER JOIN TaiKhoan as b ON b.idKH=a.idKH INNER JOIN GiaoDich as c ON c.soTKGD=b.soTK where  maKH=? ORDER BY ngayGD ASC,soTK ASC";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,maKH);
			rs=ps.executeQuery();
			while(rs.next()) {
				KHTKGD ttkhgd= new KHTKGD();
				ttkhgd.setIdKH(rs.getInt("idKH"));
				ttkhgd.setMaKH(rs.getString("maKH"));
				ttkhgd.setTenKH(rs.getString("tenKH"));
				ttkhgd.setCmt(rs.getString("cmt"));
				ttkhgd.setSdt(rs.getString("sdt"));
				ttkhgd.setEmail(rs.getString("email"));
				ttkhgd.setNgaySinh((Date)rs.getDate("ngaysinh"));			
				ttkhgd.setGioiTinh(rs.getInt("gioitinh"));
				ttkhgd.setAddress(rs.getString("addres"));
				ttkhgd.setLoaiKH(rs.getInt("loaiKH"));
				ttkhgd.setIdTK(rs.getInt("idTK"));
				ttkhgd.setSoTK(rs.getString("soTK"));
				ttkhgd.setLoaiTK(rs.getInt("loaiTK"));
				ttkhgd.setTrangthai(rs.getInt("trangthai"));
				ttkhgd.setNgaytao((Date) rs.getDate("ngaytao"));
				ttkhgd.setSoDuTK(rs.getInt("soDuTK"));
				ttkhgd.setHanmuc(rs.getInt("hanmuc"));
				ttkhgd.setIdGD(rs.getInt("idGD"));
				ttkhgd.setLoaiTT(rs.getInt("loaiTT"));
				ttkhgd.setTienRutNap(rs.getInt("sotien"));
				ttkhgd.setNgayGD((Date) rs.getDate("ngayGD"));
				ttkhgd.setAddressGD(rs.getString("addressGD"));
				res.add(ttkhgd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		DBConnection.getInstance().closeConnection(conn);
		return res;
	}

	
	
	// Giao dich

	@Override
	public List<GiaoDich> getListGD(String soTK) {
		List<GiaoDich> res=new ArrayList<GiaoDich>();
		Connection connn=DBConnection.getInstance().getConnection();
		if(connn==null) {
			return res;
		}
		String sql="select * from GiaoDich where soTK=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=connn.prepareStatement(sql);
			ps.setString(1, soTK);
			rs=ps.executeQuery();
			while(rs.next()) {
				GiaoDich gd= new GiaoDich();
				gd.setIdGD(rs.getInt("idGD"));
				gd.setSoTK(rs.getString("soTKGD"));
				gd.setLoaiTT(rs.getInt("loaiTT"));
				gd.setTienRutNap(rs.getInt("sotien"));
				gd.setNgayGD((Date) rs.getDate("ngayGD"));
				gd.setAddressGD(rs.getString("addressGD"));
				res.add(gd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		DBConnection.getInstance().closeConnection(connn);
		return res;
	}

	@Override
	public ResponseObject insertGD(GiaoDich giaodich) {
		ResponseObject res=null;
		if(giaodich==null||giaodich.getSoTK().equals("")||giaodich.getLoaiTT().equals("")||giaodich.getNgayGD()==null||giaodich.getAddressGD().equals("")||giaodich.getTienRutNap().equals("")) {
			res= new ResponseObject(Contants.RES_NOT_VALIDATE, "Tham số đầu vào không đúng");
			return res;	
		}
		Connection connn= DBConnection.getInstance().getConnection();
		if(connn==null) {
			res=new ResponseObject(Contants.RES_NOT_CONNECT,"Ket noi DB khong thanh cong");
			return res;
		}
			PreparedStatement ps= null;
			String sql="insert into GiaoDich values (?,?,?,CONVERT(date,?,103),?)";
			try {
				ps=connn.prepareStatement(sql);
				ps.setString(1, giaodich.getSoTK());
				ps.setInt(2, giaodich.getLoaiTT());			
				ps.setInt(3, giaodich.getTienRutNap());			
				ps.setString(4, sdf.format(giaodich.getNgayGD()));
				ps.setString(5, giaodich.getAddressGD());
				
				int num=ps.executeUpdate();
				if(num>0) {
					res=new ResponseObject(Contants.RES_SUCCESS,"Them moi thanh cong");				
				} else {
					res=new ResponseObject(Contants.RES_FAIL, "Them khong thanh cong");				
				}
			} catch (Exception e) {
				// TODO: handle exception
				res = new ResponseObject(Contants.RES_FAIL, e.getMessage());
			} finally {
				if(ps!= null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			DBConnection.getInstance().closeConnection(connn);
		return res;
	}
	@Override
	public List<GiaoDich> getListGDDate(NhapSelect nhap) {
		List<GiaoDich> res=new ArrayList<GiaoDich>();
		Connection connn=DBConnection.getInstance().getConnection();
		if(connn==null||nhap.getNgaybatdau()==null||nhap.getNgayketthuc()==null||nhap.getSoTK().equals("")) {
			return res;
		}
		String sql="Select * from GiaoDich where  ngayGD>=CONVERT(date,?,103) And ngayGD<=CONVERT(date,?,103) And soTKGD=? ORDER BY ngayGD ASC";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=connn.prepareStatement(sql);
			ps.setString(1, sdf.format(nhap.getNgaybatdau()));
			ps.setString(2, sdf.format(nhap.getNgayketthuc()));
			ps.setString(3, nhap.getSoTK());
			rs=ps.executeQuery();
			while(rs.next()) {
				GiaoDich gd= new GiaoDich();
				gd.setIdGD(rs.getInt("idGD"));
				gd.setSoTK(rs.getString("soTKGD"));
				gd.setLoaiTT(rs.getInt("loaiTT"));
				gd.setTienRutNap(rs.getInt("sotien"));
				gd.setNgayGD((Date) rs.getDate("ngayGD"));
				gd.setAddressGD(rs.getString("addressGD"));
				res.add(gd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		DBConnection.getInstance().closeConnection(connn);
		return res;
	}
	// Rut
	@Override
	public ResponseObject insertGDRut(RutTien rut) {
		ResponseObject res=null;
		if(rut==null||rut.getTienrut()<0||rut.getAddressGD().equals("")||rut.getNgayGD()==null) {
			res= new ResponseObject(Contants.RES_NOT_VALIDATE, "Tham số đầu vào không đúng");
			return res;	
		}
		Connection connn= DBConnection.getInstance().getConnection();
		if(connn==null) {
			res=new ResponseObject(Contants.RES_NOT_CONNECT,"Ket noi DB khong thanh cong");
			return res;
		}
			PreparedStatement ps= null;
			String sql="insert into GiaoDich values (?,?,?,CONVERT(date,?,103),?)";
			try {
				ps=connn.prepareStatement(sql);
				ps.setString(1, rut.getStk());
				ps.setInt(2, 2);			
				ps.setInt(3, rut.getTienrut());			
				ps.setString(4, sdf.format(rut.getNgayGD()));
				ps.setString(5, rut.getAddressGD());
				
				int num=ps.executeUpdate();
				if(num>0) {
					res=new ResponseObject(Contants.RES_SUCCESS,"Them moi thanh cong");				
				} else {
					res=new ResponseObject(Contants.RES_FAIL, "Them khong thanh cong");				
				}
			} catch (Exception e) {
				// TODO: handle exception
				res = new ResponseObject(Contants.RES_FAIL, e.getMessage());
			} finally {
				if(ps!= null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			DBConnection.getInstance().closeConnection(connn);
		return res;
	}

	//Nap
	@Override
	public ResponseObject insertGDNap(NapTien nap) {
		ResponseObject res=null;
		if(nap==null||nap.getSoTK().equals("")||nap.getTiennap()<0||nap.getAddressGD().equals("")||nap.getNgayGD()==null) {
			res= new ResponseObject(Contants.RES_NOT_VALIDATE, "Tham số đầu vào không đúng");
			return res;	
		}
		Connection connn= DBConnection.getInstance().getConnection();
		if(connn==null) {
			res=new ResponseObject(Contants.RES_NOT_CONNECT,"Ket noi DB khong thanh cong");
			return res;
		}
			PreparedStatement ps= null;
			String sql="insert into GiaoDich values (?,?,?,CONVERT(date,?,103),?)";
			try {
				ps=connn.prepareStatement(sql);
				ps.setString(1, nap.getSoTK());
				ps.setInt(2, 1);			
				ps.setInt(3, nap.getTiennap());			
				ps.setString(4, sdf.format(nap.getNgayGD()));
				ps.setString(5, nap.getAddressGD());
				
				int num=ps.executeUpdate();
				if(num>0) {
					res=new ResponseObject(Contants.RES_SUCCESS,"Them moi thanh cong");				
				} else {
					res=new ResponseObject(Contants.RES_FAIL, "Them khong thanh cong");				
				}
			} catch (Exception e) {
				// TODO: handle exception
				res = new ResponseObject(Contants.RES_FAIL, e.getMessage());
			} finally {
				if(ps!= null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			DBConnection.getInstance().closeConnection(connn);
		return res;
	}
	
	//--------------choose-------------------
	public static void choose_1() {
		while(true) {
			try {
				System.out.println("1. Them 1 khach hang ");
				System.out.println("2. Update 1 khach hang thong qua maKH ");
				System.out.println("3. Xoa 1 khach hang thong qua maKH ");
				System.out.println("4. Hien thi danh sach khach hang ");
				System.out.println("5. Thoat ");
				System.out.println("nhap nua chon :");				
				int choose1;
				choose1=sc.nextInt();
				BankDao kh= new BankDaoImpl();
				KhachHang customer= new KhachHang();
				
					switch(choose1) {
						case 1:
							System.out.println(" --------Them 1 khach hang------");
							customer.nhap();
							ResponseObject rs=kh.insertCustomer(customer);
							if(rs.getResCode()==1) {
								System.out.println("them thanh cong");
							} else {
								System.out.println("them khong thanh cong");
							}
							break;
						case 2:
							System.out.println("Update 1 khach hang thong qua maKH");
							sc.nextLine();
							System.out.println("Nhap maKH muon update:");
							String maKH=sc.nextLine();
							
							
								System.out.println("thong tin update");
								customer.nhap();
								ResponseObject rsu=kh.upDateCutomer(customer, maKH);
								if(rsu.getResCode()==1) {
									System.out.println("Update thanh cong");
								} else {
									
									System.out.println("Update khong thanh cong");
									}														
							
							break;
						case 3:
							System.out.println("---------Xoa 1 khach hang thong qua maKH---------");
							System.out.println("Nhap maKH muon xoa:");
							sc.nextLine();
							String maKH1=sc.nextLine();
										
								ResponseObject rsd=kh.deleteCutomer(maKH1);
								if(rsd.getResCode()==1) {
									System.out.println("xoa thanh cong");
								} else {
									System.out.println("xoa khong thanh cong khach hang da tao tai khoan");
								}
							break;
						case 4 :
							List<KhachHang> list= kh.getList();
							System.out.println("Hien thi danh sach khach hang");						
								for(KhachHang a: list) {
									System.out.println(a);
								}
							break;
						case 5 :
							break;
						default:
							System.out.println("P/s: Phai chon 1-5");					
					}
					if(choose1==5) {
						break;
					}	
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("PS: khong dung dinh dang");
				sc.nextLine();
			}
			
		}
		
	}
	public static void choose_2() {
		while(true) {
			int choose2;
			try {
				System.out.println("1.Tao moi 1 tai khoan");
				System.out.println("2.Nap tien vao tai khoan");
				System.out.println("3.Rut tien");
				System.out.println("4.Hiem thi thong tin theo SoTK");
				System.out.println("5.Hien thi cac thong tin theo ma idKH");
				System.out.println("6.thoat");
				choose2= sc.nextInt();
				BankDao kh= new BankDaoImpl();
				TaiKhoan tk= new TaiKhoan();
				List<KHTK> ttkh= kh.ttKH();
				List<TaiKhoan> listTk= kh.getListTK();
				
				switch(choose2) {
				 case 1 :
					 System.out.println("------Tao moi 1 tai khoan------");
					 tk.nhap();
					 ResponseObject rs=kh.insertTK(tk);
						if(rs.getResCode()==1) {
							System.out.println("them thanh cong");
						} else {
							System.out.println("them khong thanh cong idKH khong ton tai");
						}
					 break;
				 case 2 :
					 System.out.println("-----Nap tien vao tai khoan--------");
					 	NapTien nap= new NapTien();
						nap.nhap();
						System.out.println(nap);
						ResponseObject rsa=kh.insertGDNap(nap);
						if(rsa.getResCode()==1) {
							System.out.println("them thanh cong");
						} else {
							System.out.println("them khong thanh cong");
						}
					 break;
				 case 3 :
					 System.out.println("----------Rut tien-----------");
					 RutTien r= new RutTien();
						r.nhaprut();
						System.out.println(r);
						ResponseObject rsab=kh.insertGDRut(r);
						if(rsab.getResCode()==1) {
							System.out.println("them thanh cong");
						} else {
							System.out.println("them khong thanh cong");
						}
						
					 break;
				 case 4 :
					 System.out.println("----Hiem thi thong tin theo SoTK------");
					 sc.nextLine();
					 System.out.println("nhap soTK");
					 String t =sc.nextLine();
					 boolean checkstk=checksoTK(t);
					 if(checkstk==true) {
						 List<TaiKhoan> tkhoan=kh.getListTaiKhoan(t);
						 for(TaiKhoan h: tkhoan) {
							 System.out.println(h);
						 }						 
					 } else {
						 System.out.println("khong co thong tin tu soTK : "+ t);
					 }
					 break;
				 case 5 :
					 System.out.println("----Hien thi cac thong tin theo ma KH------");
					 sc.nextLine();
					 	System.out.println("Nhap mã KH:");
					 	String ma= sc.nextLine();
					 	boolean check= checkmaKH(ma);
					 	if(check==true) {
					 		List<KHTK> listt= kh.ttKhachHang(ma);
					 		for(KHTK h:listt) {
					 			System.out.println(h);
					 		}
					 	} else {
					 		System.out.println("khng co thong tin tu maKH : "+ ma);
					 	}
					 break;
				 case 6:
					 break;
				 default:
						System.out.println("P/s: Phai chon 1-6");					
				}
				if(choose2==6) {
					break;
				} 
			} catch (Exception e) {
				System.out.println("nhap ky tu so: 1->5");
				
			}
		}
		
	}
	public static void choose_3() {
		while(true) {
			try {
				System.out.println("1.Hien thi thong tin giao dich theo thoi gian");
				System.out.println("2.Hien thi thong tin giao dich cua khach hang tai khoan");
				System.out.println("3.Xuat File");
				System.out.println("4.Thoat");	
				BankDao kh= new BankDaoImpl();
				int choose3=sc.nextInt();
				switch(choose3) {
					case 1 :
						try {
							sc.nextLine();
							System.out.println("Hien thi thong tin giao dich theo thoi gian");
							NhapSelect nhapa= new NhapSelect();
							nhapa.nhap();
							boolean k=checksoTK(nhapa.getSoTK());
							if(k==true) {								
								List<GiaoDich> listtt =kh.getListGDDate(nhapa);
								for(GiaoDich abc:listtt) {
									System.out.println(abc);
								}
							} else {
								System.out.println("Sotk Khong ton tai");
							}
							
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						break;
					case 2 :					
							sc.nextLine();
							System.out.println("-----Hien thi thong tin giao dich cua khach hang qua maKH-------");
							System.out.println("Nhap maKH:");
							String m= sc.nextLine();
							boolean ch=checkmaKH(m) ;
							if(ch==true) {
								List<KHTKGD> g= kh.thongtin(m);
								for(KHTKGD fd: g) {
									System.out.println(fd);
								}								
							} else {
								System.out.println("Khong ton tai  maKH");
							}
													
						break;
					case 3 :
						
						break;
				}
				if(choose3==4) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Nhap ky tu so 1->4");
			}
		}
	}
	
	public static void main(String[] args) {
		BankDao bk= new BankDaoImpl();
		GiaoDich gd= new GiaoDich();
		String a="1";
		List<KHTKGD> g= bk.thongtin(a);
		for(KHTKGD fd: g) {
			System.out.println(fd);
		}
		
//		String sd="123456";
//		List<GiaoDich> gh= bk.getListGD(sd);
//		for(GiaoDich f:gh) {
//			System.out.println(f);
//		}
//		Date a=null;
//		Date b = null;
//		String sTK="123456";
//		System.out.println("nhap a");
//		try {
//			a=sdf.parse(sc.nextLine());
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println("nhap b");
//		try {
//			b= sdf.parse(sc.nextLine());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		NhapSelect nhapa= new NhapSelect();
//		nhapa.nhap();
//		List<GiaoDich> listtt =bk.getListGDDate(nhapa);
//		for(GiaoDich abc:listtt) {
//			System.out.println(abc);
//		}
		
//		gd.nhap();
//		ResponseObject rs=bk.insertGD(gd);
//		if(rs.getResCode()==1) {
//			System.out.println("them thanh cong");
//		} else {
//			System.out.println("them khong thanh cong"+rs.getResDesc());
//		}
//		List<GiaoDich> listgd=bk.getListGD();
//		for(GiaoDich a: listgd) {
//			System.out.println(a);
//		}
	}

	
}
