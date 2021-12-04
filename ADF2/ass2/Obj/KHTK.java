package ass2.Obj;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KHTK {
	private int idKH;
	private String maKH;
	private String tenKH;
	private String cmt;
	private String sdt;
	private String email;
	private Date ngaySinh;
	private int gioiTinh;
	private String address;
	private  int loaiKH;
	private int idTK;
	private String soTK;
	private int loaiTK;
	private int trangthai;
	private Date ngaytao;
	private int soDuTK;
	private int hanmuc;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public KHTK() {
		super();
	}
	public KHTK(int idKH, String maKH, String tenKH, String cmt, String sdt, String email, Date ngaySinh, int gioiTinh,
			String address, int idTK, int idKH2, String soTK, int loaiTK, int trangthai, Date ngaytao, int soDuTK,
			int hanmuc) {
		super();
		this.idKH = idKH;
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.cmt = cmt;
		this.sdt = sdt;
		this.email = email;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.address = address;
		this.idTK = idTK;
		this.soTK = soTK;
		this.loaiTK = loaiTK;
		this.trangthai = trangthai;
		this.ngaytao = ngaytao;
		this.soDuTK = soDuTK;
		this.hanmuc = hanmuc;
	}
	public int getIdKH() {
		return idKH;
	}
	public void setIdKH(int idKH) {
		this.idKH = idKH;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
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
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public  int getLoaiKH() {
		return loaiKH;
	}
	
	public void setLoaiKH(int loaiKH) {
		this.loaiKH = loaiKH;
	}
	public int getIdTK() {
		return idTK;
	}
	public void setIdTK(int idTK) {
		this.idTK = idTK;
	}
	public String getSoTK() {
		return soTK;
	}
	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}
	public int getLoaiTK() {
		return loaiTK;
	}
	public void setLoaiTK(int loaiTK) {
		this.loaiTK = loaiTK;
	}
	public int getTrangthai() {
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
	@Override
	public String toString() {
		return "Thong tin Khach Hang \n [ ID : " + idKH 
				+ " | MaKH :" + maKH
				+ " | TenKH :" + tenKH 
				+ " | CMT : " + cmt 
				+ " | SDT : " + sdt
				+ " | Email : " + email 
				+ " | NgaySinh : " + sdf.format(ngaySinh)
				+ " | GioiTinh : " + gioiTinh 
				+ " \n AddRess : " + address 
				+ " | Loai KH : " + loaiKH
				+ " | Id TK : " + idTK 
				+ " | So TK=" + soTK 
				+ " | Loai TK=" + loaiTK 
				+ " | Trang Thai="+ trangthai
				+ " | Ngay Mo The : " + sdf.format(ngaytao) 
				+ " | $ : " + soDuTK 
				+ " | Hạn Mức : " + hanmuc 
				+ "]\n";
			
	}
	
}
