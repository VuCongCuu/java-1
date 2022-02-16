package person;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Person implements Serializable {
	private String name;
	private Date age;
	private String address;
	private SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	public Person(String name, Date age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Person() {
		super();
	}
	Scanner sc= new Scanner(System.in);
	public void nhap() {
		System.out.println("Name:");
		this.name=sc.nextLine();
		
		while(true) {
			System.out.println("Ngay sinh:");
			try {
				this.age=sdf.parse(sc.nextLine());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.age!=null) {
				break;
			}
		}
		System.out.println("Dia chi:");
		this.address=sc.nextLine();
		
		
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + sdf.format(age) + ", address=" + address + "]";
	}
	public String ghifile() {
		return  name + "," + sdf.format(age) + "," + address;
	}
	
}
