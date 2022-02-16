package ass;

import java.util.ArrayList;
import java.util.Scanner;

public class SanPhamDao extends SanPham {
	
//---------------------contructor-----------------------------
	public SanPhamDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPhamDao(String maNH, String maVach, String tenSanPham, String moTa, float giaNhap, float giaBan) {
		super(maNH, maVach, tenSanPham, moTa, giaNhap, giaBan);
		// TODO Auto-generated constructor stub
	}
//------------------Nhap-----------------------------	
	@Override
	public void nhap(Scanner sc) {
		// TODO Auto-generated method stub
		String man = "";
		while (true) {
			sc.nextLine();
			System.out.println("Nhap ma nhom hang");
			man = sc.nextLine();
			if (QuanLy.checkMaNhomHang(man)) {
				if (man.length() != 4) {
					System.out.println("Ma nhom hang phai 4 ky tu");
				} else if (man.contains(" ")) {
					System.out.println("Ma khach hang khong co khoang trang");
				} else {
					setMaNH(man);
					break;
				}
			} else {
				System.out.println("Ma nhom hang khong ton tai");
			}
		}
		setMaSanPham();
		System.out.println("Nhap ma vach:");
		setMaVach(sc.nextLine());
		System.out.println("Nhap ten san pham:");
		setTenSanPham(sc.nextLine());
		System.out.println("Nhap gia nhap:");
		while(true) {
			try {
				float gn=sc.nextFloat();
				if(gn>0) {
					setGiaNhap(gn);
					break;
				} else {
					System.out.println("Gia nhap phai lon hon 0");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("nhap sai dinh dang");
				sc.nextLine();
			}			
		}
		System.out.println("Nhap gia ban:");
		while(true) {
			try {
				float gb=sc.nextFloat();
				if(gb>0) {
					setGiaBan(gb);
					break;
				} else {
					System.out.println("Gia ban phai lon hon 0");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("nhap sai dinh dang");
				sc.nextLine();
			}
			
		}
		sc.nextLine();
		System.out.println("Nhap mo ta:");
		setMoTa(sc.nextLine());

	}
//-----------------------------xuat----------------------------
	@Override
	public String xuat() {
		// TODO Auto-generated method stub
		return "San pham [ "+"Tem san pham: "+ getTenSanPham()
							+" | Ma nhom hang: " + getMaNH()
							+" | Ma san pham: " + getMaSanPham() 
							+" | Ma Vach: " +getMaVach()
							+" | Gia nhap: "+ getGiaNhap()
							+" | Gia ban: "+ getGiaBan()
							+" | Mo ta: "+getMoTa()+" ]";
	}
	
	
}
