package ass2.Obj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ass2.dao.BankDao;
import ass2.dao.Impl.BankDaoImpl;

public class TaiKhoan {
	private  BankDao ban= new BankDaoImpl();
	private  List<KhachHang> dsKhachHang=ban.getList();
	private int idTK;
	private int idKH;
	private String soTK;
	private int loaiTK;
	private int trangthai;
	private Date ngaytao;
	private int soDuTK;
	private int hanmuc;
	private SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	public TaiKhoan() {
		super();
	}
	public Integer getIdTK() {
		return idTK;
	}
	public void setIdTK(int idTK) {
		this.idTK = idTK;
	}
	public Integer getIdKH() {
		return idKH;
	}
	public void setIdKH(int idKH) {
		this.idKH = idKH;
	}
	public  String getSoTK() {
		return soTK;
	}
	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}
	public Integer getLoaiTK() {
		return loaiTK;
	}
	public void setLoaiTK(int loaiTK) {
		this.loaiTK = loaiTK;
	}
	public Integer getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public Date getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
	
	public int getSoDuTK() {
		return soDuTK;
	}
	public void setSoDuTK(int soDuTK) {
		this.soDuTK = soDuTK;
	}
	public int getHanmuc() {
		return hanmuc;
	}	
	public void setHanmuc(int hanmuc) {
		this.hanmuc = hanmuc;
	}

	Scanner sc= new Scanner(System.in);
	public void nhap() {
		while(true) {
			try {
				System.out.println("Nhap ID Khach Hang:");
				this.idKH=sc.nextInt();
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("nhap sai dinh dang");
				sc.nextLine();
			}
			if(this.idKH>0) {
				break;
			}
		}
		KhachHang kh= QuanLy.timidKH(idKH);
		if(kh!=null) {
			if(kh.getLoaiKH().equals(0)) {
				this.hanmuc=1000000;	
			} else if(kh.getLoaiKH().equals(1)) {
				this.hanmuc=30000000;
			}
		}
		sc.nextLine();
		while(true) {
			System.out.println("So TK :");
			String soTKh=sc.nextLine();
			if(soTKh.length()!=6) {
				System.out.println("So TK phai gom 6 ky tu");
			} else {
				try {
					long l_stk=Long.parseLong(soTKh);
					setSoTK(soTKh);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("So TK phai gom 6 ky tu so");
				}
			}
			if(getSoTK()!=null) {
				break;
			}
		}
		while(true) {
				try {
					System.out.println("Loai TK( 1_tra truoc | 2_visa) : ");
					this.loaiTK=sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Nhap bang ky tu so 1 or 2");
					sc.nextLine();
				}
				if(this.loaiTK==1||this.loaiTK==2) {
					break;
				}
		}
		while(true) {
			try {
				System.out.println("Trang Thai( 1_disable | 2_active) : ");
				this.trangthai=sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Nhap bang ky tu so 1 or 2");
				sc.nextLine();
			}
			if(this.trangthai==1||this.trangthai==2) {
				break;
			}
		}
		sc.nextLine();
		do {
			System.out.println("Ngay Mo The(dd/MM/yyyy):");
			try {
				this.ngaytao = sdf.parse(sc.nextLine());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("nhap cho dung");
			}
		} while (this.ngaytao == null);
		while(true) {
			try {
				System.out.println("So du tai khoan: ");
				this.soDuTK=sc.nextInt();
				if(this.soDuTK<0) {
					System.out.println("So du TK phai >=0");
				}
			} catch (Exception e) {
				System.out.println("nhap sai dinh dang");
				sc.nextLine();
			}
			if(this.soDuTK>=0) {
				break;
			}
		}
		if(this.loaiTK==2) {
			this.hanmuc=this.soDuTK;
		}
	}
	@Override
	public String toString() {
		return "TaiKhoan [ Id TK : " + idTK 
				+ " | idKH=" + idKH 
				+ " | So TK=" + soTK 
				+ " | Loai TK=" + loaiTK 
				+ " | Trang Thai="+ trangthai
				+ " | Ngay Mo The : " + sdf.format(ngaytao) 
				+ " | $ : " + soDuTK 
				+ " | Hạn Mức : " + hanmuc 
				+ "]\n";
	}
	public static void main(String[] args) {
		TaiKhoan tk= new TaiKhoan();
		tk.nhap();
		System.out.println(tk);
	}
	
}
