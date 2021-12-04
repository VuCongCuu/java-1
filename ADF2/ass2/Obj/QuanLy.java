package ass2.Obj;

import java.util.List;

import ass2.dao.BankDao;
import ass2.dao.Impl.BankDaoImpl;

public class QuanLy {
	private static BankDao bank= new BankDaoImpl();
	private static List<KhachHang> dsKhachHang=bank.getList();
	private static List<TaiKhoan> dsTaiKhoan= bank.getListTK();
	public static KhachHang setHanMucKHVip() {
		KhachHang a = new KhachHang();
		for(KhachHang khachhang : dsKhachHang) {
				if(khachhang.getLoaiKH().equals(1)) {
					a=khachhang;
				}
			}
		 return a;
	}
	public static KhachHang timidKH(int id) {
			if(id<0) {
				return null;
			}
			for(KhachHang k :dsKhachHang) {
				if(k.getId().equals(id)) {
					return k;
				}
			}
		return null;
	}
	public static TaiKhoan timsoTK(String soTK) {
		if(soTK==null) {
			return null;
		}
		for(TaiKhoan tk :dsTaiKhoan) {
			if(tk.getSoTK().equals(soTK)) {
				return tk;
			}
		}
		return null;
	}

}
