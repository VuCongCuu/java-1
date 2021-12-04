package ass2.Obj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ass2.dao.BankDao;
import ass2.dao.Impl.BankDaoImpl;
import ass2.util.ResponseObject;

public class NapTien {
	private int tiennap;
	private String soTK;
	private Date ngayGD= new Date();
	private String addressGD;
	private SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	
	public String getSoTK() {
		return soTK;
	}

	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}

	public NapTien() {
		super();
	}

	public int getTiennap() {
		return tiennap;
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

	public void setTiennap(int tiennap) {
		this.tiennap = tiennap;
	}
	Scanner sc= new Scanner(System.in);
	public void nhap(){
		System.out.println("Dia chi nap tien :");
		this.addressGD=sc.nextLine();
		System.out.println("Nhap so tai khoan nap");
		this.soTK= sc.nextLine();
		sc.nextLine();
		TaiKhoan tk= QuanLy.timsoTK(soTK);
		if(tk!=null) {
			if(tk.getLoaiTK().equals(1)) {
				try {
					System.out.println("So tien nap :");
					this.tiennap=sc.nextInt();	
					int a= this.tiennap+ tk.getSoDuTK();
					BankDao b= new BankDaoImpl();
					ResponseObject rs= b.upDateTK(a, soTK);
					if(rs.getResCode()==1) {
						System.out.println("Nap thanh cong");
					} else {
						System.out.println("Nap khong thanh cong");
					}				
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("P/s:Phai nhap ky tu so");
					sc.nextLine();
				}
					
			} else {
				System.out.println("Tai khoan cua ban la visa khong nap duoc");
				
			}
		} else {
			System.out.println("Khong nap duoc");
		}
	}

	@Override
	public String toString() {
		return " [ So tien nap :" + tiennap 
				+ " | So TK : " + soTK
				+ " | Ngay GD : " +sdf.format(ngayGD)
				+" | AddRess : "  + addressGD
				+" ]\n";
	}
	public static void main(String[] args) {
		NapTien nap= new NapTien();
		nap.nhap();
		System.out.println(nap);
	}
}
