package buoi10.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SeverSide {

	public static void main(String[] args) throws IOException {
		//ứng dụng phuc vụ -> luôn sống
		System.out.println(" Sever Start ");
		//đăng ký ứng dụng chạy , tạo đói tượng quẩn lý vơi socket làm việc với client
		ServerSocket server = new ServerSocket(8888);
		System.out.println("Server dang ket noi");
		//chap nhan ket noi tu client gui yeu cau
		//khi client gui yeu cau server ma dong y ket noi nay_> server tao 1 socket de phuc vu rieng cho client nay
		Socket serverSocket= server.accept();
		System.out.println("Server chap nhan ket noi va tao ket noi voi client");
		//tao doi tuong stream doc /input
		Scanner sc= new Scanner(System.in);
		try(
				BufferedReader br= new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
				PrintWriter pw= new PrintWriter(serverSocket.getOutputStream());
				){
		while(true) {	
		char[] chs= new char[1024];
		int isRead=br.read(chs);
		if(isRead!=-1) {
			System.out.println("Server receiver from client :"+ new String(chs));
		}
		//2.server viet  gui cho client
		System.out.println("Server say:");
		String serverString= sc.nextLine();
		pw.write(serverString);
		pw.flush();
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(" Sever End ");

	}

}
