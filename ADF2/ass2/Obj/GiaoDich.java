package ass2.Obj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GiaoDich {
	private int idGD;
	private String soTK;
	private int loaiTT;
	private int tienRutNap;
	private Date ngayGD= new Date();
	private String addressGD;
	private SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	public GiaoDich() {
		super();
	}
	public GiaoDich(int idGD, String soTK, int loaiTT, int tienRutNap, Date ngayGD, String addressGD) {
		super();
		this.idGD = idGD;
		this.soTK = soTK;
		this.loaiTT = loaiTT;
		this.tienRutNap = tienRutNap;
		this.ngayGD = ngayGD;
		this.addressGD = addressGD;
	}
	public Integer getIdGD() {
		return idGD;
	}
	public void setIdGD(int idGD) {
		this.idGD = idGD;
	}
	public String getSoTK() {
		return soTK;
	}
	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}
	public Integer getLoaiTT() {
		return loaiTT;
	}
	public void setLoaiTT(int loaiTT) {
		this.loaiTT = loaiTT;
	}
	public Integer getTienRutNap() {
		return tienRutNap;
	}
	public void setTienRutNap(int tienRutNap) {
		this.tienRutNap = tienRutNap;
	}	
	public Date getNgayGD() {
		return ngayGD;
	}
	public void setNgayGD(Date ngayGD) {
		this.ngayGD = ngayGD;
	}
	public String getAddressGD() {
		return addressGD;
	}
	public void setAddressGD(String addressGD) {
		this.addressGD = addressGD;
	}
	Scanner sc= new Scanner(System.in);
	public void nhap() {
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
		TaiKhoan tk= QuanLy.timsoTK(soTK);
		while(true) {
			try {
				System.out.println("Loai TK( 1_nap | 2_rut) : ");
				this.loaiTT=sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Nhap bang ky tu so 1 or 2");
				sc.nextLine();
			}
			if(this.loaiTT==1||this.loaiTT==2) {
				break;
			}
	}
		while(true) {
			try {
				System.out.println("So tien: ");
				this.tienRutNap=sc.nextInt();
				if(this.tienRutNap<0) {
					System.out.println("So du TK phai >=0");
				}
			} catch (Exception e) {
				System.out.println("nhap sai dinh dang");
				sc.nextLine();
			}
			if(this.tienRutNap>=0) {
				break;
			}
		}
		sc.nextLine();
		System.out.println("Dia chi giao dich");
		this.addressGD=sc.nextLine();
	}
	@Override
	public String toString() {
		return "GiaoDich [idGD : " + idGD 
				+ " | soTK : " + soTK 
				+ " | loaiTT : " + loaiTT 
				+ " | $ GD :" + tienRutNap
				+ " | ngayGD : " + sdf.format(ngayGD) 
				+ " | AddRess GD : " + addressGD 
				+ "]";
	}
	public static void main(String[] args) {
		GiaoDich gd= new GiaoDich();
		gd.nhap();
		System.out.println(gd);
	}
	
	
}
