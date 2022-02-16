package buoi9.designPattern.obj;
// dinh nghĩa đối tượng

import java.util.Scanner;

public class Customer {
	Scanner sc= new Scanner(System.in);
	private int id;
	private String name;
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}	
	public Customer(String name) {
		super();
		this.name = name;
	}

	public Customer() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void nhap() {
//		System.out.println("ID : ");
//		this.id=sc.nextInt();
//		sc.nextLine();
		System.out.println("Name : ");
		this.name=sc.nextLine();
	}
	@Override
	public String toString() {
		return "ID : " + id + " | Name : " + name ;
	}
	
}
