package buoi10.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSide {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//thuc hien ket noi voi server
		System.out.println("client start");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		Socket clientSocket= new Socket("localhost", 8888);
		System.out.println("Ket noi thanh cong");
//		Socket serverSocket= server.accept();
//		System.out.println("Server chap nhan ket noi va tao ket noi voi client");
		//tao doi tuong stream doc /input
		try(
				BufferedReader br= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				//tao doi tuong stream ghi /output
				PrintWriter pw=new PrintWriter(clientSocket.getOutputStream());
				){
		while(true) {
			//client gui chuoi len server
			System.out.println("client say: ");
			String clientStr=sc.nextLine();
			pw.write(" Hello Sever");
			pw.flush();
			//2 doc
			char[] chs= new char[1024];
			int isRead=br.read(chs);
			if(isRead!=-1) {
				System.out.println("Client receiver from Server  :"+ new String(chs));
			}
			
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("client end");
	}
}
