package buoi2.bvn3;

import java.util.Scanner;
/*3.	Tạo đối tượng sinh viên có các thuộc tính mã (int, không trùng nhau), tên, ngày sinh, địa chỉ, giới tính, mã ngành học (String); Tạo danh sách Sinh viên
-	Thêm sinh viên vào danh sách Sinh viên.
-	Sắp xếp danh sách Sinh viên theo thứ tự tăng dần tên và mã ngành học
-	Hiển thị tên sinh viên không trùng nhau -> Sử dụng Set
-	Hiển thị các sinh viên tìm kiếm theo tên hoặc ngành học 
-	Xóa sinh viên khi nhập vào tên và mã ngành học
-	Hiển thị số lượng sinh viên theo từng độ tuổi và thông tin sắp xếp theo độ tuổi.

+ VD:	
---------<18---------: 2
Sv 1
Sv 3
--------- >=18 && <=22 ---------: 4
Sv 2
Sv 4
Sv 5
Sv 6
--------- > 22---------: 1
Sv 7
*/


public class Student {
	private String maSV;
	private String name;
	private String addRess;
	private int age;
	
	public Student() {
		super();
	}	
	public Student(String maSV, String name, String addRess, int age) {
		super();
		this.maSV = maSV;
		this.name = name;
		this.addRess = addRess;
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddRess() {
		return addRess;
	}
	public void setAddRess(String addRess) {
		this.addRess = addRess;
	}
	Scanner sc= new Scanner(System.in);
	public void nhapTT() {
		System.out.println("Ma Sinh Vien: ");
		maSV= sc.nextLine();
		System.out.println("Ten Sinh Vien: ");
		name= sc.nextLine();
		System.out.println("Dia chi Sinh Vien: ");
		addRess= sc.nextLine();
		System.out.println("Tuoi Sinh Vien: ");
		age= sc.nextInt();		
	}
	@Override
	public String toString() {
		return "Student [ maSV=" + maSV + " | name=" + name + " | addRess=" + addRess + " | age=" + age + " ]";
	}

	
	
}
