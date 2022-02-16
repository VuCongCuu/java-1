package buoi4.daluong;

import java.util.LinkedList;
import java.util.Random;

public class WaitNo {
	public static void main(String[] args) {
		HangDoi<Integer> hangdoi= new HangDoi(3);
		Producer a= new Producer(hangdoi);
		Consumer ng= new Consumer(hangdoi);
		a.start();
		ng.start();
	}
}
//data chung
class HangDoi<T>{
	private LinkedList<T> queue= new LinkedList<T>();
	private int limit;
	public HangDoi(int limit) {
		super();
		this.limit = limit;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}

	public synchronized void push(T obj) {
		if(queue.size()==limit) {
			System.out.println("Hang doi full");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//them du lieu
		queue.addLast(obj);
		//danh thuc
		notify();
	}
	public synchronized T get() {
		if(queue.size()== 0) {
			System.out.println("hang doi empty");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//lay va xoa luon h=trong ham doi
		T res=queue.removeFirst();
		notify();
		return res;
	}
}
//threads
class Producer extends Thread{
	HangDoi<Integer> hangdoi;

	public Producer(HangDoi<Integer> hangdoi) {
		super();
		this.hangdoi = hangdoi;
	}
	 @Override
	public void run() {
		while(true) {
			Integer obj= createData();
			this.hangdoi.push(obj);
			System.out.println("Pusg: "+ obj );
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//gia lap sinh ra du lieu vao queue
	 private Integer createData() {
		 Random rd= new Random();
		 return rd.nextInt(998)+1;
	 }
	
}
//thread tieu thu / su dung 
class Consumer extends Thread {
	HangDoi<Integer> hangdoi;

	public Consumer(HangDoi<Integer> hangdoi) {
		super();
		this.hangdoi = hangdoi;
	}
	@Override
	public void run() {
		//lay tung phan tu vao truoc cua queue ching va hien thi
		while(true) {
			int obj= hangdoi.get();
			System.out.println("Get: "+obj);
		}
	}
	 
}