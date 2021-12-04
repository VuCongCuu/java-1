package ass2.Obj;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KHTKGD {
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
	private int idGD;
	private int loaiTT;
	private int tienRutNap;
	private Date ngayGD= new Date();
	private String addressGD;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public KHTKGD() {
		super();
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
	public int getIdGD() {
		return idGD;
	}
	public void setIdGD(int idGD) {
		this.idGD = idGD;
	}
	public int getLoaiTT() {
		return loaiTT;
	}
	public void setLoaiTT(int loaiTT) {
		this.loaiTT = loaiTT;
	}
	public int getTienRutNap() {
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

	@Override
	public String toString() {
		return "Thong tin [idKH=" + idKH 
				+ " | maKH :" + maKH 
				+ " | TenKH :" + tenKH 
				+ " | CMT :" + cmt 
				+ " | SDT :" + sdt
				+ " | Email :" + email 
				+ " | Ngay Sinh :" + ngaySinh 
				+ " | Gioi Tinh :" + gioiTinh 
				+ " | Address :" + address
				+ "  \nidTK :" + idTK 
				+ " | So TK :" + soTK 
				+ " | Loai TK :" + loaiTK 
				+ " | Trang Thai : " + trangthai 
				+ " | Ngay Tao :" + ngaytao 
				+ " | So Du TK :" + soDuTK 
				+ " | Han Muc :" + hanmuc
				+ " | idGD :" + idGD 
				+ " | LoaiTT : " + loaiTT
				+ " \nTien GD :" + tienRutNap 
				+ " | Ngay GD :" + ngayGD 
				+ " | Address GD : " + addressGD 
				+ "]\n";
	}
	
}
