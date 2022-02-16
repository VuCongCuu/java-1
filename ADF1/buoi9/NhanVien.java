package buoi9;

import java.util.Date;
import java.util.Scanner;

import buoi7.Nguoi;

public class NhanVien extends Nguoi implements IWorker, IContent {
	private String maNV;
	private String phongBan;
	private int type;

	public NhanVien() {
		super();
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public NhanVien(String hoTen, String diaChi, String sdt, String email, Date ngaySinh, char gioiTinh, String maNV,
			String phongBan) {
		super(hoTen, diaChi, sdt, email, ngaySinh, gioiTinh);
		this.maNV = maNV;
		this.phongBan = phongBan;
		
	}

	@Override
	public void nhapTT() {
		// TODO Auto-generated method stub
		super.nhapTT();
		Scanner sc = new Scanner(System.in);
		System.out.println("Ma nv:");
		this.maNV = sc.nextLine();
		System.out.println("Phong Ban:");
		this.phongBan = sc.nextLine();
		System.out.println("vi tri");
		do {
			this.type = sc.nextInt();
		} while (this.type != 1 || this.type != 2 || this.type != 3);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+", ma nhan vien"+this.maNV+", Phong ban " +this.phongBan + "vitri"
				+ (this.type == 1 ? "Le Tan" : (this.type == 2 ? "Nv PhongBan" : (this.type == 3 ? "Bao Ve" : "Khac")));
	}

	@Override
	public void doWork() {
		// TODO Auto-generated method stub
		if (this.type == 1) {
			System.out.println("le tan lam viec tu 8h sang den 17h chieu");
		} else if (this.type == 2) {
			System.out.println("Nhan vien phai bat dau lam viec tu 8h sang>17h chieu");
		} else if (this.type == 3) {
			System.out.println("Nhan vien bao ve lam theo ca");
		} else {
			System.out.println("khac");
		}

	}

	@Override
	public void dongPhuc() {
		// TODO Auto-generated method stub
		switch(this.type) {
		case 1:
			if(this.gioiTinh=='1') {
				System.out.println("le tan nam mac ao vest den");
			} else if(this.gioiTinh=='0') {
				System.out.println("Nhan vien nu mac ao dai");
			} else {
				System.out.println("khac");
			}
		case 2:
			System.out.println("nhan vien phong ban thi an mac lich su");
			break;
		case 3:
			System.out.println("bao ve phai mac do bao ho lao dong");
			break;
		default:
			System.out.println("khac");
			break;
		}
			
	}

}
