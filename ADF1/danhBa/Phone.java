package danhBa;

import java.util.Scanner;

public class Phone implements IThaoTac{
	private String name;
	private String phoneNumber;
	

	public Phone() {
		super();
	}

	public Phone(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public void nhap() {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap ten:");
		this.name=sc.nextLine();
		while(true) {
			System.out.println("nhap so dien thoai:");
			String sdt=sc.nextLine();
			if(sdt.length()!=10) {
				System.out.println("so dien thoai gom 10 ky tu");
			} else if(!sdt.startsWith("0")) {
				System.out.println("sdt phai bat dau tu 0");
			} else {
				try {
				long l_sdt=Long.parseLong(sdt);
				this.phoneNumber=sdt;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("phone number phai co 10 ky ty so");
				}
			}
					
			if(phoneNumber != null) {
				break;
			}
		}
		
	}

	@Override
	public void xuat() {
		System.out.println("name: "+this.name+" " +"sdt: "+this.phoneNumber);
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		Phone i =new Phone();
		i.nhap();
		i.xuat();
	}

}
