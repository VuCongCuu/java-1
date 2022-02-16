package bvn1;

import java.util.Scanner;

public class TamGiac implements IContent,IShape {
	private float chieuCao;
	private float canhDay;
	private float canh1;
	private float canh2;
	
	
	

	public TamGiac() {
		super();
	}
	public TamGiac(float chieuCao, float canhDay, float canh1, float canh2) {
		super();
		this.chieuCao = chieuCao;
		this.canhDay = canhDay;
		this.canh1 = canh1;
		this.canh2 = canh2;
	}

	public float getChieuCao() {
		return chieuCao;
	}
	public void setChieuCao(float chieuCao) {
		this.chieuCao = chieuCao;
	}
	public float getCanhDay() {
		return canhDay;
	}
	public void setCanhDay(float canhDay) {
		this.canhDay = canhDay;
	}
	@Override
	public void dienTich() {
		// TODO Auto-generated method stub
		System.out.println("dien tich: " + ((this.canhDay*this.chieuCao)/2));
	}
	@Override
	public void chuVi() {
		// TODO Auto-generated method stub
		System.out.println("Chu vi:" +(this.canhDay+this.canh1+this.canh2));
	}
	public void NhapTTtamGiac() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap canh 1");
		this.canh1=sc.nextFloat();
		System.out.println("nhap canh 2");
		this.canh2=sc.nextFloat();
		System.out.println("nhap canh day");
		this.canhDay=sc.nextFloat();
		System.out.println("nhap canh chieu cao");
		this.chieuCao=sc.nextFloat();
		
	}

	@Override
	public void dacDiem() {
		// TODO Auto-generated method stub
		System.out.println("Co 3 canh");	
	}

}
