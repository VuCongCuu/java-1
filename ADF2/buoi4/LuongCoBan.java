package buoi4;

import buoi4.daluong.MyRunable;
import buoi4.daluong.MyThread;

public class LuongCoBan {
	public static void main(String[] args) {
		System.out.println("Start main thread");
		Thread currThread=Thread.currentThread();
		System.out.println("ten: "+ currThread.getName()+" | trang thai : "+currThread.getState()+"| Priority: "+currThread.getPriority());		
		MyRunable my= new MyRunable();
		Thread t2=new Thread(my);	
		MyThread t1= new MyThread(t2);
		t1.start();
		t2.start();
		//t1.join(); t1 thuc hieenj xog main moi duoc ket thuc
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ten:1 "+" | Priority:"+t1.getPriority());
//		try {
//			t2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("Ten:2 "+" | Priority:"+t2.getPriority());
		System.out.println("End main thread");
	}
}
