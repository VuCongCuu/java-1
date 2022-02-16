package ass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class QuanLy {
	private  Scanner sc = new Scanner(System.in);

	public static ArrayList<SanPham> listSanPham = new ArrayList<>();
	public static ArrayList<NhomHang> listNhomHang = new ArrayList<>();
	public ArrayList<DonHang> listDonHang = new ArrayList<>();

	public static int countSanPham;

	// -----------Check ma nhom hang-----------
	public static boolean checkMaNhomHang(String maNhomHang) {
		if (maNhomHang == null)
			return false;
		for (NhomHang nhomHang : listNhomHang) {
			if (nhomHang.getMaNH().equalsIgnoreCase(maNhomHang))
				return true;
		}
		return false;
	}

	// ---------------Tim ma san pham---------------
	public static SanPham timMaSanPham(String maSP) {
		if (maSP == null)
			return null;
		for (SanPham sanpham : listSanPham) {
			if (sanpham.getMaSanPham().equalsIgnoreCase(maSP)) {
				return sanpham;
			}
		}
		return null;
	}

	public static NhomHang timMaNhomHang(String manh) {
		if (manh == null)
			return null;
		for (NhomHang nhomhang : listNhomHang) {
			if (nhomhang.getMaNH().equalsIgnoreCase(manh))
				return nhomhang;
		}
		return null;
	}
	// -----------chose----------------
	public void choose_1() {
		while(true) {
			System.out.println("1: Them mot nhom hang moi");
			System.out.println("2. Hien thi danh sach nhom hang");
			System.out.println("3. Tim thong tin nhom hang theo ma nhom hang");
			System.out.println("4. Thoat");	
			System.out.println("Nhap lua cho (1-4)");
			try {
				int choose;
				choose = sc.nextInt();
				NhomHang nhomhang = new NhomHangDao();
				switch (choose) {
						case 1:
							System.out.println("-------- them 1 nhom hang moi-------- ");
							nhomhang.nhap(sc);
							listNhomHang.add(nhomhang);
							break;
						case 2:
							System.out.println("-------- Hien thi danh sach nhom hang-------- ");
							for (NhomHang nh : listNhomHang) {
								System.out.println(nh.xuat());
							}
							break;
						case 3:
							System.out.println("-------- Tim thong tin nhom hang theo ma nhom hang-------- ");
							sc.nextLine();
							System.out.println("Nhap ma nhom hang");
							nhomhang = timMaNhomHang(sc.nextLine());
							if (nhomhang != null) {
								for (NhomHang nh : listNhomHang) {
									if (nh.getMaNH().equalsIgnoreCase(nhomhang.getMaNH())) {
										System.out.println(nh.xuat());
										break;
									}
								}
							} else {
								System.out.println("nhom hang khong ton tai");
							}							
							break;
						case 4:
							break;
						default:
							System.out.println("P/s: Phai nhap tu 1-4");
							
						}
						if(choose==4) {
							break;
						}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Phai nhap 1 so");
				sc.nextLine();
			}		
		}
	}

// -----------------chose2---------------------------------
	public void choose_2() {
		while(true) {
			int choose;
			System.out.println("1. Them 1 san pham");
			System.out.println("2. Hien thi danh sach san pham");
			System.out.println("3. Tim nhom hang theo ma san pham");
			System.out.println("4. update san pham theo ma san pham");
			System.out.println("5. Thoat");
			System.out.println("Nhap lua chon: ");
			try {
				choose = sc.nextInt();
				SanPham sanPham = new SanPhamDao();
				switch (choose) {
						case 1:
							System.out.println("-------- Them 1 san pham---------");
							sanPham.nhap(sc);
							listSanPham.add(sanPham);
							break;
						case 2:
							System.out.println("-------- Hien thi danh sach san pham-------- ");
							for (SanPham sp : listSanPham) {
								System.out.println(sp.xuat());
							}
							break;
						case 3:
							System.out.println("--------. Tim nhom hang theo ma san pham--------");
							sc.nextLine();
							System.out.println("Nhap ma san pham");
							sanPham = timMaSanPham(sc.nextLine());
							if (sanPham != null) {
								for (NhomHang nh : listNhomHang) {
									if (nh.getMaNH().equals(sanPham.getMaNH())) {
										System.out.println(nh.xuat());
										break;
									}
								}
							} else {
								System.out.println("khong ton tai");
							}
							break;
						case 4:
							sc.nextLine();
							System.out.println("--------  update san pham theo ma san pham--------");
							System.out.println("Nhap ma san pham:");
							sanPham = timMaSanPham(sc.nextLine());
							int index = listSanPham.indexOf(sanPham);
							if(sanPham!=null) {
								System.out.println(sanPham.xuat());
								sanPham.nhap(sc);						
								listSanPham.set(index, sanPham);
								System.out.println("Cap nhat: "+sanPham.xuat());
								break;							
							} else {
								System.out.println("Khong tim  thay ma san pham");
							}
						default:
							System.out.println("P/s: Phai chon 1-5");						
						}
						if(choose==5) {
							break;
				}				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Phai nhap 1 so");
				sc.nextLine();
			}			
		}
	}
//------------------------choose3------------------------
	public void choose_3 () {
		while(true) {
			int choose;
			System.out.println("1. Tao 1 don hang");
			System.out.println("2. Hien thi danh sach don hang");
			System.out.println("3. Thoat");
			System.out.println("Nhap lua chon(1-3) :");
			try {
				choose=sc.nextInt();
				DonHang donHang= new DonHangDao();
				switch(choose) {
						case 1:
							System.out.println("-------- Tao 1 don hang--------");
							donHang.nhap(sc);
							listDonHang.add(donHang);
							break;
						case 2:
							System.out.println("--------Hien thi danh sach don hang--------");
							for(DonHang dh :listDonHang) {
								System.out.println(dh.xuat());
							}
							break;
						default:
							System.out.println("P/s: Phai chon 1-3");
							
						}
						if(choose==3) {
							break;
						}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Phai nhap 1 so");
				sc.nextLine();
			}
		}
	}
//-----------------------------chosse4--------------------
	public void choose_4() {
		while(true) {
			int choose ;
			System.out.println("1. So luong va tong tien ban duoc");
			System.out.println("2. Top 3 san pham bestSeller");
			System.out.println("3. Thoat");
			System.out.println("Nhap lua chon(1-3):");
			try {
				choose=sc.nextInt();
				switch(choose) {
						case 1:
							System.out.println("--------So luong va tong tien ban duoc--------");
							thongTinSale();
							break;
						case 2: 
							System.out.println("Xin loi co em khong biet lam a");
							break;	
						default:
							System.out.println("P/s : Phai chon 1-3");
						}
						if(choose==3) {
							break;
						}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Phai nhap 1 so");
				sc.nextLine();
			}
			
			
		}

	}
	//----------------Case4----------------------
	public void thongTinSale() {
		int count=0;
		double sum=0;
		for(DonHang dh :listDonHang) {
			for(SanPham sp:dh.getDsSanPham()) {
				count++;
				sum +=sp.getGiaBan();
			}
		}
		System.out.println("So luong san pham : "+ count);
		System.out.println("Tong doanh thu : "+ sum);
	}	
}
