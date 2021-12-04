package ass2.Obj;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class KhachHang {
	private int idKH;
	private String maKH;
	private String tenKH;
	private String cmt;
	private String sdt;
	private String email;
	private Date ngaySinh;
	private int gioiTinh;
	private String address;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public int loaiKH;

	public KhachHang() {
		super();
	}
	public Integer getLoaiKH() {
		return loaiKH;
	}

	public void setLoaiKH(int loaiKH) {
		this.loaiKH = loaiKH;
	}

	public Integer getId() {
		return idKH;
	}

	public void setId(int id) {
		this.idKH = id;
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

	public Integer getGioiTinh() {
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

	Scanner sc = new Scanner(System.in);

	public void nhap() {
		System.out.println("Ma Khach Hang");
		this.maKH = sc.nextLine();
		System.out.println("Name");
		this.tenKH = sc.nextLine();
		while (true) {
			System.out.println("CMT : ");
			String cmnd = sc.nextLine();
			if (cmnd.length() != 9) {
				System.out.println("CMT phai co 9 ky tu");
			} else {
				try {
					long lcmt = Long.parseLong(cmnd);
					setCmt(cmnd);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("CMT phai co 9 ky tu so");
				}
			}
			if (getCmt() != null) {
				break;
			}
		}
		while (true) {
			System.out.println("SDT : ");
			String sdt = sc.nextLine();
			if (sdt.length() != 10) {
				System.out.println("SDT phai co 9 ky tu");
			} else if(!sdt.startsWith("0")) {
				System.out.println("SDT bat dau bang 0");
			} else {
				try {
					long lcdt = Long.parseLong(sdt);
					setSdt(sdt);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("CMT phai co 10 ky tu so");
				}
			}
			if (getSdt() != null) {
				break;
			}
		}
		System.out.println("Email:");
		this.email = sc.nextLine();
		do {
			System.out.println("Ngay phat hanh(dd/MM/yyyy):");
			try {
				this.ngaySinh = sdf.parse(sc.nextLine());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (this.ngaySinh == null);
		while(true) {
		try {
			System.out.println("GioiTinh(0:nu/1:nam/2:khac):");
			this.gioiTinh=sc.nextInt();
			if(getGioiTinh().equals(1)||getGioiTinh().equals(2)||getGioiTinh().equals(0)) {
				break;
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Nhap 1 or 2 or 0");
			sc.nextLine();
		}
		}
		sc.nextLine();
		System.out.println("Address : ");
		this.address=sc.nextLine();
		while(true) {
			try {
				System.out.println("Loai KH(0:Thuong/1:Vip):");
				this.loaiKH=sc.nextInt();
				if(getLoaiKH().equals(1)||getLoaiKH().equals(0)) {
					break;
				}
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Nhap 0 or 1");
				sc.nextLine();
			}
			}
	}
	
	@Override
	public String toString() {
		return "Khach Hang [ ID : " + idKH 
							+ " | MaKH :" + maKH
							+ " | TenKH :" + tenKH 
							+ " | CMT : " + cmt 
							+ " | SDT : " + sdt
							+ " | Email : " + email 
							+ " | NgaySinh : " + sdf.format(ngaySinh)
							+ " | GioiTinh : " + gioiTinh 
							+ " | AddRess : " + address
							+ " | Loai KH : " + loaiKH
							+ " ]\n";
				}
	
	public static void main(String[] args) {
		KhachHang kh= new KhachHang();
		kh.nhap();
		System.out.println(kh);
	}
}
