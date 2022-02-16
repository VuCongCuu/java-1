package ass2.Obj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NhapSelect1 {
	private Date ngaybatdau;
	private Date ngayketthuc;
	private String soTK;
	private SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	public NhapSelect1(Date ngaybatdau, Date ngayketthuc, String soTK) {
		super();
		this.ngaybatdau = ngaybatdau;
		this.ngayketthuc = ngayketthuc;
		this.soTK = soTK;
	}
	public NhapSelect1() {
		super();
	}
	public Date getNgaybatdau() {
		return ngaybatdau;
	}
	public void setNgaybatdau(Date ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}
	public Date getNgayketthuc() {
		return ngayketthuc;
	}
	public void setNgayketthuc(Date ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}
	public String getSoTK() {
		return soTK;
	}
	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}
	Scanner sc= new Scanner(System.in);
	public void nhap() {
		System.out.println("Nhap maKH:");
		this.soTK=sc.nextLine();
		do {
			System.out.println("Ngay bat dau (dd/MM/yyyy):");
			try {
				this.ngaybatdau = sdf.parse(sc.nextLine());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (this.ngaybatdau == null);
		do {
			System.out.println("Ngay ket thuc(dd/MM/yyyy):");
			try {
				this.ngayketthuc = sdf.parse(sc.nextLine());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (this.ngayketthuc == null);
	}
}
