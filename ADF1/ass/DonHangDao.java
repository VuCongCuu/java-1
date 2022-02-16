package ass;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DonHangDao extends DonHang {
//-------------------contructor------------------------	
	public DonHangDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonHangDao(String tenKhachHang, ArrayList<SanPham> dsSanPham, String ngayMuaHang) {
		super(tenKhachHang, dsSanPham, ngayMuaHang);
		// TODO Auto-generated constructor stub
	}
//---------------------Nhap----------------------- 	
	@Override
	public void nhap(Scanner sc) {
		sc.nextLine();
		System.out.println("Ten khach hang:");
		setTenKhachHang(sc.nextLine());
		Date ngayMH;
		while(true) {
			System.out.println("Nhap ngay mua hang(dd/MM/yyyy):");
				try {
					ngayMH=sdf.parse(sc.nextLine());
					setNgayMuaHang(sdf.format(ngayMH));	
					break;
				} catch (Exception e) {
				System.out.println("Nhap ngay khong hop le");
				}
		}
		System.out.println("Nhap don hang");
		SanPham sanPham= new SanPhamDao();
		String check;
		while(true) {
			System.out.println("nhap ma san pham muon order:");
			sanPham=QuanLy.timMaSanPham(sc.nextLine());
			if(sanPham!=null) {
				setDsSanPham(sanPham);
				System.out.println("ban da them thamh cong san pham");
			} else {
				System.out.println("Khong tim thay ma san pham");
			}
			sc.nextLine();
			System.out.println("ban co muon tiep tuc them san pham khong?(y/n):");
			check=sc.nextLine();
			if("n".equalsIgnoreCase(check)) {
				break;
			}			
		}	
	}
//-----------------xuat-----------------------------
	@Override
	public String xuat() {
		// TODO Auto-generated method stub
		return "Don hang :[" + "Ten khach hang: "+getTenKhachHang() 
							+" | Ngay mua hang" +getNgayMuaHang() 
							+" | Danh sach san pham"+ listSanPhamDonHang()+"]";
	}
}
