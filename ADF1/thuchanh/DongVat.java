package thuchanh;

import java.util.Scanner;

import javax.net.ssl.SSLContext;

public abstract class DongVat {
	private String ten;
	private int tuoi;
	private String moTa;
	//-----------constructor----
	public DongVat() {
		super();
	}
	public DongVat(String ten, int tuoi, String moTa) {
		super();
		this.ten = ten;
		this.tuoi = tuoi;
		this.moTa = moTa;
	}
	//------------------set,get-----------------
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	// ----------Mo rong-----------
	public void nhapTT() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Ten:");
		this.ten=sc.nextLine();
		System.out.println("Tuoi: ");
		this.tuoi=sc.nextInt();
		sc.nextLine();
		System.out.println("Mo ta:");
		this.moTa=sc.nextLine();
	}
	
	@Override
	public String toString() {
		return "DongVat [ten=" + ten + ", tuoi=" + tuoi + ", moTa=" + moTa +", Tieng Keu"+this.tiengKeu()+ "]";
	}
	public abstract String tiengKeu();
	
}
