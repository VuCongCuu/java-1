package ass;

import java.util.Scanner;

public class NhomHangDao extends NhomHang {
//---------------contructor------------------------	
	public NhomHangDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhomHangDao(String maNH, String tenNH, float vat) {
		super(maNH, tenNH, vat);
		// TODO Auto-generated constructor stub
	}
//--------------------nhap-----------------------
	@Override
	public void nhap(Scanner sc) {
		String manh="";
		while(true) {
			sc.nextLine();
			System.out.println("Ma nhom hang:");
			manh= sc.nextLine();
			if(!QuanLy.checkMaNhomHang(manh)) {
				if(manh.length()!=4) {
					System.out.println("Ma nhom hang phai co 4 ky tu");
				} else if(manh.contains(" ")) {
					System.out.println("Ma nhom hang khong duoc co khoang trang");
				} else {
					setMaNH(manh);
					break;
				}
			} else {
				System.out.println("Ma nhom hang da ton tai");
			}
			
		}
		System.out.println("Nhap ten nhom hang");
		setTenNH(sc.nextLine());
		System.out.println("Nhap VAT(0-1):");
		while(true) {
			try {
				float v=sc.nextFloat();
				if(v>0&&v<1) {
					setVat(v);
					break;
				} else {
					System.out.println("P/s: VAT phai >0 va <1");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("nhap sai dinh dang");
				sc.nextLine();
			}
			
		}
		// TODO Auto-generated method stub
	}
//--------------------------xuat--------------------------------
	@Override
	public String xuat() {
		// TODO Auto-generated method stub
		return "Nhom hang: [" + " Ma nhom hang: "+ getMaNH()
							+ " | Ten nhom hang: "+ getTenNH()
						    + " | VAT: " + getVat() +" ]";
	}

}
