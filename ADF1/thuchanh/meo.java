package thuchanh;

import java.util.Scanner;

public class meo extends DongVat {
	private String tenChu;
	private String spa;
	//-------constructor----------
	public meo(String ten, int tuoi, String moTa,String tenChu, String spa) {
		super(tenChu, tuoi, moTa);
		this.tenChu = tenChu;
		this.spa = spa;
	}
	public meo() {
		super();
	}
	//---------set,get-----------
	public String getTenChu() {
		return tenChu;
	}
	public void setTenChu(String tenChu) {
		this.tenChu = tenChu;
	}
	public String getSpa() {
		return spa;
	}
	public void setSpa(String spa) {
		this.spa = spa;
	}
	//---------mo rong--------
	@Override
	public String tiengKeu() {
		// TODO Auto-generated method stub
		return "meo meo";
	}
	@Override
	public void nhapTT() {
		// TODO Auto-generated method stub
		super.nhapTT();
		Scanner sc= new Scanner(System.in);
		System.out.println("Tem chu meo: ");
		this.tenChu=sc.nextLine();
		System.out.println("Spa : ");
		this.spa=sc.nextLine();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return"Meo: " + super.toString();
	}	
}
