package buoi5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SinhVien {
	private String name;
	private String email;
	private Date namSinh;
	private float toan;
	private float van;
	private float anh;
	private float tb;
	private LopHoc lophoc;
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public SinhVien() {
		this.lophoc = new LopHoc();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getToan() {
		return toan;
	}
	public void setToan(float toan) {
		this.toan = toan;
	}
	public float getVan() {
		return van;
	}
	public void setVan(float van) {
		this.van = van;
	}
	public float getAnh() {
		return anh;
	}
	public void setAnh(float anh) {
		this.anh = anh;
	}
	public LopHoc getLophoc() {
		return lophoc;
	}
	public void setLophoc(LopHoc lophoc) {
		this.lophoc = lophoc;
	}
	
	public float getTb() {
		return tb;
	}
	public void setTb(float tb) {
		this.tb = tb;
	}
	public void nhapttSinhVien() {
		System.out.println(" ---Thong Tin Sinh Vien---");
		Scanner sc= new Scanner(System.in);
		System.out.println("Ten Sinh Vien :");
		this.name=sc.nextLine();
		do {
			System.out.println("Ngay/thang/nam sinh :");
			try {
				this.namSinh=sdf.parse(sc.nextLine());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} while (this.namSinh==null);
		System.out.println("Email:");
		this.email= sc.nextLine();
		this.lophoc.nhapttlop();
		while(true) {
			System.out.println("Toan :");
			this.toan=sc.nextInt();
			if(this.toan>=0 &&this.toan<=10) {
				break;
			}
		}
		while(true) {
			System.out.println("Van :");
			this.van=sc.nextInt();
			if(this.van>=0 &&this.van<=10) {
				break;
			}
		}
		while(true) {
			System.out.println("Anh :");
			this.anh=sc.nextInt();
			if(this.anh>=0 &&this.anh<=10) {
				break;
			}
		}
		 tb= (toan+van+anh)/3;
	}
	
	public void yeu() {
		System.out.println("hoc luc yeu");
	}
	public void tb() {
		System.out.println("hoc luc trung binh");
	}
	public void kha() {
		System.out.println("hoc luc kha");
	}
	public void gioi() {
		System.out.println("hoc luc gioi");
	}
	@Override
	public String toString() {
		return "SinhVien [name=" + name 
				+ ", email=" + email 
				+ ", namSinh=" + sdf.format(this.namSinh) 
				+ ", toan=" + toan 
				+ ", van="+ van 
				+ ", anh=" + anh +
				", lophoc=" + lophoc.toString() + "]";
	}
	
}
