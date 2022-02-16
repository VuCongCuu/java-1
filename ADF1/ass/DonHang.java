package ass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class DonHang {
	private String tenKhachHang;
	private ArrayList<SanPham> dsSanPham= new ArrayList<SanPham>();
	private String ngayMuaHang;
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	//---------contructor--------------
	public DonHang() {
		super();
	}
	public DonHang(String tenKhachHang, ArrayList<SanPham> dsSanPham, String ngayMuaHang) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.dsSanPham = dsSanPham;
		setNgayMuaHang(ngayMuaHang);
	}
//-----------------set,get----------------------------------------	
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public ArrayList<SanPham> getDsSanPham() {
		return dsSanPham;
	}	
	public void setDsSanPham(SanPham sanpham) {
		this.dsSanPham.add(sanpham);
	}
	public String getNgayMuaHang() {
		return ngayMuaHang;
	}
	public void setNgayMuaHang(String ngayMuaHang) {
		try {
			this.ngayMuaHang = sdf.format(sdf.parse(ngayMuaHang));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("nhap sai dinh dang");
		}
	}
//----------thong tin san pham theo don hang----------------
	public String listSanPhamDonHang() {
		String spString="";
			for(SanPham sp: this.dsSanPham) {
				spString += sp.xuat();
			}
		return spString;
	}
//-------------------- Mo rong-------------
	public abstract void nhap(Scanner sc);
	public abstract String xuat();
}
