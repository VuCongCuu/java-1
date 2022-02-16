package thuchanh.baisach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bao1 extends Doccument1 {
	private Date ngayPhatHanh;
	private SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	//-------------contructor---------	
	public bao1(String maTaiLieu, String tenTaiLieu, String tenNSB, int soBanPhatHanh, String ngayPhatHanh) {
		super(maTaiLieu, tenTaiLieu, tenNSB, soBanPhatHanh);
		try {
			this.ngayPhatHanh = sdf.parse(ngayPhatHanh);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			this.ngayPhatHanh= new Date();
		}
	}
	public bao1() {
		super();
	}


	public Date getNgayPhatHanh() {
		return ngayPhatHanh;
	}


	public void setNgayPhatHanh(String ngayPhatHanh) {
		try {
			this.ngayPhatHanh = sdf.parse(getMaTaiLieu());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			this.ngayPhatHanh= new Date();
		}
	}
	


	@Override
	public void nhapTT() {
		// TODO Auto-generated method stub
		super.nhapTT();
		this.ngayPhatHanh=checkngay("nhap ngay");
	}
	


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Bao:" +super.toString()+ "Ngau phat hanh" +(sdf.format(ngayPhatHanh));
	}
	@Override
	public int gia() {
		// TODO Auto-generated method stub
		return 100000;
	}
	
}
