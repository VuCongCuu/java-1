package ass;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class SanPham {
	private String maNH;
	private String maSanPham;
	private String maVach;
	private String tenSanPham;
	private String moTa;
	private float giaNhap;
	private float giaBan;
	//-----------------------contructor-----------------------------
	public SanPham() {
		super();
	}
	public SanPham(String maNH, String maVach, String tenSanPham, String moTa, float giaNhap, float giaBan) {
			super();
			if(QuanLy.checkMaNhomHang(maNH)) {
				setMaNH(maNH);
			} else {
				System.out.println("Ma nhom hang khong ton tai");
			}
			this.maVach = maVach;
			this.tenSanPham = tenSanPham;
			this.moTa = moTa;
			if(giaNhap>0) {
				this.giaNhap = giaNhap;			
			} else {
				System.out.println("gia nhap >0");
			}
			if(giaBan>0) {
				this.giaBan = giaBan;			
			} else {
				System.out.println("gia ban phai >0");
				}
	}
	//--------------------set,get-------------------------------
	public String getMaNH() {
		return maNH;
	}
	public void setMaNH(String maNH) {
		this.maNH = maNH.toUpperCase();
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham() {
		this.maSanPham = getMaNH()+ String.format("%04d", ++QuanLy.countSanPham);
	}

	public String getMaVach() {
		return maVach;
	}
	public void setMaVach(String maVach) {
		this.maVach = maVach;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public float getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(float giaNhap) {
		this.giaNhap = giaNhap;
	}

	public float getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
//--------------Mo rong------------------------
	public abstract void nhap(Scanner sc);	
	public abstract String xuat();
}
