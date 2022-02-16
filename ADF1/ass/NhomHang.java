package ass;

import java.util.Scanner;

public abstract class NhomHang {
	private String maNH;
	private String tenNH;
	private float vat;

	// ------------constructor----------
	public NhomHang() {
		super();
	}

	public NhomHang(String maNH, String tenNH, float vat) {
		super();
		if (!QuanLy.checkMaNhomHang(maNH)) {
			if (maNH.length() != 4) {
				System.out.println("Nhom hang phai co 4 ky tu");
			} else if (maNH.contains(" ")) {
				System.out.println("Ma nhom khac hang khong duoc co khoang trang");
			} else {
				this.maNH = maNH;
			}
		} else {
			System.out.println("Nhom hang da ton tai!");
		}

		this.tenNH = tenNH;
		if (vat > 0 && vat < 1) {
			this.vat = vat;
		} else {
			System.out.println("VAT >0 va < 1");
		}

	}

	// -------set get-------------------
	public String getMaNH() {
		return maNH;
	}

	public void setMaNH(String maNH) {
		this.maNH = maNH;
	}

	public String getTenNH() {
		return tenNH;
	}

	public void setTenNH(String tenNH) {
		this.tenNH = tenNH;
	}

	public float getVat() {
		return vat;
	}

	public void setVat(float vat) {
		this.vat = vat;
	}

	// -----------Mo rong--------------
	public abstract void nhap(Scanner sc);

	public abstract String xuat();

}
