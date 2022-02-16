package buoi7;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Nguoi implements Comparable<Nguoi> {
	//fields
	protected String hoTen;
	protected String diaChi;
	protected String sdt;
	protected String email ;
	protected Date ngaySinh;
	protected char gioiTinh;
	final SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
	public Nguoi() {
		super();
	}
	public Nguoi(String hoTen, String diaChi, String sdt, String email, Date ngaySinh, char gioiTinh) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Character getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(char gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public void nhapTT() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhap ho ten:");
		this.hoTen=sc.nextLine();
		System.out.println("Ngaysinh");
		try {
			this.ngaySinh=sdf.parse(sc.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Gioi tinh");
		this.gioiTinh=(char)sc.nextByte();
		sc.nextLine();
		System.out.println("Sdt");
		this.sdt=sc.nextLine();
		System.out.println("Gmail : ");
		this.email=sc.nextLine();
	}
	@Override
	public String toString() {
		return "Nguoi [hoTen=" + hoTen + ", diaChi=" + diaChi + ", sdt=" + sdt + ", email=" + email + ", ngaySinh="
				+ (ngaySinh!=null?sdf.format(ngaySinh):"") + ", gioiTinh=" + gioiTinh+  "]";
	}
	@Override
	public int compareTo(Nguoi o) {
		// TODO Auto-generated method stub
		if(o==null) {
			return -1;
		}
		//tang dan p1>p2
		int soSanhNgaySinh= this.getNgaySinh().compareTo(o.getNgaySinh());
		if(soSanhNgaySinh==0) {
			Character ch=o.getGioiTinh();
			return ch.compareTo(this.getGioiTinh());
			
		}
		return soSanhNgaySinh;
	}

	
	//method
	
}
