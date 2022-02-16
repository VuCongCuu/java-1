package objectoutoutstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
	public static void main(String[] args) {
		List<HocSinh> DanhSachHocSinh= new ArrayList<HocSinh>();
		HocSinh student= new HocSinh("CongCuu",25);
		HocSinh studentq= new HocSinh("VuCongCuu",25);
		HocSinh studentqq= new HocSinh("VuCongCuu25",25);
	
		DanhSachHocSinh.add(student);
		DanhSachHocSinh.add(studentq);
		DanhSachHocSinh.add(studentqq);
		//Ghifile
		try {
			FileOutputStream fos= new FileOutputStream("congcuufc.txt");
			ObjectOutputStream oss= new ObjectOutputStream(fos);
			oss.writeObject(DanhSachHocSinh);
			oss.close();
			fos.close();
			System.out.println("ghifile thanh cong");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//DocFile
			try {
				FileInputStream fis= new FileInputStream("congcuufc.txt");
				ObjectInputStream ois= new ObjectInputStream(fis);
				//doc doi tuong
				Object obj= ois.readObject();
				if(obj instanceof ArrayList) {
					List<HocSinh> lis= (ArrayList<HocSinh>)obj;
					for(HocSinh a:lis) {
						System.out.println(a);
					}
				}
				
				ois.close();
				fis.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
class HocSinh implements Serializable{
	private String name;
	private int age;
	public HocSinh() {
		super();
	}
	
	public HocSinh(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
//	Scanner sc= new Scanner(System.in);
//	public void nhap() {
//		System.out.println("name");
//		this.name=sc.nextLine();
//		sc.nextLine();
//		System.out.println("Age:");
//		this.age=sc.nextInt();
//		
//	}

	@Override
	public String toString() {
		return "HocSinh [name=" + name + ", age=" + age + "]";
	}
	
	
}
