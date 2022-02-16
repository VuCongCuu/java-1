package buoi2.danhsach;

public class SanPhamMua implements Comparable<SanPhamMua>  {
	private String maSP;
	private int soLuong;
	public SanPhamMua() {
		super();
	}
	public SanPhamMua(String maSP, int soLuong) {
		super();
		this.maSP = maSP;
		this.soLuong = soLuong;
	}
	
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public Integer getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "SanPhamMua [maSP=" + maSP + ", soLuong=" + soLuong + "]";
	}
	@Override
	public boolean equals(Object argO) {
		if(argO==null)
			return false;
		if(!(argO instanceof SanPhamMua))
			return false;
		if(this.maSP==null)
			return false;
		SanPhamMua other= (SanPhamMua)argO;
		return this.maSP.equals(other.getMaSP());
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.maSP.hashCode();
	}
	@Override
	public int compareTo(SanPhamMua o) {
		// TODO Auto-generated method stub
		return o.getSoLuong().compareTo(this.getSoLuong());
	}
	
}
