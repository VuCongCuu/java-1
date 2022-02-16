package thuchanh;

import java.util.Scanner;

public class Cho extends DongVat {
	private String chuNha;
	private String giongCho;
	//---------constructor---------------
	public Cho() {
		super();
	}
	public Cho(String ten, int tuoi, String moTa,String chuNha, String giongcho) {
		super(ten, tuoi, moTa);
		this.chuNha = chuNha;
		this.giongCho = giongcho;
	}
	//-----------------set get---------
	public String getChuNha() {
		return chuNha;
	}
	public void setChuNha(String chuNha) {
		this.chuNha = chuNha;
	}
	public String getTraiMo() {
		return giongCho;
	}
	public void setTraiMo(String traiMo) {
		this.giongCho = traiMo;
	}
//-----------------Mo rong-----------
	
	
	@Override
	public String tiengKeu() {
		// TODO Auto-generated method stub
		return "Go Go";
	}
	@Override
	public void nhapTT() {
		// TODO Auto-generated method stub
		super.nhapTT();
		Scanner sc= new Scanner(System.in);
		System.out.println("Tem chu cho: ");
		this.chuNha=sc.nextLine();
		System.out.println("Giong cho: ");
		this.giongCho=sc.nextLine();
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cho: "+ super.toString()+", Ten chu cho: "+this.chuNha+", Giong cho: "+this.giongCho;
	}
}
