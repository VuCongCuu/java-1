package buoi10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcaotionDemo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("Nhap num1");
			int num1=sc.nextInt();
			System.out.println("Nhap num2");
			int num2=sc.nextInt();
			System.out.println(num1 +"/"+num2+"="+ (num1/num2));
			
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			System.out.println("sai roi");
		}
		System.out.println("Ket thuc mani");
	}
	
}
