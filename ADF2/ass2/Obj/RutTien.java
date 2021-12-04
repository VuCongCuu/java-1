package ass2.Obj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ass2.dao.BankDao;
import ass2.dao.Impl.BankDaoImpl;
import ass2.util.ResponseObject;

public class RutTien {
	private int tienrut;
	private Date ngayGD= new Date();
	private String addressGD;
	private String stk;
	private SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

	public RutTien() {
		super();
	}

	public String getStk() {
		return stk;
	}

	public void setStk(String stk) {
		this.stk = stk;
	}

	public int getTienrut() {
		return tienrut;
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

	public void setTienrut(int tienrut) {
		this.tienrut = tienrut;
	}
	Scanner sc= new Scanner(System.in);
	public void nhaprut() {
		System.out.println("Dia chi rut tien :");
		this.addressGD=sc.nextLine();
		System.out.println("Nhap so tai khoan");
		this.stk= sc.nextLine();
		sc.nextLine();
		TaiKhoan tkh= QuanLy.timsoTK(stk);
		if(tkh!=null) {
			BankDao ba= new BankDaoImpl();
			if(tkh.getLoaiTK().equals(2)) {
				try {
					System.out.println("so tien rut");
					int rut= sc.nextInt();
					if(rut<=tkh.getSoDuTK()&& rut <= tkh.getHanmuc()) {
						int b=tkh.getSoDuTK()-rut;					
						ResponseObject rs= ba.upDateTKvisa(b, stk);
						if(rs.getResCode()==1) {
							System.out.println("Rut thanh cong");
						} else {
							System.out.println("Rut khong thanh cong");
						}
						this.tienrut=rut;
					} else if(rut >tkh.getSoDuTK()) {
						System.out.println("So du khong du");
					} else if(rut>tkh.getHanmuc()) {
						System.out.println("Ban chi duoc rut toi da " +tkh.getHanmuc() );
					}
					
				} catch (Exception e) {
					System.out.println("Nhap ky tu so");
					sc.nextLine();
				}
			} else {
				try {
					System.out.println("so tien rut");
					int rut= sc.nextInt();
					if(rut<=tkh.getSoDuTK()&& rut <= tkh.getHanmuc()) {
						int b=tkh.getSoDuTK()-rut;					
						ResponseObject rs= ba.upDateTK(b, stk);
						if(rs.getResCode()==1) {
							System.out.println("Rut thanh cong");
						} else {
							System.out.println("Rut khong thanh cong");
						}
						this.tienrut=rut;
					} else if(rut >tkh.getSoDuTK()) {
						System.out.println("So du khong du");
					} else if(rut>tkh.getHanmuc()) {
						System.out.println("Ban chi duoc rut toi da " +tkh.getHanmuc() );
					}
					
				} catch (Exception e) {
					System.out.println("Nhap ky tu so");
					sc.nextLine();
				}
			}			 
		} else {
			System.out.println("So tai khoan khong dung");
		}
	}

	@Override
	public String toString() {
		return "[ So rien rut :" + tienrut 
				+ " | So TK : " + stk
				+ " | Ngay GD : " + sdf.format(ngayGD)
				+ " | Address : " + addressGD
				+ "]\n";
	}
	public static void main(String[] args) {
		RutTien r= new RutTien();
		r.nhaprut();
		System.out.println(r);
	}
}
