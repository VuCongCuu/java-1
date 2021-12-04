package ass2.dao;

import java.util.List;
import ass2.Obj.GiaoDich;
import ass2.Obj.KHTK;
import ass2.Obj.KHTKGD;
import ass2.Obj.KhachHang;
import ass2.Obj.NapTien;
import ass2.Obj.NhapSelect;
import ass2.Obj.RutTien;
import ass2.Obj.TaiKhoan;
import ass2.util.ResponseObject;

public interface BankDao {
			//insert Khach hang
			public ResponseObject insertCustomer( KhachHang customer);
			//update khach hang theo maKH
			public ResponseObject upDateCutomer(KhachHang customer,String maKH);
			//delete khach hang theo maKH
			public ResponseObject deleteCutomer(String maKH);
			//getList
			public List<KhachHang> getList();
			//insert tai khoan
			public ResponseObject insertTK( TaiKhoan taikhoan);			
			//getList Tai Khoan
			public List<TaiKhoan> getListTK();
			//getList Tai Khoan theo so TK
			public List<TaiKhoan> getListTaiKhoan(String sTK);
			//list thoong tin khach hang
			public List<KHTK> ttKH();
			//list thoong tin khach hang theo maKH
			public List<KHTK> ttKhachHang(String maKH);
			
			public List<KHTKGD> thongtin(String maKH);
			//list thoong tin Giao dich
			public List<GiaoDich> getListGD(String soTK);
			//insert tai khoan
			public ResponseObject insertGD( GiaoDich giaodich);		
			public ResponseObject insertGDRut( RutTien rut);
			public ResponseObject insertGDNap( NapTien nap);
			//update thai khoan theo sotk
			public ResponseObject upDateTK(int tiennap,String soTK);
			public ResponseObject upDateTKvisa(int tienrut,String soTK);
			
			List<GiaoDich> getListGDDate(NhapSelect nhap);
			
}
